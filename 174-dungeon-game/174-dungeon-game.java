class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int R = dungeon.length;
        int C = dungeon[0].length;
        
        int[][] dp = new int[R][C]; // Minimum energy at {i, j} to reach the end 
        for(int i=R-1; i>=0; i--){
            for(int j=C-1; j>=0; j--){
                
                if(i ==  R-1 && j == C-1){
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j] );
                }else if(i == R-1){
                    dp[i][j] = Math.max(1, dp[i][j+1] - dungeon[i][j]);                    
                }else if(j == C-1){
                    dp[i][j] = Math.max(1, dp[i+1][j] - dungeon[i][j]);
                }else{
                    dp[i][j] = Math.max(1, dp[i][j+1] - dungeon[i][j]);        
                    dp[i][j] = Math.min(dp[i][j], Math.max(1, dp[i+1][j] - dungeon[i][j]));
                }
            }
        }
        
        return dp[0][0];
    }
}