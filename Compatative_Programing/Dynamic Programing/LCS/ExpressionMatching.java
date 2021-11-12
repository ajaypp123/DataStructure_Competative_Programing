
/*
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Example 4:
Input: s = "aab", p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".

Example 5:
Input: s = "mississippi", p = "mis*is*p*."
Output: false
*/

public class ExpressionMatching {

    private static boolean isMatch(String s1, String s2, int[][] T) {
        if(s1.length() == s2.length() && s1.length() == 0) {
            return true;
        }
        /*
        if(ch1==ch2) {
            return isMatch(len-1, len-1)
        } else if(ch2 == .) {
            (len-1, len) || (len-1, len-1)
        } else if(ch2 == char*) {
            (len-1, len) || (len-1, len-2) || (len, len-2)
        }  else {
            return false;
        }
        */

        return false;
    }

    private static boolean expression(String s1, String s2) {
        // a* => _, a, aa, ..
        // .* => _, ., .., ...,
        // .  => _, a, b , single char
        int[][] T = new int[s1.length()][s2.length()];

        return isMatch(s1, s2, T);
    }

    public static void main(String[] args) {
        System.out.println(expression("mississippi", "mis*is*p*."));
    }
}
