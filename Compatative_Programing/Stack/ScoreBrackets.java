

/*
Example 1:
Input: s = "()"
Output: 1

Example 2:
Input: s = "(())"
Output: 2

Example 3:
Input: s = "()()"
Output: 2

Example 4:
Input: s = "(()(()))"
Output: 6

The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
===============================================================

() => 1
(A) => A*2
AB  => A+B

every str start with '('
while
    top == A
        A+B
    i == )

    () or (A)

*/

import java.util.*;

public class ScoreBrackets {

    private static int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();

        // ( => 0
        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                st.push(0);
            } else {
                // ) mean () or (A) or (AB..)

                // handle ()
                if(st.peek() == 0) {
                    st.pop();
                    st.push(1);
                } else {
                    // (A) or (AB..)
                    int sum = 0;
                    while(st.peek() != 0) {
                        sum += st.pop();
                    }
                    st.pop();
                    st.push(sum*2);
                }
            }
        }
        // stack can have multiple independent result like ()()
        int sum = 0;
        while(st.size() != 0) {
            sum += st.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(()(()))"));
    }
}
