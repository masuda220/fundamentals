package com.example.fundamentals.numeric;

/**
 * unscaled value が long に収まる数値の扱い
 * 小数点付きの金額計算を想定
 * <p>
 * TODO scale の実装
 * TODO 丸めモードの実装
 * TODO toString() の実装
 */

public class Decimal {

    long value;
    int scale;

    public Decimal(long value, int scale) {
        this.value = value;
        this.scale = scale;
    }

    public Decimal add(Decimal other) {
        long x = value;
        long y = other.value;
        long sum = add(x, y);

        return new Decimal(sum, scale);
    }

    private long add(long x, long y) {
        long sum = x + y;
        if ((((sum ^ x) & (sum ^ y))) >= 0L) return sum; // not overflowed

        throw new ArithmeticException("overflow in add");
    }


    public Decimal subtract(Decimal other) {
        long x = value;
        long y = other.value;

        long difference = x - y;

        if (((x ^ y) & (difference ^ x)) >> 63 != 0L)
            throw new ArithmeticException("subtract overflow");

        return new Decimal(difference, scale);
    }

    public Decimal multiply(Decimal other) {
        long x = value;
        long y = other.value;

        long product = x * y;
        if (y != 0L && product / y != x)
            throw new ArithmeticException("拡張する乗数 overflow");

        return new Decimal(product, scale);
    }

    public Decimal divide(Decimal other) {
        //TODO 割り切れない場合
        long x = value;
        long y = other.value;

        return new Decimal(x / y, scale);
    }

    public boolean hasSameValue(Decimal other) {
        if (value != other.value) return false;
        return true;
    }

    public String show() {
        return String.format("scale:%d, value:%d", scale, value);
    }

    public String layout() {
        return new DecimalFormat(this).layout();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    // サポートメソッド

    long raise(long value, int raiseSize) {
        Raise size = Raise.raise(raiseSize);
        System.out.println(size);
        return size.raise(value);
    }

    // Factory methods
    static public Decimal of(int value) {
        return new Decimal(value, 0);
    }

    static public Decimal of(long value) {
        return new Decimal(value, 0);
    }


}
