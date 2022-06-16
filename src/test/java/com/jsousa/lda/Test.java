package com.jsousa.lda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Test {

    @org.junit.Test
    public void test() {
        LocalDateTime ldt = LocalDateTime.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println(formatter.format(ldt));
    }
}
