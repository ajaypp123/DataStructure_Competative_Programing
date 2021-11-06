
/*
Input : W = 8
       val[] = {10, 40, 50, 70}
       wt[]  = {1, 3, 4, 5}
Output : 110

*/
public class Knapsack_recursion {

    private static int knapsack(int[] W, int[] P, int n, int capacity) {
        if(n==0 || capacity==0) {
            return 0;
        }

        int max = 0;
        // select or not
        if(capacity >= W[n-1]) {
            max = Math.max(knapsack(W, P, n-1, capacity),
                            // below send n item as can be selected again
                            knapsack(W, P, n, capacity-W[n-1]) + P[n-1]);
        } else {
            max = knapsack(W, P, n-1, capacity);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] W = {1, 3, 4, 5};
        int[] P = {10, 40, 50, 70};
        int capacity = 8;
        int item = 4;

        int result = knapsack(W, P, item, capacity);
        System.out.println(result);
    }

}