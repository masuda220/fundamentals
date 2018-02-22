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
            throw new ArithmeticException("倍数 overflow");

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
    enum Shift {
        zero(0),
        one(1),
        two(2),
        three(3),
        four(4),
        five(5);

        long 倍数 = 1; // 10 ^ 0
        long 限界値 = Long.MAX_VALUE;

        Shift(int size) {
            if( size == 0 ) return; // 初期値

            倍数 = 10 ^ size;
            限界値 = Long.MAX_VALUE / size;
        }
    }

    long shift(long value, Shift shift) {
        if (Math.abs(value) <= shift.限界値) return value * shift.倍数;

        throw new ArithmeticException("shift overflow");
    }

    // Factory methods
    static public SmallDecimal of(int value) {
        return new SmallDecimal(value, 0);
    }

    static public SmallDecimal of(long value) {
        return new SmallDecimal(value, 0);
    }


}
