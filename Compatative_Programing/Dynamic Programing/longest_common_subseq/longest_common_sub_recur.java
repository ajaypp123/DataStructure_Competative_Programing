
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
    public static void main(String[] args) {
        String s1 = "abcdee";
        String s2 = "ace";
        int output = LCS(s1, s2);
        System.out.println(output);
    }

    private static int LCS(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        //"abcde" "ace"
        char s1ch = s1.charAt(s1.length()-1);
        char s2ch = s2.charAt(s2.length()-1);

        int total = 0;
        if(s1ch == s2ch) {
            total +=1;
            total += LCS(s1.substring(0,s1.length()-1), s2.substring(0,s2.length()-1));
        } else {
            total += LCS(s1.substring(0,s1.length()-1), s2);
        }
        return total;
    }

}
