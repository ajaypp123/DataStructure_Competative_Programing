
/*
LCi = 2Pi + 1
RCi = 2Pi + 2
*/

import java.util.*;

class MyPriorityQueue {
    private ArrayList<Integer> list;
    
    MyPriorityQueue() {
        list = new ArrayList<>();
    }
    
    public void add(int element) {
        list.add(element);
        // LCi = 2Pi + 1
        // RCi = 2Pi + 2
        int index = list.size()-1;
        int Pi = ( index - (index%2==1?1:2) ) /2;
        
        while(list.get(Pi) > list.get(index)) {
               int temp = list.get(Pi);
               list.set(Pi, list.get(index));
               list.set(index, temp);
               
               index = Pi;
               Pi = ( index - (index%2==1?1:2) ) /2;
        }
    }
    
    public Integer remove() {
        if(list.isEmpty()) return null;
        
        // replace first & last
        list.set(0, list.get(list.size()-1));
        int ele = list.remove(list.size()-1);
        
        int LCi = 1;
        int RCi = 2;
        int Pi = 0;
        
        while(list.get(Pi) > list.get(LCi) || list.get(Pi) > list.get(RCi)) {
            int temp = list.get(Pi);
            if(list.get(RCi) > list.get(LCi)) {
                list.set(Pi, list.get(LCi));
                list.set(LCi, temp);
                Pi = LCi;
            } else {
                list.set(Pi, list.get(RCi));
                list.set(RCi, temp);
                Pi = RCi;
            }
            LCi = (2*Pi) + 1;
            RCi = (2*Pi) + 2;
        }
        return ele;
    }
    
    public Integer peek() {
        if(list.size() == 0) return null;
        return list.get(0);
    }
    
    public int size() {
        return list.size();
    }
}


public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}
