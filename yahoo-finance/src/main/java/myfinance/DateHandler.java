package myfinance;

import yahoofinance.histquotes.HistoricalQuote;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DateHandler {
    public static List<HistoricalQuote> filterInBetweenDays(Integer dayInterval, List<HistoricalQuote> quotes) {
        List<HistoricalQuote> copy = new ArrayList<>(quotes);

        int index = 1;

        while (copy.size() >= index) {
            int firstIndex = copy.size() - index;

            HistoricalQuote quote = copy.get(firstIndex);
            Calendar to = (Calendar) quote.getDate().clone();
            Calendar from = (Calendar) to.clone();
            from.add(Calendar.DAY_OF_MONTH, -dayInterval);

            boolean removedValue = false;
            for (int j = firstIndex - 1; j >= 0; j--) {
                if (copy.get(j).getDate().after(from) && copy.get(j).getDate().before(to)) {
                    copy.remove(j);
                    removedValue = true;
                } else if (removedValue) {
                    break;
                }
            }
            index++;
        }
        return copy;
    }

}
