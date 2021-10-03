
/*
        int[] W = {2, 5, 1, 3, 4};
        int[] P = {15, 14, 10, 45, 30};
        int capacity = 7;
        int item = 5;

        2 yes no
        if capacity < W no
        n==0 || c==0
*/

public class Knapsack_recursion {
    public static void main(String[] args) {
        int[] W = {2, 5, 1, 3, 4};
        int[] P = {15, 14, 10, 45, 30};
        int capacity = 7;
        int item = 5;

        int result = knapsack(W, P, item, capacity);
        System.out.println(result);
    }

    private static int knapsack(int[] W, int[] P, int n, int capacity) {
        if(n==0 || capacity==0) {
            return 0;
        }

        int max_profit = 0;

        if(capacity < W[n-1]) {
            max_profit = knapsack(W, P, n-1, capacity);
        } else {
            max_profit = Math.max(knapsack(W, P, n-1, capacity),
                            P[n-1] + knapsack(W, P, n-1, capacity-W[n-1]));
        }
        return max_profit;
    }
}