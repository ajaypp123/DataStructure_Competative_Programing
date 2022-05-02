class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length <= 1) {
            return nums;
        }
        int i=0, j=1;
        
        while(j<nums.length) {
            
            while(i<nums.length && nums[i]%2 != 1) {
                i++;
            }
            
            if(j<i) {
                j = i+1;
            }
            
            while(j<nums.length && nums[j]%2 != 0) {
                j++;
            }
            
            if(i<nums.length && j<nums.length) {
                int n = nums[i];
                nums[i] = nums[j];
                nums[j] = n;
            }
        }
        
        return nums;
    }
}