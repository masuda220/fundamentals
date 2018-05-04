package com.example.fundamentals.category;

public interface Ordinal<T> extends Comparable<T> {

    T next() ;
    T previous() ;
}
