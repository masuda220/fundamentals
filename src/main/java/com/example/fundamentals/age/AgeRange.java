package com.example.fundamentals.age;

import com.example.fundamentals.category.Range;

enum AgeRange {

    年齢_6歳未満(Range.未満(YearOld.of(6))),
    年齢_6歳以上_20歳未満(Range.以上_未満(YearOld.of(6),YearOld.of(20))),
    年齢_20歳以上(Range.以上(YearOld.of(20)));

    Range<YearOld> value ;

    AgeRange(Range<YearOld> value) {
        this.value = value;
    }
}
