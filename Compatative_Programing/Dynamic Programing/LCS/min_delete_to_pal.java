


/*
Minimum number of deletion in a string to make it a palindrome

Input: text1 = "agbcba"
Output: 1        str.len() - LongestPalendromSubseq.len()
==============================
agbcba
abcbga

    str ---> LCS  ---> reverse
            (palendrom)

    str.len() - LPS.len()

        a   g   b   c   b   a   0

    a                           0
    b                           0
    c                           0
    b                           0
    g                           0
    a   1   1   1   1   1   1   0
    0   0   0   0   0   0   0   0
*/





public class min_delete_to_pal {

    public static void main(String[] args) {
        String s1 = "agbcba";
        int output = LPalendromSub(s1);
        System.out.println(output);
    }

    private static int LPalendromSub(String s1) {
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();
        String[][] T = new String[s2.length()+1][s1.length()+1];

        for(int i=s2.length(); i>=0; i--) {
            for(int j=s1.length(); j>=0; j--) {
                T[i][j] = "";
            }
        }

        for(int i=s2.length()-1; i>=0; i--) {
            for(int j=s1.length()-1; j>=0; j--) {
                if(s1.charAt(j) == s2.charAt(i)) {
                    T[i][j] = String.valueOf(s1.charAt(j)) + T[i+1][j+1];
                } else {
                    T[i][j] = T[i+1][j].length() > T[i][j+1].length()?T[i+1][j]:T[i][j+1];
                    T[i][j] = T[i][j].length() > T[i+1][j+1].length()?T[i][j]:T[i+1][j+1];
                }
            }
        }
        return s1.length() - T[0][0].length();
    }
}
