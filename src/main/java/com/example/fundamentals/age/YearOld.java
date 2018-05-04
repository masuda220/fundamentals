package com.example.fundamentals.age;

import com.example.fundamentals.category.Ordinal;

/**
 * 歳
 */
public class YearOld implements Comparable<YearOld>, Ordinal<YearOld> {
    int value;

    private YearOld(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%d歳", value);
    }

    public static YearOld of(int value) {
        return new YearOld(value);
    }

    @Override
    public int compareTo(YearOld other) {
        if( value < other.value ) return -1;
        if( value == other.value ) return 0;
        return 1;
    }

    @Override
    public YearOld next() {
        return new YearOld(value + 1);
    }

    @Override
    public YearOld previous() {
        if( value - 1 < 0 ) throw new IllegalStateException("下限を超える");
        return new YearOld(value - 1);
    }
}
