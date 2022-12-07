package com.mic.generics;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GenMapTest4 {


    private static final String TYPE_LONG = "Long";
    private static final String TYPE_INTEGER = "Integer";
    private static final String TYPE_STRING = "String";


    public static void main(String[] args) {
        long a=System.currentTimeMillis();
        GenMapTest4 genMapTest4 = new GenMapTest4();
        Map map = new HashMap();
        map.put("time", System.currentTimeMillis());
        map.put(1,(double)System.currentTimeMillis());
        map.put(2,"video");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long b =System.currentTimeMillis();
        double dx=(double)(b-a);
        map.put(3,dx);
        genMapTest4.report(map);
    }

    private <K, V> void report(Map<K,V> map) {
        if (map == null || map.size() == 0) return;

        Set<Map.Entry<K, V>> set = map.entrySet();
        set.forEach(it -> {
//            double value = valueConvertToDouble(it.getValue());
//            System.out.println("key ->" + it.getKey() + "   value->" + value + " valueType->" + value);
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
