package com.jsousa.lda.stock;

import com.jsousa.lda.model.StockAnalysis;
import com.jsousa.lda.yahoofinance.histquotes.HistoricalQuote;
import com.jsousa.lda.yahoofinance.histquotes.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jsousa.lda.yahoofinance.Stock;
import com.jsousa.lda.yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.*;

public class StockFetcher {
    private static final Logger log = LoggerFactory.getLogger(StockFetcher.class);

    private static final String REPORT_INTRO = "Dear Mr. João Sousa\n\nRegarding your portfolio we advise you to:\n";

    private int entryPeriods = 56;
    private int exitPeriods = 22;

    private String longTradingStocks;
    private String shortTradingStocks;

    private StringBuilder report = new StringBuilder();

    private StockAnalyser stockAnalyser = new StockAnalyser();

    public StockFetcher() {
        longTradingStocks = StockProperties.getLongStocks();
        shortTradingStocks = StockProperties.getShortStocks();
    }

    public String analyseStocks(String[] stocks) throws IOException, InterruptedException {
        Map<String, Stock> stockMap = getStockMap(stocks);

        int stockNumber = 1;
        int stockLength = stockMap.size();

        report.append(REPORT_INTRO);

        Set<StockAnalysis> analyses = new HashSet<>();
        for (Map.Entry<String, Stock> entry : stockMap.entrySet()) {
            Stock stockObject = stockMap.get(entry.getKey());
            log.debug("Stock number " + stockNumber);

            if ((stockLength - stockNumber) == 0) log.debug("No more stocks to go");
            else log.debug("Still " + (stockLength - stockNumber) + " stocks to go");

            stockNumber++;

            analyses.add(stockAnalyser.analyseStock(stockObject, entryPeriods, exitPeriods));
        }

        report.append(generateReport(analyses));
        report.append("\n");

        return REPORT_INTRO.equals(report.toString()) ? "" : report.toString();
    }

    private Map<String, Stock> getStockMap(String[] stocks) throws InterruptedException {
        Map<String, Stock> stockMap = new HashMap<>();
        int attempt = 1;
        int maxAttempts = 10;
        int interval = 10000;
        boolean problemHappened = true;

        while (problemHappened && attempt <= maxAttempts) {
            problemHappened = false;
            try {

                stockMap = YahooFinance.get(stocks);

            } catch (Exception e) {
                problemHappened = true;
                log.error("Exception while getting stock map, retrying attempt {}", attempt, e);
                Thread.sleep(interval);
                attempt++;
            }
        }

        if (attempt > maxAttempts) log.error("Maximum attempt number reached, returning stocks map");

        return stockMap;
    }

    private String generateReport(Set<StockAnalysis> analyses) {
        StringBuilder builder = new StringBuilder();
        String singleReport;
        for (StockAnalysis analysis : analyses) {
            singleReport = analysis.generateAnalysisString(longTradingStocks, shortTradingStocks);
            if (singleReport.length() > 0) builder.append("\n").append(singleReport);
        }
        return builder.toString();
    }

}
