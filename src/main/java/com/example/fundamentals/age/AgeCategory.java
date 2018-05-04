package com.example.fundamentals.age;

import com.example.fundamentals.category.Range;

import static com.example.fundamentals.age.AgeThreshold.*;

public enum AgeCategory {

    幼児(六歳.未満()),
    子供(六歳.以上(), 二十歳.未満()),
    大人(二十歳.以上());

    Range<YearOld> range;

    AgeCategory(Range range) {
        this.range = range;
    }

    // TODO 合成する
    AgeCategory(Range lower, Range upper) {
        this.range = lower;
    }
}
