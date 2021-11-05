

/*
        int[] W = {2, 5, 1, 3, 4};
        int[] P = {15, 14, 10, 45, 30};
        int capacity = 7;
        int item = 5;

        2 yes no
        if capacity < W no
        n==0 || c==0

        00
*/

public class Knapsack_memoization {


    private static int knapsack(int[] W, int[] P, int n, int capacity, int[][] T) {
        if(n==0 || capacity ==0)
            return 0;

        if(T[n][capacity] != 0) return T[n-1][capacity];

        // 2, 5, 1, 3, 4
        if(capacity-W[n-1] >= 0) {
            T[n-1][capacity-W[n-1]] = knapsack(W, P, n-1, capacity-W[n-1], T) + P[n-1];
            T[n-1][capacity] = knapsack(W, P, n-1, capacity, T);

            T[n][capacity] = Math.max(T[n-1][capacity-W[n-1]], T[n-1][capacity]);
        } else {
            T[n][capacity] = knapsack(W, P, n-1, capacity, T);
        }
        return T[n][capacity];
    }

    public static void main(String[] args) {
        int[] W = {2, 5, 1, 3, 4};
        int[] P = {15, 14, 10, 45, 30};
        int capacity = 7;
        int item = 5;

        int[][] T = new int[item+1][capacity+1];

        int result = knapsack(W, P, item, capacity, T);
        System.out.println(result);
    }

}