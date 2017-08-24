package com.codedao.materialsearchview;

/**
 * Created by utnam on 8/23/2017.
 */

public class Story<K,V> {
    private K key;
    private V value;

    public Story(K key, V value) {
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
}
