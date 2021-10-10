
/*
    [5, 6, 7, 8, 9]    k=3  N=7
    Return k closest element near N.
    Output: [6 7 8]


    6, 5, 3, 2, 8, 10, 9

*/

import java.util.*;

class CInt implements Comparable<CInt> {
    public int x;
    public static int N;

    CInt(int x) {
        this.x = x;
    }

    public int compareTo(CInt y) {
        if(x == y.x) {
            return 0;
        } else if(Math.abs(N-x) > Math.abs(N-y.x) || y.x == N) {
            return -1;
        } else {
            return 1;
        }
    }
}

class k_closest {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 3, 2, 8, 10, 9};

        int[] i = k_small(arr, 3, 7);
        System.out.println(Arrays.toString(i));
    }

    private static int[] k_small(int[] arr, int k, int N) {
        PriorityQueue<CInt> pq = new PriorityQueue<>();
        int[] res = new int[k];
        CInt.N = N;

        //enter k ele
        for(int i=0; i<k; i++) {
            pq.add(new CInt(arr[i]));
        }

        for(int i=k; i<arr.length; i++) {
            pq.add(new CInt(arr[i]));
            pq.remove();
        }

        int c=0;
        while(pq.size() != 0) {
            res[c++] = pq.peek().x;
            pq.remove();
        }

        return res;

    }
}
