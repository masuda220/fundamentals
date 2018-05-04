package com.example.fundamentals.age;

import com.example.fundamentals.category.Range;

public enum AgeThreshold {
    六歳(6),
    二十歳(20);

    YearOld value ;

    AgeThreshold(int value) {
        this.value = YearOld.of(value);
    }

    Range<YearOld> 未満() {
        return Range.未満(value);
    }

    Range<YearOld> 以上() {
        return Range.以上(value);
    }
}
