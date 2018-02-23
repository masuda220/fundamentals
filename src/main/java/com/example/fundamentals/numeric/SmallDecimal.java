package com.example.fundamentals.numeric;

/**
 * unscaled value が long に収まる数値の扱い
 * 小数点付きの金額計算を想定
 *
 * TODO scale の実装
 * TODO 丸めモードの実装
 */

public class SmallDecimal {

    long value;
    int scale;



    public SmallDecimal(long value, int scale) {
        this.value = value;
        this.scale = scale;
    }

    public SmallDecimal add(SmallDecimal other) {
        long x = value;
        long y = other.value;
        long sum = add(x,y);

        return new SmallDecimal(sum, scale);
    }

    private long add(long x, long y) {
        long sum = x + y;
        if ( (((sum ^ x) & (sum ^ y))) >= 0L) return sum; // not overflowed

        throw new ArithmeticException("overflow in add");
    }


    public SmallDecimal subtract(SmallDecimal other) {
        long x = value;
        long y = other.value;

        long difference = x - y;

        if ( ((x ^ y) & (difference ^ x) ) >> 63 != 0L )
            throw new ArithmeticException("subtract overflow");

        return new SmallDecimal(difference,scale);
    }

    public SmallDecimal multiply(SmallDecimal other) {
        long x = value;
        long y = other.value;

        long product = x * y;
        if ( y != 0L && product/y != x )
            throw new ArithmeticException("拡張する乗数 overflow");

        return new SmallDecimal(product,scale);
    }

    public SmallDecimal divide(SmallDecimal other) {
        //TODO 割り切れない場合
        long x = value;
        long y = other.value;

        return new SmallDecimal(x / y, scale);
    }

    public boolean hasSameValue(SmallDecimal other) {
        if( value != other.value) return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("scale:%d, value:%d", scale, value);
    }

    // サポートメソッド
    enum RaiseSize {
        zero(1L),
        one(10L),
        two(one.拡張する乗数 * 10),
        three(two.拡張する乗数 * 10),
        four(three.拡張する乗数 * 10),
        five(four.拡張する乗数 * 10);

        long 拡張する乗数 = 1; // 10 ^ 0
        long 拡張可能な限界値 = Long.MAX_VALUE/拡張する乗数;

        RaiseSize(long 拡張する乗数) {
            this.拡張する乗数 = 拡張する乗数;
            this.拡張可能な限界値 = Long.MAX_VALUE / 拡張する乗数;
        }

        long raise(long value) {
            System.out.println(拡張する乗数);
            System.out.println(value);
            System.out.println(拡張可能な限界値);
            if (Math.abs(value) <= 拡張可能な限界値) return value * 拡張する乗数;

            throw new ArithmeticException("raiseSize overflow");
        }

        static RaiseSize[] values = values();
        static RaiseSize raise(int size) {
            return values[size];
        }
    }

    long raise(long value, int raiseSize) {
        RaiseSize size = RaiseSize.raise(raiseSize);
        System.out.println(size);
        return size.raise(value);
    }

    // Factory methods
    static public SmallDecimal of(int value) {
        return new SmallDecimal(value, 0);
    }

    static public SmallDecimal of(long value) {
        return new SmallDecimal(value, 0);
    }


}
