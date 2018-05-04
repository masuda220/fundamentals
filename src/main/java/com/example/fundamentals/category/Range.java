package com.example.fundamentals.category;

import static com.example.fundamentals.category.BoundType.以上;
import static com.example.fundamentals.category.BoundType.以下;
import static com.example.fundamentals.category.BoundType.未満;
import static com.example.fundamentals.category.BoundType.超;

public class Range<T extends Ordinal<T>> {

    T lower ;
    BoundType lowerType;
    T upper ;
    BoundType upperType;

    private Range(T lower, BoundType lowerType, T upper , BoundType upperType) {
        this.lower = lower;
        this.lowerType = lowerType;
        this.upper = upper;
        this.upperType = upperType;
    }

    public T upper() {
        return upper;
    }

    public T lower() {
        return lower;
    }

    @Override
    public String toString() {
        return String.format("%s%s～%s%s", lower, lowerType, upper, upperType);
    }

    public static <T extends Ordinal<T>> Range<T> 未満(T upper) {
        return new Range(null, null, upper, 未満);
    }

    public static <T extends Ordinal<T>> Range<T> 以下(T upper) {
        return new Range(null, null, upper, 以下);
    }

    public static <T extends Ordinal<T>> Range<T> 以上_以下(T lower, T upper) {
        if( lower.compareTo(upper) > 0 ) throw new IllegalArgumentException();
        return new Range(lower, 以上, upper, 以下);
    }

    public static <T extends Ordinal<T>> Range<T> 以上_未満(T lower, T upper) {
        if( lower.compareTo(upper) >= 0 ) throw new IllegalArgumentException();
        return new Range(lower, 以上, upper, 未満);
    }

    public static <T extends Ordinal<T>> Range<T> 超_以下(T lower, T upper) {
        if( lower.compareTo(upper) >= 0 ) throw new IllegalArgumentException();
        return new Range(lower, 超, upper, 以下);
    }

    public static <T extends Ordinal<T>> Range<T> 超_未満(T lower, T upper) {
        if( lower.compareTo(upper.previous()) >= 0 ) throw new IllegalArgumentException();
        return new Range(lower, 超, upper, 未満);
    }

    public static <T extends Ordinal<T>> Range<T> 以上(T lower) {
        return new Range(lower, 以上, null, null);
    }

    public static <T extends Ordinal<T>> Range<T> 超(T lower) {
        return new Range(lower, 超, null, null);
    }

}
