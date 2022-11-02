
import java.util.*;
import java.lang.Math;

import java.util.*;
import java.lang.Math;

class MyHashMap < K, V > {

    class HMNode < K, V > {
        private K key;
        private V value;

        HMNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }
    }

    int size;
    LinkedList < HMNode > [] buckets;

    MyHashMap(int N) {
        buckets = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList < HMNode > ();
        }
        int size = 0;
    }

    private int getHashCode(K key) {
        int code = key.hashCode();
        return Math.abs(code) % buckets.length;
    }

    public void put(K key, V value) {
        int hash = getHashCode(key);
        buckets[hash].add(new HMNode(key, value));
    }

    public V get(K key) {
        int hash = getHashCode(key);
        for (HMNode node: buckets[hash]) {
            if (node.getKey() == key)
                return node.getValue();
        }

        return null;
    }

    public boolean containsKey(K key) {
        int hash = getHashCode(key);
        for (HMNode node: buckets[hash]) {
            if (node.getKey() == key)
                return true;
        }

        return false;
    }

    public String toString() {
        String temp = "{ ";
        for (int i = 0; i < buckets.length; i++) {
            temp += " (" + String.valueOf(i) + ") ";
            for (HMNode node: buckets[i]) {
                temp +=
                    node.getKey().toString() + ":" +
                    node.getValue().toString() + " ";
            }
        }
        temp += " }";
        return temp;
    }

}

public class Main {

    public static void main(String[] args) {
        MyHashMap < Integer, String > map = new MyHashMap < Integer, String > (4);
        map.put(1, "dsf");
        map.put(2, "dsf");
        map.put(3, "dsf");
        map.put(4, "dsf");
        System.out.println(map);
    }
}

