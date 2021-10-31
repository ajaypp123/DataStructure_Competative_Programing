
/*
1003. Check If Word Is Valid After Substitutions


Given a string s, determine if it is valid.

A string s is valid if, starting with an empty string t = "", you can transform t into s after performing the following operation any number of times:

Insert string "abc" into any position in t. More formally, t becomes tleft + "abc" + tright, where t == tleft + tright. Note that tleft and tright may be empty.
Return true if s is a valid string, otherwise, return false.

Example 1:
Input: s = "aabcbc"
Output: true
Explanation:
"" -> "abc" -> "aabcbc"
Thus, "aabcbc" is valid.

Example 2:
Input: s = "abcabcababcc"
Output: true
Explanation:
"" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
Thus, "abcabcababcc" is valid.

Example 3:
Input: s = "abccba"
Output: false
Explanation: It is impossible to get "abccba" using the operation.

======================================================

Solution

one unit is "abc"

    if st.top can able to convert to "abc"
        then modify top
    else
        add new element in stack

    // Now if top is "abc" one unit completed, pop it
    st.pop

*/

import java.util.*;

public class ValidSubstitution {

    private boolean isValid(String s) {
        Stack<String> st = new Stack<>();
        //"abcabcababcc"
        for(char ch: s.toCharArray()) {
            if(st.isEmpty()) {
                st.push("" + ch);
            } else {
                // if ch a then push it
                if(ch == 'a') {
                    st.push(ch + "");
                } else if(ch == 'b') {

                    // if ch b and top "a" then update else put
                    if(st.peek().equals("a")) {
                        st.pop();
                        st.push("ab");
                    } else {
                        st.push("b");
                    }
                } else {
                    // ch c then top mush be "ab"
                    if(st.peek().equals("ab")) {
                        st.pop();
                        st.push("abc");
                    } else if(st.peek().equals("b")) {
                        st.pop();
                        st.push("bc");
                    } else {
                        st.push("c");
                    }
                }

                if(st.peek().equals("abc")) {
                    st.pop();
                }
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        ValidSubstitution a = new ValidSubstitution();
        System.out.println(a.isValid("abcabcababcc"));
    }
}
