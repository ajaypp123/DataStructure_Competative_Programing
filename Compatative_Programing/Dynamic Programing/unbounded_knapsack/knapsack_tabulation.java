


/*
Input : W = 8
       val[] = {10, 40, 50, 70}
       wt[]  = {1, 3, 4, 5}
Output : 110


1 yes - 8-1:0+10 7-1:10+10 ... 0:p
  no  - [n-1]:W

  [n+1][W+1]

dp[i] = 0
dp[i] = max(dp[i], dp[i-wt[j]] + val[j]
                   where j varies from 0
                   to n-1 such that:
                   wt[j] <= i

result = d[W]

    0   1   2   3   4   5   6   7   8
    0   10  10  40  50  70  80  90  110
               i/j - yes/no        no = if(j-arr[i-1] < 0): [i-1][j]
                                    yes = p[i-1] + [i-1][j-arr[i-1]]
*/

public class knapsack_tabulation {

    static int knapSack(int N, int W, int val[], int wt[]) {
        int[] profit = new int[W+1];

        if(N==0 || W==0) {
            return 0;
        }

        for(int i=0; i<wt.length; i++) {
            for(int j=1; j<profit.length; j++) {
                // yes or no
                if(j-wt[i] >= 0) {
                    profit[j] = Math.max(profit[j], val[i] + profit[j-wt[i]]);
                }
            }
        }

        return profit[W];
    }

    public static void main(String[] args) {
        int[] W = {1, 3, 4, 5};
        int[] P = {10, 40, 50, 70};
        int capacity = 8;

        int result = knapSack(W.length, capacity, P, W );
        System.out.println(result);
    }
}
