class Solution {

    public int maxProfit(int k, int[] prices) {
        if(prices.length < 2) return 0;
        int[][][] dp = new int[prices.length][k+1][3];
        
        int end = prices.length-1;

        while(prices[end] == 0) {end--;}
        
        return solve(prices, 0, end, k, 1, dp);
    }

    // i            : buy sell skip
    // isBuy        : 1 buy, 2 sell
    private int solve(int[] prices, int i, int limit, int t, int isBuy, int[][][] dp) {
        if(i > limit || t == 0) {
            return 0;
        }
        
        if(dp[i][t][isBuy] != 0) {
            return dp[i][t][isBuy];
        }
        
        int profit = 0;
        if(isBuy == 1) {
            profit = Math.max( solve(prices, i+1, limit, t, isBuy, dp),
                               solve(prices, i+1, limit, t, 2, dp) - prices[i]);
        } else {
            profit = Math.max( solve(prices, i+1, limit, t, isBuy, dp),
                               solve(prices, i+1, limit, t-1, 1, dp) + prices[i]);
        }
        
        dp[i][t][isBuy] = profit;
        return profit;
    }
    
}
