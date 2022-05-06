class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int [] arr1 = Arrays.copyOfRange(nums, 0, nums.length-1);
        int [] arr2 = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(rob2(arr1), rob2(arr2));
    }    
	
    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;        
    }
}