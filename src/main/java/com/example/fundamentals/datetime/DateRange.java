package com.example.fundamentals.datetime;

import java.time.LocalDate;

public class DateRange {
    LocalDate from;
    LocalDate to;

    public DateRange(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public boolean includes(LocalDate date) {
        if(date.isAfter(to)) return false;
        if(date.isBefore(from)) return false;
        return true;
    }

    //TODO from または to がオープン（未指定）の場合
}
