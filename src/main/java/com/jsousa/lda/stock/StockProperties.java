package com.jsousa.lda.stock;

import com.jsousa.lda.yahoofinance.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class StockProperties {
    private static final String PORTFOLIO_STOCKS = "portfolio.stocks";
    private static final String LONG_TRADING_STOCKS = "long.trading.stocks";
    private static final String SHORT_TRADING_STOCKS = "short.trading.stocks";
    private static final String WATCHER_EMAILS = "watcher.emails";

    private static final Logger log = LoggerFactory.getLogger(Stock.class);

    private static Properties properties = new Properties();

    static {
        File propFile = new File("application.properties");

        try {
            properties.load(new FileInputStream(propFile));
        } catch (IOException e) {
            log.error("Not able to load application.properties");
        }
    }

    public static String[] getPortfolio() throws Exception {
        String portfolio = properties.getProperty(PORTFOLIO_STOCKS);
        if (portfolio == null || portfolio.length() == 0) {
            throw new Exception("Portfolio is empty");
        } else {
            return portfolio.split(",");
        }
    }

    public static String getLongStocks() {
        return properties.getProperty(LONG_TRADING_STOCKS);
    }

    public static String getShortStocks() {
        return properties.getProperty(SHORT_TRADING_STOCKS);
    }

    public static String getWatcherEmails() {
        return properties.getProperty(WATCHER_EMAILS);
    }
}
