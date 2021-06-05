package myfinance;

import yahoofinance.Stock;

public class StockEvaluator {
    public static boolean isInterestingStochastic(Stock stockObject, double stochastic) {
        double minimum = 30;
        double maximum = 80;

        boolean isInteresting = false;
        if (stochastic > minimum && stochastic < maximum) {
            System.out.println(stockObject.getName() + "(" + stockObject.getSymbol() + ") has an interesting stochastic value of " + stochastic);
            isInteresting = true;
        }

        return isInteresting;
    }
}
