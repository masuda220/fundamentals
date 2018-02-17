package enums;

import org.junit.Test;

import static org.junit.Assert.*;

public class TypeCodeTest {
    @Test
    public void smoke() {
        TypeCode[] values = TypeCode.values();
        System.out.println(values);
        CodeMap<TypeCode> map = new CodeMap<>(values);
        System.out.println(map);
        String code = "2";
        System.out.println(String.format("コード %s タイプ %s",code, map.typeFor(code)));
    }


}