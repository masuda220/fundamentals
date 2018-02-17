package com.example.fundamentals.enums;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class CodeTableTest {

    @Test
    public void usage(){
        StatusType open = StatusType.終了;
        StatusType fromCode = open.forCode("2");
        assertTrue(fromCode.equals(open));
    }
    @Test
    public void map() {
        CodeTable<StatusType> map = new CodeTable<>(StatusType.class);
        System.out.println(map);
        String code = "2";
        System.out.println(String.format("コード %s タイプ %s",code, map.lookup(code)));
    }
}