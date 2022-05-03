class Solution {
    public int maxProfit(int[] prices) {
        int[] p = new int[prices.length];
        p[0] = 0;
        
        for(int i=1; i<prices.length; i++) {
            int profit = 0;
            for(int j=i-1; j>=0; j--) {
                profit = Math.max(profit, p[j] + Math.max(prices[i]-prices[j], 0));
            }
            p[i] = profit;
        }
        
        return p[p.length-1];
    }
}