class Solution {
    public int maxProfit(int[] prices) {
        // dp[i][buy,sell,skip][transection]
        int[][][] dp=new int[prices.length][3][2];
        
        int j=0;
        for(int[][] a:dp){
            int i=0;
            for(int[] b: a){
                Arrays.fill(b,-1);
                a[i]=b;
                i++;
            }
            dp[j]=a;
            j++;
        }
        
        return f(prices,0,2,1,dp);
    }
    
    public int f(int[] prices,int i,int remT, int buy, int[][][] dp){    
        if(i==prices.length) return 0;

        if(remT==0) return 0;

        if(dp[i][remT][buy]!=-1)return dp[i][remT][buy];

        int profit=0;
        if(buy==1){
            int buyy=-prices[i] + f(prices,i+1,remT,0,dp);
            int notbuy=f(prices,i+1,remT,1,dp);
            profit=Math.max(buyy,notbuy);
        }else{
            int sell=prices[i]+f(prices,i+1,remT-1,1,dp);
            int notsell=f(prices,i+1,remT,0,dp);
            profit=Math.max(sell,notsell);
        }
        return dp[i][remT][buy] =profit;
    }
}
