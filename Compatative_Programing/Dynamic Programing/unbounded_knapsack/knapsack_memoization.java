

/*
Input : W = 8
       val[] = {10, 40, 50, 70}
       wt[]  = {1, 3, 4, 5}
Output : 110


1 yes - 8-1:0+10 7-1:10+10 ... 0:p
  no  - [n-1]:W

  [n+1][W+1]


    0   1   2   3   4   5   6   7   8
    0   10  10  40  50  70  80  90  110
               i/j - yes/no        no = if(j-arr[i-1] < 0): [i-1][j]
                                    yes = p[i-1] + [i-1][j-arr[i-1]]
*/

public class knapsack_memoization {
    public static void main(String[] args) {
        int[] W = {1, 3, 4, 5};
        int[] P = {10, 40, 50, 70};
        int capacity = 8;

        int[][] T = new int[W.length+1][capacity+1];

        int result = knapsack(W, P, W.length, capacity, T);
        System.out.println(result);
    }

    private static int knapsack(int[] W, int[] P, int n, int capacity, int[][] T) {
        if(n == 0 || capacity <= 0) {
            return 0;
        }
        if(T[n][capacity] != 0) {
            return T[n][capacity];
        }
        if(capacity-W[n-1] < 0) {
            return knapsack(W, P, n-1, capacity, T);
        }
        int py = P[n-1] + knapsack(W, P, n, capacity-W[n-1], T);
        int pn = knapsack(W, P, n-1, capacity, T);
        T[n][capacity] = Math.max(py, pn);
        return T[n][capacity];
    }

}
