
/*
    [7 10 4 3 15 20]    k=3
    Output: 7 (7 is 3rd smallest element)

    =====================================

Maintain pq size 3
(here other large element we need to remove)

    - fill k element in heap
    - enter one remove one till parse array

    - return peek()

*/

import java.util.*;

class K_smallest {

    public static void main(String[] args) {
        int[] arr = new int[]{7,10, 4, 3, 15, 20};

        int i = k_small(arr, 3);
        System.out.println(i);
    }

    private static int k_small(int[] arr, int k) {
        if(k > arr.length) {
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        //enter k ele
        for(int i=0; i<k; i++) {
            pq.add(arr[i]);
        }

        for(int i=k; i<arr.length; i++) {
            if(pq.peek() > arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        return pq.peek();

    }
}
