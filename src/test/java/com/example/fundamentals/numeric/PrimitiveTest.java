package com.example.fundamentals.numeric;

import org.junit.Test;

public class PrimitiveTest {
    @Test
    public void charTest() {
        char one = 'A';
        char other = '0';

        //char result = one + other; 型が一致しない
        char result = (char) (one + other);

        System.out.println( result ); // 文字
        System.out.println( one + other ); // 数値
    }
}
