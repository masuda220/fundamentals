package com.example.fundamentals.numeric;

import org.junit.Test;

public class IntegerTest {
    @Test
    public void run() {
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE+1));
    }
}
