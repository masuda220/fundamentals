package com.example.fundamentals.numeric;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecimalTest {

    static final Decimal max = Decimal.of(Long.MAX_VALUE);
    static final Decimal min = Decimal.of(Long.MIN_VALUE);

    static final Decimal halfOfMax = Decimal.of(Long.MAX_VALUE / 2);
    static final Decimal halfOfMin = Decimal.of(Long.MIN_VALUE / 2);

    Decimal one = Decimal.of(1L);
    Decimal two = Decimal.of(2L);
    Decimal three = Decimal.of(3L);
    Decimal six = Decimal.of(6L);

    Decimal negateOne = Decimal.of(-1L);

    @Test
    public void show() {
        System.out.println("one:" + one.show());
        System.out.println("negate one:" + negateOne.show());
    }

    @Test
    public void layout() {

        Decimal extraLarge = new Decimal(123456789L, 0);
        System.out.println(extraLarge.show());
        System.out.println(extraLarge.layout());

        Decimal large = new Decimal(123456789L, 3);
        System.out.println(large.show());
        System.out.println(large.layout());

        Decimal medium = new Decimal(1234L, 2);
        System.out.println(medium.show());
        System.out.println(medium.layout());

        Decimal small = new Decimal(123L, 5);
        System.out.println(small.show());
        System.out.println(small.layout());

        Decimal negateSmall = new Decimal(-789L, 5);
        System.out.println(negateSmall.show());
        System.out.println(negateSmall.layout());
    }

    @Test
    public void add() {
        Decimal result = one.add(one);
        assertTrue(result.hasSameValue(two));
    }

    @Test(expected = ArithmeticException.class)
    public void addOverflow() {
        Decimal result = max.add(one);
    }

    @Test
    public void subtract() {
        Decimal result = two.subtract(one);
        assertTrue(result.hasSameValue(one));
    }

    @Test(expected = ArithmeticException.class)
    public void subtractUnderflow() {
        Decimal result = min.subtract(one);
    }

    @Test(expected = ArithmeticException.class)
    public void subtractOverflow() {
        Decimal result = max.subtract(negateOne);
    }

    @Test
    public void multiply() {
        Decimal result = two.multiply(three);
        assertTrue(result.hasSameValue(six));
    }

    @Test(expected = ArithmeticException.class)
    public void multiplyOverflow() {
        Decimal result = halfOfMax.multiply(three);
    }

    @Test(expected = ArithmeticException.class)
    public void multiplyUnderflow() {
        Decimal result = halfOfMin.multiply(three);
    }


    @Test
    public void divide() {
        Decimal result = six.divide(three);
        assertTrue(result.hasSameValue(two));
    }

    // unscaled value の拡張
    @Test
    public void raiseZeroSuccess() {
        Raise.zero.raise(Long.MAX_VALUE);
    }

    @Test
    public void raiseOneSuccess() {
        long source = (Long.MAX_VALUE / 10L);
        Raise.one.raise(source);
    }

    @Test(expected = ArithmeticException.class)
    public void raiseOneOverflow() {
        Raise.one.raise(Long.MAX_VALUE);
    }

    @Test(expected = ArithmeticException.class)
    public void raiseTwoOverflow() {
        Raise.two.raise((Long.MAX_VALUE / 100L) + 1);
    }

    @Test(expected = ArithmeticException.class)
    public void raiseTwoNegateOverflow() {
        Raise.two.raise((Long.MIN_VALUE / 100L) - 1);
    }
}