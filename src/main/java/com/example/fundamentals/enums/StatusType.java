package com.example.fundamentals.enums;

/**
 * コード値を持つ区分（CodeTableの利用例）
 */
public enum StatusType implements Code {
    開始("1"),
    終了("2");

    String code ;

    StatusType(String code) {
        this.code = code;
    }

    static final CodeTable<StatusType> table = new CodeTable<>(StatusType.class);
    public StatusType forCode(String code){
        return table.lookup(code);
    }

    public String code() {
        return code;
    }
}
