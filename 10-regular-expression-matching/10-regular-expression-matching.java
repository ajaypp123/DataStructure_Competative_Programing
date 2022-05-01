class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        return isMatch(s, p, s.length()-1, p.length()-1, dp);
    }
    
    public boolean isMatch(String s, String p, int i, int j, int[][] dp) {
        if(i<0 && j<0) {
            return true;
        }

        if(j<0) {
            return false;
        }
        
        if(i>=0 && dp[i][j] != 0) {
            return dp[i][j]==1?true:false;
        }

        char ch = p.charAt(j);
        boolean result = false;

        if(i>=0 && (ch == '.' || ch == s.charAt(i))) {
            // . or ch == ch: i-1, j-1 
            result = isMatch(s, p, i-1, j-1, dp);
            
        } else if(ch == '*' && i<0) { 
            // a* == ""
            result = isMatch(s, p, i, j-2, dp);
            
        } else if(ch == '*' && (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i))) {
            // * and ch-1 == ch : i is empty || i-1 j-2 || i-1 j
            result = isMatch(s, p, i-1, j-2, dp) || isMatch(s, p, i-1, j, dp) || isMatch(s, p, i, j-2, dp);
            
        } else if(ch == '*' && (i>=0 && p.charAt(j-1) != s.charAt(i))) {
            // * and ch-1 != ch :
            result = isMatch(s, p, i, j-2, dp);
        } else {
            result = false;
        }
        
        if(i>=0) {
            dp[i][j] = result?1:2;
        }
        return result;
    }
}


