package myfinance;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        StockFetcher stockFetcher = new StockFetcher();
        stockFetcher.analyseStocks(StockConstants.sAndp500Stocks);

        long stopTime = System.nanoTime();
        System.out.println("It took " + (stopTime - startTime) * 1.0 / 1000000000 / 60 + " minutes to run this baby");
    }

}
