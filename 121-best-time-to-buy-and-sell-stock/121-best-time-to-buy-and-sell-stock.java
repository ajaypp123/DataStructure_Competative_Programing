class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int cheapest = Integer.MAX_VALUE;
		
        for (int price : prices) {
            cheapest = Math.min(price, cheapest);
            profit = Math.max(price - cheapest, profit);
        }
		
        return profit;
    }
}