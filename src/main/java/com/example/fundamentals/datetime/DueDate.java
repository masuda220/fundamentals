package com.example.fundamentals.datetime;

import java.time.LocalDate;

/**
 * 期日
 */
public class DueDate {

    LocalDate value;

    boolean isExpired() {
        LocalDate today = LocalDate.now();
        return today.isAfter(value);
    }
}
