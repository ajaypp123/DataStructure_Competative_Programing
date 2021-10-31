
/*

Remove duplicate and return lexicographical string

Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.



Example 1:
Input: s = "bcabc"
Output: "abc"

Example 2:
Input: s = "cbacdcbc"
Output: "acdb"

=====================================

same as remove k digit

just traverse in reverse order

*/

import java.util.*;

public class RemoveDuplicate {

    private String removeDuplicateLetters(String s) {
        String res = "";

        HashSet<Character> visited = new HashSet<>();
        Stack<Character> st = new Stack<>();

        // traverse in reverse order
        for(int i=s.length()-1; i>=0; i--) {
            // if not visited then put in stack
            if(!visited.contains(s.charAt(i))) {
                visited.add(s.charAt(i));
                st.push(s.charAt(i));
            } else {
                // if already visited and top is small then don't put else put
                if(st.peek() > s.charAt(i)) {
                    st.add(s.charAt(i));
                }
            }
        }

        // Now stack have lexo order already
        // pop from top but visit each element only once
        while(!visited.isEmpty()) {
            if(visited.contains(st.peek())) {
                res += st.peek();
                visited.remove(st.peek());
            }
            st.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicate().removeDuplicateLetters("cbacdcbc"));


        System.out.println(new RemoveDuplicate().removeDuplicateLetters("abacb"));

    }
}
