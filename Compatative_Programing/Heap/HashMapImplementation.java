
import java.util.*;

public class Main {
    
    class HashMap<K, V> {
        
        class HMNode<K, V> {
            private K key;
            private V value;
            
            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
            
            public K getKey() {
                return key;
            }
            
            public V getValue() {
                return value;
            }
        }
        
        int size;
        LinkedList<HMNode>[] buckets;
        
        HashMap(int N) {
            buckets = new LinkedList[N];
            for(int i=0; i<N; i++) {
                buckets[i] = new LinkedList<HMNode>();
            }
            int size = 0;
        }
        
        private int getHashCode(K key) {
            int code = key.hashCode();
            return Math.abs(key) % buckets.length;
        }
        
        public void put(K key, V value) throws Exception {
            int hash = getHashCode(key);
            buckets[hash].add(new HMNode(key, value));
        }
        
        public V get(K key) {
            int hash = getHashCode(key);
            for(HMNode node: buckets[hash]) {
                if(node.getKey() == key) return node.getValue();
            }
            
            return null;
        }
        
        public boolean containsKey(K key) {
            int hash = getHashCode(key);
            for(HMNode node: buckets[hash]) {
                if(node.getKey() == key) return true;
            }
            
            return false;
        }
        
        public String toString() {
            String temp = "{ ";
            for(int i=0; i<buckets.length; i++) {
                temp += " (" + String.valueOf(i) + ") ";
                for(HMNode node: buckets[i]) {
                    temp += node.getKey().toString() + ":" + node.getValue().toString() + " ";
                }
            }
            temp += " }";
            return temp;
        }
        
    }
    
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}
