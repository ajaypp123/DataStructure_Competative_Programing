class Solution {
    /*
    Let three Input strings are: A,B, C
    LCS(A,C) == A
    LCS(B,C) = B
    If both condition satisifies then C Is interleave of A and B.
    LCS: Longest common subsequence. Finding LCS is DP problem
    */
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return solve(s1,s2,s3,0,0,dp);
    }
    
    public boolean solve(String a,String b,String c,int i,int j,Boolean[][] dp){
	    if(i == a.length() && j == b.length()) return true;
	    if(dp[i][j]!=null) return dp[i][j];
	    if(i < a.length() && a.charAt(i) == c.charAt(i+j)){
	        boolean res = solve(a,b,c,i+1,j,dp);
	        dp[i][j] = res;
	        if(res == true) return true;
	    }
	    if(j<b.length() && b.charAt(j) == c.charAt(i+j)){
	        boolean res = solve(a,b,c,i,j+1,dp);
	        dp[i][j] = res;
	        if(res == true) return true;
	    }
	    dp[i][j] = false;
	    return false;
	}
}