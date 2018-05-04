package com.example.fundamentals.age;

import java.time.LocalDate;
import java.time.Period;

/**
 * 誕生日
 */
public class DateOfBirth {
    LocalDate dateOfBirth;

    private DateOfBirth(LocalDate dateOfBirth) {
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

    public static DateOfBirth parse(String dateText) {
        return new DateOfBirth(LocalDate.parse(dateText));
    }
}
