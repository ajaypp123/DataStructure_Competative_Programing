
/*
Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

"abcde" "ace"
if last char is same then send s1.len-1, s2.len-1 else s1.len-1 s2

Recurstion:
"abcde" "ace"   "e" == "e"  1
abcd ac         d == c    0
abc ac          c == c      1
ab a            b == a      0
a a             a == a      1
*/

public class longest_common_sub_recur {

    private static int LCS(String s1, String s2) {

        if(s1.length() * s2.length() == 0) {
            return 0;
        }

        char ch1 = s1.charAt(0);
        char ch2 = s1.charAt(0);

        if(ch1 == ch2) {
            return 1 + LCS(s1.substring(1), s2.substring(1));
        }

        return LCS(s1.substring(1), s2);
    }

    public static void main(String[] args) {
        String s1 = "abcdee";
        String s2 = "ace";
        int output = LCS(s1, s2);
        System.out.println(output);
    }
}
