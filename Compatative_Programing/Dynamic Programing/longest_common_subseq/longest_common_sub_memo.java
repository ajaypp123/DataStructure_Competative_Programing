
/*
Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

T[s1.length()][s2.length()]

""  ""          0
"abcde","ace"   3

*/

public class longest_common_sub_memo {

    public static void main(String[] args) {
        String s1 = "abcdea";
        String s2 = "ace";
        int output = LCS(s1, s2);
        System.out.println(output);
    }

    private static int LCS(String s1, String s2) {
        int[][] T = new int[s1.length()+1][s2.length()+1];
        return LCS(s1, s2, T);
    }

    private static int LCS(String s1, String s2, int[][] T) {
        if(s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        //"abcde" "ace"
        char s1ch = s1.charAt(s1.length()-1);
        char s2ch = s2.charAt(s2.length()-1);

        if(T[s1.length()][s2.length()] != 0) {
            return T[s1.length()][s2.length()];
        }

        if(s1ch == s2ch) {
            T[s1.length()][s2.length()] +=1;
            T[s1.length()][s2.length()] += LCS(s1.substring(0,s1.length()-1), s2.substring(0,s2.length()-1), T);
        } else {
            T[s1.length()][s2.length()] += LCS(s1.substring(0,s1.length()-1), s2, T);
        }
        return T[s1.length()][s2.length()];
    }
}
