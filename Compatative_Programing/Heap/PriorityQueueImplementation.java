
/*
LCi = 2Pi + 1
RCi = 2Pi + 2
*/

import java.util.*;

class MyPriorityQueue<K> {
    private ArrayList<K> list;
    public int size;
    
    MyPriorityQueue() {
        list = new ArrayList<>();
        size = 0;
    }
    
    public void add(K element) {
        
    }
    
    public K remove() {
        
    }
    
    public K peek() {
        if(list.size == 0) return null;
        return list.get(0);
    }
}


public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}
