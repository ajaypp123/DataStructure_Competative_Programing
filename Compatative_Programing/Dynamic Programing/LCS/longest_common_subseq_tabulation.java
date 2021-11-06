


/*
Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

T[s1.length()][s2.length()]

""  ""          0
"abcdea","ace"   3

    a   b   c   d   e   a   0

a                           0

c                           0

e       1   1   1   1   0   0

0   0   0   0   0   0   0   0

match   T[i][j+1], T[i+1][j+1] + 1
not match   Max(T[i+1][j], T[i][j+1], T[i+1][j+1])

*/


public class longest_common_subseq_tabulation {

    private static int LCS(String s1, String s2) {
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

        return T[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int output = LCS(s1, s2);
        System.out.println(output);
    }

}
