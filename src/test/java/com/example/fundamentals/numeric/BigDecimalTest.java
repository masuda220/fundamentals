package com.example.fundamentals.numeric;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalTest {
    @Test
    public void precision() {
        MathContext context = new MathContext(3, RoundingMode.HALF_UP);
        BigDecimal some = new BigDecimal("12345",context);
        BigDecimal other = new BigDecimal("76891",context);

        System.out.println(some.add(other).toPlainString());
        System.out.println(some.multiply(other).toPlainString());
        System.out.println(some.multiply(other,context).toPlainString());
        System.out.println(some.divide(other,context).toPlainString());

    }
}
