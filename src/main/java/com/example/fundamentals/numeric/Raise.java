package com.example.fundamentals.numeric;

public enum Raise {
        zero(1L),
        one(10L),
        two(one.拡張する乗数 * 10),
        three(two.拡張する乗数 * 10),
        four(three.拡張する乗数 * 10),
        five(four.拡張する乗数 * 10);

        long 拡張する乗数 = 1; // 10 ^ 0
        long 拡張可能な限界値 = Long.MAX_VALUE/拡張する乗数;

        Raise(long 拡張する乗数) {
            this.拡張する乗数 = 拡張する乗数;
            this.拡張可能な限界値 = Long.MAX_VALUE / 拡張する乗数;
        }

        long raise(long value) {
            if (Math.abs(value) <= 拡張可能な限界値) return value * 拡張する乗数;

            throw new ArithmeticException("raise size overflow");
        }

        static Raise[] values = values();
        static Raise raise(int size) {
            return values[size];
        }
}
