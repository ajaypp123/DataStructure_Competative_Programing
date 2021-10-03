

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



public class print_LC_subseq {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        String output = LCS(s1, s2);
        System.out.println(output);
    }

    private static String LCS(String s1, String s2) {
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
        return T[0][0];
    }
}
