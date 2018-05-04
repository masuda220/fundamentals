package com.example.fundamentals.age;

import static com.example.fundamentals.age.AgeRange.年齢_20歳以上;
import static com.example.fundamentals.age.AgeRange.年齢_6歳以上_20歳未満;
import static com.example.fundamentals.age.AgeRange.年齢_6歳未満;

public enum AgeCategory {

    幼児(年齢_6歳未満),
    子供(年齢_6歳以上_20歳未満),
    大人(年齢_20歳以上);

    AgeRange range;

    AgeCategory(AgeRange range) {
        this.range = range;
    }
}
