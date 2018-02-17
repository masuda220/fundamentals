package enums;

import java.util.HashMap;
import java.util.Map;

public class CodeMap<K extends Enum & CodeValue> {

    Map<String, K> map = new HashMap<>();

    public CodeMap(K[] types) {
        for (K type : types) map.put(type.code(),type);
    }

    public K typeFor(String code) {
        return map.get(code);
    }

    @Override
    public String toString() {
        return map.toString();
    }


}
