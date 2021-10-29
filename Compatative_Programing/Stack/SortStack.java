
/*
Reverse Stack:

2
4
3
9
10
===========================

size 5 -> 4 -> 3 -> 2 -> 1

*/

import java.util.*;

public class SortStack {

    private static void addInSortedStack(Stack<Integer> st, int i) {
        if(st.size() == 0 || st.peek() < i) {
            st.push(i);
            return;
        }

        int j = st.pop();
        // 1    // j
        addInSortedStack(st, i);
        // push j on top
        st.push(j);
    }

    private static void sortStack(Stack<Integer> st) {
        if(st.size() <= 1) {
            return;
        }
        // 4 3 2 1
        int i = st.pop();
        // 1  // 2
        sortStack(st);
        addInSortedStack(st, i);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(9);
        st.push(3);
        st.push(4);
        st.push(2);
        System.out.println(st.toString());

        sortStack(st);
        System.out.println(st.toString());
    }
}
