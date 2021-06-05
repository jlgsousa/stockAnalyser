package myfinance;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class StockFetcher {

    private int periods;

    public void analyseStocks(String[] stocks) throws IOException {
        periods = 14;

        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.WEEK_OF_MONTH, -20); // from 3 months ago

        Map<String, Stock> stockMap = YahooFinance.get(stocks);

        List<String> watchList = new ArrayList<>();

        int stockNumber = 1;
        int stockLength = stockMap.size();

        for (Map.Entry<String, Stock> entry : stockMap.entrySet()) {
            Stock stockObject = stockMap.get(entry.getKey());
            System.out.println("Stock number " + stockNumber);
            if ((stockLength - stockNumber) == 0) System.out.println("No more stocks to go");
            else System.out.println("Still " + (stockLength - stockNumber) + " stocks to go");

            stockNumber++;
            stockLength--;
            if (stockObject == null) {
                System.out.println("Stock " + entry.getKey() + " not found. Skipping...");
                continue;
            }

            try {
                File stockFileWriter = new File(stockObject.getName());
                if (stockFileWriter.createNewFile()) {
                    System.out.println("File created: " + stockFileWriter.getName());
                } else {
                    System.out.println("File " + stockFileWriter.getName() + " already exists, Skipping ...");
                    continue;
                }

                List<HistoricalQuote> historyQuotes = DateHandler.filterInBetweenDays(7, stockObject.getHistory(from, to, Interval.DAILY));

                List<Double> lows = new ArrayList<>();
                List<Double> highs = new ArrayList<>();

                List<Double> stochasticRawList = new ArrayList<>();
                List<Double> weeklyStochasticList = new ArrayList<>();
                List<Double> averageList = new ArrayList<>();

                HistoricalQuote oldQuote = null;
                try {
                    FileWriter stockObjectWriter = new FileWriter(stockObject.getName());

                    int index = 0;
                    boolean isEngulfingCandle = false;
                    for (HistoricalQuote quote : historyQuotes) {
                        if (index < periods) {
                            lows.add(index, quote.getLow().doubleValue());
                            highs.add(index, quote.getHigh().doubleValue());
                        } else {
                            lows.set(index % periods, quote.getLow().doubleValue());
                            highs.set(index % periods, quote.getHigh().doubleValue());
                        }

                        Double lowest = lows.stream().min(Double::compareTo).get();
                        Double highest = highs.stream().max(Double::compareTo).get();

                        double stochasticRaw = (quote.getClose().doubleValue() - lowest) / (highest - lowest) * 100;
                        stochasticRawList.add(stochasticRaw);

                        double weeklyStochastic = (stochasticRawList.get(index) + stochasticRawList.get(Math.max(0, index - 1)) + stochasticRawList.get(Math.max(0, index - 2))) / 3;
                        weeklyStochasticList.add(weeklyStochastic);

                        double average = (weeklyStochasticList.get(index) + weeklyStochasticList.get(Math.max(0, index - 1)) + weeklyStochasticList.get(Math.max(0, index - 2))) / 3;
                        averageList.add(average);

                        boolean overAverageVolume = (quote.getVolume().compareTo(stockObject.getQuote().getAvgVolume()) >= 1);

                        boolean isGreenCandle = (quote.getClose().compareTo(quote.getOpen()) >= 1);
                        boolean isBigCandle = (quote.getClose().subtract(quote.getOpen()).divide(quote.getHigh().subtract(quote.getLow()), RoundingMode.CEILING))
                                .compareTo(BigDecimal.valueOf(0.5)) >= 1;
                        boolean isHigherThanPreviousCandle = false;
                        if (oldQuote != null) isHigherThanPreviousCandle = (quote.getClose().compareTo(oldQuote.getClose()) >= 1);

                        isEngulfingCandle = isGreenCandle && isBigCandle && isHigherThanPreviousCandle;

                        stockObjectWriter.write("Date: " + quote.getDate().getTime() + "; Stochastic %K: " + weeklyStochastic + "; %D: " + average
                                + "; overAverageVolume: " + overAverageVolume + "; isBigCandle: " + isBigCandle + "; isEngulfingCandle: "
                                + isEngulfingCandle + "\n");

                        index++;
                        oldQuote = quote;
                    }

                    stockObjectWriter.close();

                    if (StockEvaluator.isInterestingStochastic(stockObject, stochasticRawList.get(stochasticRawList.size() - 1)) && isEngulfingCandle) {
                        watchList.add(stockObject.getSymbol());
                    }

                } catch (IOException e) {
                    System.out.println("An error while accessing file" + stockObject.getName());
                    e.printStackTrace();
                }
            } catch (Exception e) {
                System.out.println("Problem while fetching history for " + stockObject.getName() + " skipping...");
            }
        }

        printWatchlist(watchList);
    }

    private void printWatchlist(List<String> watchList) {
        System.out.println("\nPrinting watchlist..");
        try {
            File myObj = new File("watchlist/watchlist.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File watchlist/watchlist.txt already exists, overriding content ...");
            }

            FileWriter myWriter = new FileWriter("watchlist/watchlist.txt");
            for (String stock : watchList) {
                myWriter.write(stock + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Problem at writing the watchlist into a file");
        }
    }

}
