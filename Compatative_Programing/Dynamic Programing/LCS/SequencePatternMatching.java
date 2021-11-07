
/*
Sequence Pattern Matching

Is string s1 subsequence of string s2

s1 = "AXY"
s2 = "ADXCPY"
Output:  true
=========================================

Solution:

    return LCS(s1, s2) == s1.length()
*/


public class SequencePatternMatching {

    private static boolean patternMatching(String s1, String s2) {
        int[][] T = new int[s1.length()+1][s2.length()+1];

        for(int i=1; i<T.length; i++) {
            for(int j=1; j<T[0].length; j++) {
                // "abcde", "ace"
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    T[i][j] = 1 + T[i-1][j-1];
                } else {
                    T[i][j] = Math.max( T[i-1][j], T[i][j-1] );
                }
            }
        }

        return T[s1.length()][s2.length()] == s1.length();
    }

    public static void main(String[] args) {
        String s2 = "abcde";
        String s1 = "ace";
        boolean output = patternMatching(s1, s2);
        System.out.println(output);
    }

}
