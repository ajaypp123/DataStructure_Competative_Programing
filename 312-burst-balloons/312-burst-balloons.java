

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length ;
        // creating a new array with adding 1 in starting and ending to stop from getting out of bound
        int[] narr = new int[n+2];
        narr[0]=narr[n+1]=1;
        
        // now copying those elements to new array for calculating bursting
        for(int i = 1;i<=n;i++){
            narr[i]=nums[i-1];   
        }
        
        int[][] dp = new  int[n+2][n+2];
        //arguments passing the new array ,left most and right most
        return solve(dp , narr , 0 , n+1);
    }
    
    //doing multiplication chain matrix as taught by aditya verma
    
    public int solve(int[][]dp , int[] arr , int left , int right){
        if(left + 1 == right) return 0 ;
        
        if(dp[left][right] > 0 ) return dp[left][right];
        
        int max = 0;
        
        for(int i = left + 1 ; i < right ; i++){
           int temp_ans = solve(dp,arr,left,i) + solve(dp,arr,i,right)+ 
               arr[left]*arr[i]*arr[right] ;
            
            if(temp_ans > max){
                max = temp_ans;
            }
        
        }
        dp[left][right] = max ;
        
        return max;   
        }
}









