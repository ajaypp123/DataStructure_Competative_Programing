
/*
Example 1:
Input: s = "(()())(())"
Output: "()()()"
Explanation:
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

Example 2:
Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation:
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".

Example 3:
Input: s = "()()"
Output: ""
Explanation:
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".

========================================

"(()())(())(()(()))"

Find independent pair
(()())      => ()()
(())        => ()
(()(()))    => ()(())

Now add result

Exception:
()      => () // if length of pair is 2

*/

public class RemoveOuterMost {

    public static String getInner(String str) {
        System.out.println(str);
        if(str.length() == 2) {
            return str;
        }
        // skip first and last letter
        return str.substring(1, str.length()-1);
    }

    public static String removeOuterParentheses(String s) {
        // if index 0 then found independent string
        int index = 0;
        // starting position of independent string
        int pos = 0;

        String result = ""; // (()())(())(()(()))
        for(int i=0; i<s.length(); i++) {

            if(s.charAt(i) == '(') {
                index++;
            } else {
                index--;
            }

            if(index == 0) {
                // found independent string
                result += getInner(s.substring(pos, i+1));
                pos = i+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
}
