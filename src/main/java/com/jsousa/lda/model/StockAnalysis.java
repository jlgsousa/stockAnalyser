package com.jsousa.lda.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jsousa.lda.yahoofinance.Stock;

public class StockAnalysis {
    private static final Logger log = LoggerFactory.getLogger(StockAnalysis.class);

    private Stock stock;

    private double averageTrueRange;

    private double longEntry;
    private double longExit;
    private double longStop;

    private double shortEntry;
    private double shortExit;
    private double shortStop;

    private double unitAmount = 4000.0;
    private double investAmount;

    public StockAnalysis(Stock stockObject, double averageTrueRange, double longEntry, double longExit, double shortEntry, double shortExit) {
        this.stock = stockObject;

        this.averageTrueRange = averageTrueRange;
        this.longEntry = longEntry;
        this.longExit = longExit;
        this.shortEntry = shortEntry;
        this.shortExit = shortExit;

        Double currentPrice = stockObject.getQuote().getPrice().doubleValue();
        this.longStop = Math.round(currentPrice - (2 * averageTrueRange));
        this.shortStop = Math.round(currentPrice + (2 * averageTrueRange));
        log.debug("long stop limit: {}, short stop limit: {}", longStop, shortStop);

        this.investAmount = calculateInvestAmount(currentPrice, averageTrueRange, unitAmount);
        log.debug("invest Amount for {}: {}", stockObject.getName(), investAmount);
    }

    public Double getCurrentPrice() {
        return stock.getQuote().getPrice().doubleValue();
    }

    public Double getHigh() {
        return stock.getQuote().getDayHigh().doubleValue();
    }

    public Double getLow() {
        return stock.getQuote().getDayLow().doubleValue();
    }

    public String getStockName() {
        return stock.getName();
    }

    public double getAverageTrueRange() {
        return averageTrueRange;
    }

    public double getLongEntry() {
        return longEntry;
    }

    public double getLongExit() {
        return longExit;
    }

    public double getLongStop() {
        return longStop;
    }

    public double getShortEntry() {
        return shortEntry;
    }

    public double getShortExit() {
        return shortExit;
    }

    public double getShortStop() {
        return shortStop;
    }

    public double getInvestAmount() {
        return investAmount;
    }

    private Integer calculateInvestAmount(Double currentPrice, Double averageTrueRange, Double unitAmount) {
        double investAmount = unitAmount / ((averageTrueRange / currentPrice) * 100);
        log.info("Invest unit is {}", investAmount);
        return Math.toIntExact(Math.round(investAmount));
    }

    public String generateAnalysisString(String longTradingStocks, String shortTradingStocks) {
        Double currentHigh = this.getHigh();
        Double currentLow = this.getLow();
        String stockSymbol = this.stock.getSymbol();

        StringBuilder report = new StringBuilder();

        if (!longTradingStocks.contains(stockSymbol) && currentHigh >= this.getLongEntry()) {
            log.info("Warning for buy position in {}: {}", this.getStockName(), this.getAverageTrueRange());
            report.append("- Buy the stock ").append(getStockName()).append(" (").append(stockSymbol).append(")")
                    .append(" with an amount of ").append(Math.round(this.getInvestAmount())).append("€")
                    .append(" and a 2N stop loss order at ").append(this.getLongStop()).append("€ ");
        } else if (longTradingStocks.contains(stockSymbol) && (currentLow < this.getLongStop() || currentLow < this.getLongExit())) {
            log.info("Warning for exit buy position in {}: Current price {}, Long Stop:{}, Long Exit:{}", stockSymbol, this.getLongStop(), this.getLongExit());
            report.append("- Sell the stock ").append(getStockName()).append(" (").append(stockSymbol).append(") ");
        }

        if (!shortTradingStocks.contains(stockSymbol) && currentLow <= this.getShortEntry()) {
            log.info("Warning for sell position in {}: {}", stockSymbol, this.getInvestAmount());
            report.append("- Short the stock ").append(getStockName()).append(" (").append(stockSymbol).append(")")
                    .append(" with an amount of ").append(Math.round(this.getInvestAmount())).append("€")
                    .append(" and a 2N stop loss order at ").append(this.getShortStop()).append("€ ");
        } else if (shortTradingStocks.contains(stockSymbol) && (currentHigh > this.getShortStop() || currentHigh > this.getShortExit())) {
            log.info("Warning for exit sell position in {}: Current price {}, Short Stop:{}, Short Exit:{}", stockSymbol, this.getShortStop(), this.getShortExit());
            report.append("- Buy to close the stock ").append(getStockName()).append(" (").append(stockSymbol).append(") ");
        }

        return report.toString();
    }
}
