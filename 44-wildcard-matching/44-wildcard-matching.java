class Solution {

    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        return isMatch(s, p, s.length()-1, p.length()-1, dp);
    }

    private boolean isMatch(String s, String p, int i, int j, int[][] dp) {
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

        if(i>=0 && (ch == '?' || ch == s.charAt(i))) {
            result = isMatch(s, p, i-1, j-1, dp);

        } else if(ch == '*' && i<0) {
            result = isMatch(s, p, i, j-1, dp);

        } else if(ch == '*') {
            result = isMatch(s, p, i, j-1, dp) || isMatch(s, p, i-1, j-1, dp) || isMatch(s, p, i-1, j, dp);

        } else {
            result = false;
        }

        if(i>=0) {
            dp[i][j] = result?1:2;
        }

        return result;
    }
}
