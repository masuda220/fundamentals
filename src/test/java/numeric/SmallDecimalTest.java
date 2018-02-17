package numeric;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmallDecimalTest {

    static final SmallDecimal max = SmallDecimal.of(Long.MAX_VALUE);
    static final SmallDecimal min = SmallDecimal.of(Long.MIN_VALUE);

    static final SmallDecimal halfOfMax = SmallDecimal.of(Long.MAX_VALUE/2);
    static final SmallDecimal halfOfMin = SmallDecimal.of(Long.MIN_VALUE/2);

    SmallDecimal one = SmallDecimal.of(1L);
    SmallDecimal two = SmallDecimal.of(2L);
    SmallDecimal three = SmallDecimal.of(3L);
    SmallDecimal six = SmallDecimal.of(6L);

    SmallDecimal negateOne = SmallDecimal.of(-1L);

    @Test
    public void add() {
        SmallDecimal result = one.add(one);
        assertTrue(result.hasSameValue(two));
    }

    @Test(expected = ArithmeticException.class)
    public void addOverflow() {
        SmallDecimal result = max.add(one);
    }

    @Test
    public void subtract() {
        SmallDecimal result = two.subtract(one);
        assertTrue(result.hasSameValue(one));
    }

    @Test(expected = ArithmeticException.class)
    public void subtractUnderflow() {
        SmallDecimal result = min.subtract(one);
    }

    @Test(expected = ArithmeticException.class)
    public void subtractOverflow() {
        SmallDecimal result = max.subtract(negateOne);
    }

    @Test
    public void multiply() {
        SmallDecimal result = two.multiply(three);
        assertTrue(result.hasSameValue(six));
    }

    @Test(expected = ArithmeticException.class)
    public void multiplyOverflow() {
        SmallDecimal result = halfOfMax.multiply(three);
    }

    @Test(expected = ArithmeticException.class)
    public void multiplyUnderflow() {
        SmallDecimal result = halfOfMin.multiply(three);
    }


    @Test
    public void divide() {
        SmallDecimal result = six.divide(three);
        assertTrue(result.hasSameValue(two));
    }
}