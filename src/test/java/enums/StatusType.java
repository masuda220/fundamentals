package enums;

public enum StatusType implements Code {
    開始("1"),
    終了("2");

    String code ;

    StatusType(String code) {
        this.code = code;
    }

    CodeTable<StatusType> table = new CodeTable<>(StatusType.class);
    public StatusType forCode(String code){
        return table.lookup(code);
    }

    public String code() {
        return code;
    }
}
