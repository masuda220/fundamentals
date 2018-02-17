package enums;

import java.util.Map;

public enum TypeCode implements CodeValue {
    開始("1"),
    終了("2");

    String code ;

    TypeCode(String code) {
        this.code = code;
    }

    static final CodeMap<TypeCode> map = new CodeMap<TypeCode>(TypeCode.values());

    public TypeCode get(String code){
        return map.typeFor(code);
    }

    public String code() {
        return code;
    }

}
