
/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]


*/

import java.util.*;

class Fre implements Comparable<Fre> {

    public int ele;
    public int frq;

    Fre(int e, int f) {
        ele = e;
        frq = f;
    }

    @Override
    public int compareTo(Fre y) {
        if(frq < y.frq) {
            return -1;
        } else {
            return 1;
        }
    }
}


public class KTopFre {
    public int[] topKFrequent(int[] nums, int k) {

        //add in hm
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int ele: nums) {
            if(hm.containsKey(ele)) {
                // present
                hm.put(ele, hm.get(ele)+1);
            } else {
                hm.put(ele, 1);
            }
        }

        // travel hm and add in pq
        PriorityQueue<Fre> pq = new PriorityQueue<>();
        for(int ele: hm.keySet()) {
            // pq size < k
            if(pq.size() < k) {
                pq.add(new Fre(ele, hm.get(ele)));
            } else {
                // if pq peek less then replace
                if(pq.peek().frq < hm.get(ele)) {
                    pq.remove();
                    pq.add(new Fre(ele, hm.get(ele)));
                }
            }
        }

        // add pq in res
        int[] res = new int[k];
        for(int i=0; i<k; i++) {
            res[i] = pq.peek().ele;
            pq.remove();
        }
        return res;
    }
}
