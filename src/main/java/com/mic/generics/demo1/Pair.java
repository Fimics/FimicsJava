package com.mic.generics.demo1;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public boolean compare(Pair<K, V> p) {
        return this.getKey().equals(p.getKey()) && this.getValue().equals(p.getValue());
    }

    public static <K,V> boolean compare2(Pair<K,V> p1,Pair<K,V> p2){
        return p1.compare(p2);
    }
}
