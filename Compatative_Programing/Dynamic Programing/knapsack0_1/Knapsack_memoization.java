

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

    public static void main(String[] args) {
        int[] W = {2, 5, 1, 3, 4};
        int[] P = {15, 14, 10, 45, 30};
        int capacity = 7;
        int item = 5;

        int result = knapsack(W, P, item, capacity);
        System.out.println(result);
    }

    private static int knapsack(int[] W, int[] P, int n, int capacity) {
        int[][] T = new int[n+1][capacity+1];
        for(int i=0; i<T.length; i++) {
            for(int j=0; j<T[i].length; j++) {
                T[i][j] = -1;
            }
        }
        knapsack(W, P, n, capacity, T);
        return T[n][capacity];
    }

    private static int knapsack(int[] W, int[] P, int n, int capacity, int[][] T) {
        if(n==0 || capacity==0) {
            return 0;
        }

        if(T[n][capacity] != -1) {
            return T[n][capacity];
        }
        int max_profit = 0;

        if(capacity < W[n-1]) {
            max_profit = knapsack(W, P, n-1, capacity, T);
        } else {
            max_profit = Math.max(knapsack(W, P, n-1, capacity, T),
                            P[n-1] + knapsack(W, P, n-1, capacity-W[n-1], T));
        }
        T[n][capacity] = max_profit;
        return max_profit;
    }
}