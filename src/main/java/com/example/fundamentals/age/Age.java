package com.example.fundamentals.age;

import java.time.LocalDate;
import java.time.Period;

/**
 * 年齢
 */
public class Age {
    LocalDate dateOfBirth;

    private Age(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    private Period period() {
        LocalDate today = LocalDate.now();
        return dateOfBirth.until(today);
    }

    public YearOld yearsOld() {
        return YearOld.of(period().getYears());
    }

    @Override
    public String toString() {
        return yearsOld().toString();
    }

    public static Age parse(String dateText) {
        return new Age(LocalDate.parse(dateText));
    }
}
