package com.jsousa.lda.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsousa.lda.date.DateUtils;
import com.jsousa.lda.io.FileHandler;
import com.jsousa.lda.model.StockAnalysis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jsousa.lda.yahoofinance.Stock;
import com.jsousa.lda.yahoofinance.histquotes.HistoricalQuote;
import com.jsousa.lda.yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StockAnalyser {

    public static final String HISTORICAL_QUOTES = "historicalQuotes";
    public static final String AVERAGE_TRUE_RANGE = "averageTrueRange";
    public static final String STOCK_ANALYSIS = "stockAnalysis";

    private static final Logger log = LoggerFactory.getLogger(StockAnalyser.class);

    public StockAnalysis analyseStock(Stock stockObject, int entryLength, int exitLength) throws IOException, InterruptedException {

        String historyQuoteString = FileHandler.readFile(stockObject.getSymbol());

        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();

        List<HistoricalQuote> historyQuotes;
        HistoricalQuote twoDaysAgo;
        HistoricalQuote yesterday;

        double shortEntry = Double.MAX_VALUE;
        double shortExit = Double.MIN_VALUE;
        double longEntry = Double.MIN_VALUE;
        double longExit = Double.MAX_VALUE;

        Double volatility = null;
        Double averageTrueRange = null;

        if ("".equals(historyQuoteString)) {
            from.add(Calendar.DAY_OF_WEEK, - (entryLength + 23));

            historyQuotes = getHistory(stockObject, from, to);
        } else {

            ObjectMapper mapper = new ObjectMapper();

            JsonNode jsonNode = mapper.readTree(historyQuoteString);

            averageTrueRange = jsonNode.get(AVERAGE_TRUE_RANGE).doubleValue();

            historyQuotes = mapper.readValue(jsonNode.get(HISTORICAL_QUOTES).toString(), new TypeReference<>(){});

            HistoricalQuote lastSavedEntry = historyQuotes.get(historyQuotes.size() - 1);

            if (to.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                from.add(Calendar.DAY_OF_WEEK, -3);
            } else {
                from.add(Calendar.DAY_OF_WEEK, -1);
            }

            if (!DateUtils.isSameDay(lastSavedEntry.getDate(), from)) {
                historyQuotes.remove(0);
                historyQuotes.addAll(getHistory(stockObject, from, to));
            } else {
                log.info("All history quotes are saved no need to retrieve it again");
            }
        }

        while (historyQuotes.size() > entryLength) historyQuotes.remove(0);

        int exitIndex = entryLength - exitLength + 1;
        int size = 1;
        for (int i = 1; i < historyQuotes.size(); i++) {
            twoDaysAgo = historyQuotes.get(i - 1);
            yesterday = historyQuotes.get(i);

            if (twoDaysAgo.isInvalid() || yesterday.isInvalid()) {
                log.error("Invalid history quote from {} at the date {} or {}, please fix it", stockObject.getSymbol(),
                        twoDaysAgo.getDate(), yesterday.getDate());
                continue;
            }

            double yesterdaysHigh = yesterday.getHigh().doubleValue();
            double yesterdaysLow = yesterday.getLow().doubleValue();

            if (yesterdaysHigh > longEntry) longEntry = yesterdaysHigh;
            if (yesterdaysLow < shortEntry) shortEntry = yesterdaysLow;

            if (i > exitIndex) {
                if (yesterdaysLow < longExit) longExit = yesterdaysLow;
                if (yesterdaysHigh > shortExit) shortExit = yesterdaysHigh;
            }

            log.debug("Long entry: {}, Long exit: {}, Short entry: {}, Short exit: {}", longEntry, longExit, shortEntry, shortExit);

            volatility = calculateVolatility(twoDaysAgo, yesterday);

            averageTrueRange = (averageTrueRange == null) ? volatility : calculateAverageTrueRange(averageTrueRange, volatility, size);
            log.debug("ATR: {}", averageTrueRange);

            size++;
        }

        StockAnalysis stockAnalysis = new StockAnalysis(stockObject, averageTrueRange, longEntry, longExit, shortEntry, shortExit);

        if (volatility != null) saveAnalysis(stockObject.getSymbol(), stockAnalysis, historyQuotes);
        else log.warn("No data for {} skipping save analysis", stockAnalysis.getStockName());

        return stockAnalysis;
    }

    private List<HistoricalQuote> getHistory(Stock stock, Calendar from, Calendar to) throws InterruptedException {
        List<HistoricalQuote> historyQuotes = new ArrayList<>();
        int attempt = 1;
        int maxAttempts = 10;
        int interval = 10000;
        boolean problemHappened = true;

        while (problemHappened && attempt <= maxAttempts) {
            problemHappened = false;
            try {
                if (to == null) {
                    historyQuotes = stock.getHistory(from);
                } else {
                    historyQuotes = stock.getHistory(from, to, Interval.DAILY);
                }
            } catch (Exception e) {
                problemHappened = true;
                log.error("Exception while getting history from {}, retrying attempt {}", stock.getSymbol(), attempt, e);
                Thread.sleep(interval);
                attempt++;
            }
        }

        if (attempt > maxAttempts) log.error("Maximum Attempts was reached, returning empty history to {}", stock.getSymbol());

        return historyQuotes;
    }

    private Double calculateVolatility(HistoricalQuote yesterday, HistoricalQuote today) {
        double todayHighLow = Math.abs(today.getHigh().doubleValue() - today.getLow().doubleValue());
        double yesterdayCloseTodayHigh = Math.abs(yesterday.getClose().doubleValue() - today.getHigh().doubleValue());
        double yesterdayCloseTodayLow = Math.abs(yesterday.getClose().doubleValue() - today.getLow().doubleValue());

        return Math.max(Math.max(yesterdayCloseTodayHigh, yesterdayCloseTodayLow), todayHighLow);
    }

    private Double calculateAverageTrueRange(Double lastAtr, Double currentVolatility, int size) {
        //m_n = m_n-1 + (a_n - m_n-1) / k
        return lastAtr + ((currentVolatility - lastAtr) / size);
    }

    private void saveAnalysis(String stockSymbol, StockAnalysis stockAnalysis, List<HistoricalQuote> historicalQuotes) {
        String savingString = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            String historicalQuotesString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(historicalQuotes);
            String stockAnalysisString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(stockAnalysis);

            savingString = "{ \"" + HISTORICAL_QUOTES + "\":" + historicalQuotesString + ",\n\""
                    + AVERAGE_TRUE_RANGE + "\":" + stockAnalysis.getAverageTrueRange() + ",\n\""
                    + STOCK_ANALYSIS + "\":" + stockAnalysisString + "}";
            FileHandler.writeFile(stockSymbol, savingString);
        } catch (JsonProcessingException e) {
            log.error("Not able to write analysis {} on file, skipping save", savingString);
        }
    }
}
