class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        
        int maxlen = 0;
        
        for(int i = m-1 ; i>=0 ; i--){
            for(int j = n-1 ; j>=0 ; j--){
                
                if(i == m-1 || j == n-1){
                    dp[i][j] = matrix[i][j] - '0';
                }else{
                    if(matrix[i][j] == '1'){
                        dp[i][j] = Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1])) + 1;
                    }
                }
                
                maxlen = Math.max(maxlen, dp[i][j]);
            }
        }
        
        int area = maxlen*maxlen;
        
        return area;
    }
}