import java.util.Stack;


/*
Example 1:

Input: s = "())"
Output: 1

Example 2:

Input: s = "((("
Output: 3

Example 3:

Input: s = "()"
Output: 0

Example 4:

Input: s = "()))(("
Output: 4

*/


public class MinAddtoBalance {
    public static int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch: s.toCharArray()) {
            // ch can be ( or )
            // in both case stack can be empty or not
            switch(ch) {
                case '(':
                    st.push(ch);
                    break;
                case ')':

                    if(st.size() != 0 && st.peek()=='(') {
                        st.pop();
                    } else {
                        // push extra ( as close is missing
                        st.push(')');
                    }
                    break;
            }
        }
        return st.size();
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("()))(("));
    }
}
