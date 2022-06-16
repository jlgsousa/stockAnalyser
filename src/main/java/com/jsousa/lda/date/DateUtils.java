package com.jsousa.lda.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
    public static boolean isSameDay(Calendar c1, Calendar c2) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return (sdf.format(c1.getTime()).equals(sdf.format(c2.getTime())));
    }
}
