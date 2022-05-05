class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> hs = new HashSet<>();
        for(String word: wordDict) {
            hs.add(word);
        }
        
        Boolean[][] dp = new Boolean[s.length()+1][s.length()+1];
        return solve(s, hs, 0, s.length(), dp);
    }
    
    private boolean solve(String s, HashSet<String> hs, int start, int end, Boolean[][] dp) {
        
        if(start == end || hs.contains(s.substring(start, end))) return true;
        
        if(dp[start][end] != null) {
            return dp[start][end];
        }
        
        for(int i=start; i<end; i++) {
            if(hs.contains(s.substring(start, i+1))
                        && solve(s, hs, i+1, end, dp)) {
                dp[start][end] = true;
                return true;
            }
        }
        
        dp[start][end] = false;
        return false;
    }
}