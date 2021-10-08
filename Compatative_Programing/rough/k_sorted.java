
/*
    [6 5 3 2 8 10 9]    k=3
    Output: [sorted array]
    element can either shift k left or right

    8 10 9

    2 3 5 6 8 9 10
*/

import java.util.*;

class k_sorted {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 3, 2, 8, 10, 9};

        int[] i = k_small(arr, 3);
        System.out.println(Arrays.toString(i));
    }

    private static int[] k_small(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] res = new int[arr.length];

        //enter k ele
        for(int i=0; i<=k; i++) {
            pq.add(arr[i]);
        }

        int c = 0;
        for(int i=k+1; i<arr.length; i++) {
            res[c++] = pq.peek();
            pq.remove();
            pq.add(arr[i]);
        }

        while(pq.size() != 0) {
            res[c++] = pq.peek();
            pq.remove();
        }

        return res;

    }
}
