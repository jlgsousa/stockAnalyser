package com.jsousa.lda;

import com.jsousa.lda.mail.MailSender;
import com.jsousa.lda.stock.StockProperties;
import com.jsousa.lda.stock.StockFetcher;

public class Application {

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();

        String report = new StockFetcher().analyseStocks(StockProperties.getPortfolio());

        if (report != null && report.length() > 0) new MailSender().send(report);

        long stopTime = System.nanoTime();
        System.out.println("This run took " + (stopTime - startTime) * 1.0 / 1000000000 / 60 + " minutes to run");

    }

}
