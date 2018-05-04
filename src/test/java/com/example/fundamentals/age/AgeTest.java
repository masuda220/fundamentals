package com.example.fundamentals.age;

import com.example.fundamentals.category.Range;
import org.junit.Test;

public class AgeTest {

    Age age = Age.parse("1964-03-21");
    Range<YearOld> 幼児in未満 = Range.未満(YearOld.of(6));
    Range<YearOld> 幼児in以下 = Range.以下(YearOld.of(6));
    Range<YearOld> 大人in以上 = Range.以上(YearOld.of(20));
    Range<YearOld> 大人in超 = Range.超(YearOld.of(20));

    @Test
    public void year() {
        System.out.println(age.yearsOld());
    }

    @Test
    public void rangeTest() {
        print(幼児in未満);
        print(幼児in以下);
        print(大人in以上);
        print(大人in超);
    }

    @Test
    public void 以上未満 () {
        Range<YearOld> range = Range.以上_未満(YearOld.of(6),YearOld.of(7));
        print(range);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fail以上未満 () {
        Range.以上_未満(YearOld.of(6),YearOld.of(6));
    }

    @Test
    public void 以上以下 () {
        Range<YearOld> range = Range.以上_以下(YearOld.of(6),YearOld.of(6));
        print(range);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fail以上以下 () {
        Range.以上_以下(YearOld.of(6),YearOld.of(5));
    }

    @Test
    public void 超以下 () {
        Range<YearOld> range = Range.超_以下(YearOld.of(6),YearOld.of(7));
        print(range);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fail超以下 () {
        Range.超_以下(YearOld.of(6),YearOld.of(6));
    }

    @Test
    public void 超未満 () {
        Range<YearOld> range = Range.超_未満(YearOld.of(6),YearOld.of(8));
        print(range);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fail超未満 () {
        Range.超_未満(YearOld.of(6),YearOld.of(7));
    }

    private void print(Range range) {
        System.out.println(range);
    }
}