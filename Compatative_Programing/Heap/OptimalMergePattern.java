
/**
 * # OptimalMergePattern
 *  Rope [1, 2, 3, 4, 5]    Output: 33
 * Connect rope to get min cost
 *
 *      1       2       3       4       5
 *      ---------
 *          3       3       4       5
 *          ---------
 *              6       4       5
 *                      ---------
 *                  6       9
 *                  ---------
 *                      15
 * total cost = 15 + 9 + 6 + 3 = 33
 */

 import java.util.*;

public class OptimalMergePattern {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5};

        int res = optimal_merge(arr);
        System.out.println(res);
    }

    private static int optimal_merge(int[] arr) {
        if(arr.length == 2) {
            return arr[0] + arr[1];
        } else if(arr.length == 1) {
            return arr[0];
        }

        int min = 0;
        // Add all to pq
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele: arr) {
            pq.add(ele);
        }

        // Remove 2 and add sum till size empty
        int a,b,c;
        //{1,2,3,4,5}
        //{15} 18+15
        while(pq.size() != 1) {
            a = pq.peek();
            pq.remove();
            b = pq.peek();
            pq.remove();
            c = a + b;
            pq.add(c);
            min += c;
        }

        return min;
    }
}
