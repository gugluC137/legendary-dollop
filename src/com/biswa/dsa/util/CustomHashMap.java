package com.biswa.dsa.util;

public class CustomHashMap<K, V> {
    // get, put
    static class CustomEntry<K, V> {
        final K key;
        V value;
        CustomEntry<K, V> next;

        CustomEntry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int size;
    private int capacity;
    private float loadFactor;
    private CustomEntry<K, V>[] table;

    public CustomHashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.size = 0;
        this.table = (CustomEntry<K, V>[]) new CustomEntry[capacity];
    }

    public V get(K key) {
        int keyHash = hashValue(key);
        CustomEntry<K, V> entry = table[keyHash];

        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }

        return null;
    }

    public void put(K key, V value) {
        int keyHash = hashValue(key);

        CustomEntry<K, V> entry = this.table[keyHash];

        while (entry != null) {
            if(entry.key == key) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }

        CustomEntry<K, V> newEntry = new CustomEntry<>(key, value);
        newEntry.next = this.table[keyHash];
        this.table[keyHash] = newEntry;
        this.size++;

        if (this.size > this.capacity * this.loadFactor) {}
    }

    private int hashValue(K key) {
        return key.hashCode() % this.capacity;
    }

    private void resize() {
        int newCapacity = this.capacity * 2;

    }


}
