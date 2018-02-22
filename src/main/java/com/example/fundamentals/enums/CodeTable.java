package com.example.fundamentals.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * enum がコード値を持つ場合のヘルパークラス
 */
public class CodeTable<T extends Enum & Code> {

    Map<String, T> map = new HashMap<>();

    public CodeTable(Class<T> enumClass) {
        T[] enumConstants = enumClass.getEnumConstants();
        for (T each : enumConstants) map.put(each.code(),each);
    }

    public T lookup(String code) {
        return map.get(code);
    }

    @Override
    public String toString() {
        return map.toString();
    }


}
