


/*
        int[] W = {2, 5, 1, 3, 4};
        int[] P = {15, 14, 10, 45, 30};
        int capacity = 7;
        int item = 5;

        2 yes no
        if capacity < W no
        n==0 || c==0

        c=0
        i=0
        table[item][capacity]

        dp[i][j]
        44
        // capacity less then not take
        // yes dp[i][j] = P[i-1] + dp[i-1][j-W[i-1]]
        // no  dp[i][j] = dp[i-1][j]


        i\j    0   1   2   3   4   5   6   ..7

        0

        1

        2

        3

        4

        5
*/

public class Knapsack_tabulation {

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
        //base
        if(n==0 || capacity==0) {
            return 0;
        }

        for(int i=1; i<T.length; i++) {
            for(int j=1; j<T[i].length; j++) {
                if(capacity < W[i-1] || j-W[i-1] < 0) {
                    T[i][j] = T[i-1][j];
                } else {
                    T[i][j] = Math.max(T[i-1][j], P[i-1] + T[i-1][j-W[i-1]]);
                }
            }
        }
        return T[n][capacity];
    }
}