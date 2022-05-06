class Solution {
    public int rob(int[] nums) {
        int[][] cost = new int[2][nums.length];
        
        cost[0][0] = nums[0];
        cost[1][0] = 0;
        
        for(int i=1; i<nums.length; i++) {
            cost[0][i] = cost[1][i-1] + nums[i];
            cost[1][i] = Math.max(cost[0][i-1], cost[1][i-1]);
        }
        
        return Math.max(cost[0][nums.length-1], cost[1][nums.length-1]);
    }
}