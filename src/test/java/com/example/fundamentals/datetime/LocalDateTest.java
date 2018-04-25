package com.example.fundamentals.datetime;

import org.junit.Test;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class LocalDateTest {
    @Test
    public void max() {
        Period max = Period.of(9999, 99, 99);
        System.out.println(max);
        Period normalized = max.normalized();
        System.out.println(normalized);

        System.out.println(max.getDays());

        LocalDate today = LocalDate.now();
        LocalDate oneDay = today.plus(max);

        LocalDate epoch = LocalDate.ofEpochDay(0);
        System.out.println(epoch);

        Period min = Period.of(0000, 0, 0);
        System.out.println(min);

        LocalDate maxDate = LocalDate.ofEpochDay(0).plus(Period.of(0000, 0, 0));
        System.out.println(maxDate);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        calendar.set(0000, 0, 0);
        Date oldDate = calendar.getTime();
        System.out.println(oldDate);
        calendar.set(9999, 99, 99);
        System.out.println(calendar.getTime());
    }
}
