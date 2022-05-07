class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++) Arrays.fill(dp[i],-1);
		// To memoize the subproblems ,we use the dp array
		// why coins.length and amount as length of dp row and col?
		// because they are the changing states in recursion
        int res = findCoinChange(coins.length-1,coins,amount,dp);
		//In case it returns the maxValue that means there is no possible combination which result to the amount
        return res==Integer.MAX_VALUE-1?-1:res;
    }
    
    public static int findCoinChange(int ind,int[] coins,int amount,int[][] dp){
        if(amount==0) return 0;
        if(ind==0){
			// At the last (first) Index,we check whether the coin will satiesfy the amount 
			// if it is,we return no of coins
			// else maxValue
            if(amount%coins[ind]==0) return amount/coins[ind];
            return Integer.MAX_VALUE-1;
        }
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int pick=Integer.MAX_VALUE;
        if(coins[ind]<=amount) pick = 1+findCoinChange(ind,coins,amount-coins[ind],dp);
        int notPick = 0+findCoinChange(ind-1,coins,amount,dp);
        
        return dp[ind][amount]=Math.min(pick,notPick);
    }
}