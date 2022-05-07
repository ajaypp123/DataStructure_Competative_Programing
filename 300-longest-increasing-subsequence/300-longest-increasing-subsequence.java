class Solution {
    public int lengthOfLIS(int[] a) {
        int result = 0;
        if (a.length == 0)   
            return 0;
		
        // dp[i] is the LIS when the subsequence end with a[i]
        int[] dp = new int[a.length];
        Arrays.fill(dp, 1);
        for (int i=1; i<a.length; i++) {
            for (int j=0; j<i; j++) {
                if(a[j] < a[i]) 
                    dp[i] = Math.max(dp[i], (dp[j] + 1));
            }
        }
		
        // the max value of dp[i] is the result
        for (int i=0; i<dp.length; i++) {
            if (result < dp[i])    
                result = dp[i];
        }
        return result;
    } 
}