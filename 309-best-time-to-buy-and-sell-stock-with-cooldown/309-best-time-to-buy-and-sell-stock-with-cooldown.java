class Solution {
    // Memoize all states you have
    int[][][] memo;
    int[] prices;
    
    
    public int doDp(int i, int cooldown, int holding){
        if(i == prices.length)    
            return 0;
        
        int gain = 0;
        if(memo[i][cooldown][holding] == 0){
            // If we have the stock (holding == true)
            if(holding == 1){
                // We can keep it or sell it
                gain += Math.max(prices[i] + doDp(i+1, 1, 0), doDp(i+1, 0, 1));
            } 
            // If we don't have a stock (holding = 0)
            else {
                // We can get a stock or skip
                if(cooldown == 1)
                    gain += doDp(i+1, 0, 0);
                else
                    gain += Math.max(-prices[i] + doDp(i+1, 0, 1), doDp(i+1, 0, 0));
            }
            memo[i][cooldown][holding] = gain;
        }
        return memo[i][cooldown][holding];
    }
    
    public int maxProfit(int[] prices) {
        memo = new int[prices.length][2][2];
        this.prices = prices;
        
        return doDp(0, 0, 0);
    }
}
