package com.mic.javagenerics;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenMapTest4 {


    private static final String TYPE_LONG = "Long";
    private static final String TYPE_INTEGER = "Integer";
    private static final String TYPE_STRING = "String";


    public static void main(String[] args) {
        GenMapTest4 genMapTest4 = new GenMapTest4();
        Map map = new HashMap();
        map.put("time", System.currentTimeMillis());
//        map.put(1,System.currentTimeMillis());
        genMapTest4.report(map);
    }

    private <K, V> void report(Map map) {
        if (map == null || map.size() == 0) return;

        Set<Map.Entry<K, V>> set = map.entrySet();
        set.forEach(it -> {
            double value = valueConvertToDouble(it.getValue());
            System.out.println("key ->" + it.getKey() + "   value->" + value + " valueType->" + value);
            System.out.println("key ->" + it.getKey() + "   value->" + it.getValue());
        });
    }

    private <V> double valueConvertToDouble(V v) {
        String type = v.getClass().getSimpleName();
        double value = 0;
        switch (type) {
            case TYPE_INTEGER:
            case TYPE_LONG:
                BigDecimal bigDecimal = new BigDecimal((Long) v);
                value = bigDecimal.doubleValue();
                break;
            case TYPE_STRING:
                value = Double.valueOf((String) v).longValue();
                break;
        }
        return value;
    }
}
