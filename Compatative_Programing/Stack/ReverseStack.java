
/*
Reverse Stack:

4   1
3   2
2   3
1   4
===========================

1   =>   2 1

*/

import java.util.*;

public class ReverseStack {

    private static void pushEnd(Stack<Integer> st, int i) {
        if(st.size() == 0) {
            st.push(i);
            return;
        }
        int j = st.pop();
        // 1    // j
        pushEnd(st, i);
        // push j on top
        st.push(j);
    }

    private static void reverseStack(Stack<Integer> st) {
        if(st.size() <= 1) {
            return;
        }
        // 4 3 2 1
        int i = st.pop();
        // 1  // 2
        reverseStack(st);
        pushEnd(st, i);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st.toString());

        reverseStack(st);
        System.out.println(st.toString());
    }
}
