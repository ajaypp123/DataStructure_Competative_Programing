
/*

push(x)
    if(x>max)
        st.push(2*x + max)
        max = x
    else
        st.push(x)

pop()
    if(max<st.peek())
        max = 2*max + st.peek()
    st.pop()

max()
    max

*/


import java.util.*;

public class MaxStack {
    Stack<Integer> st;
    int max;

    MaxStack() {
        max = 0;
        st = new Stack<>();
    }

    public void push(int x) {
        // 5 8 4 6 1 7
        if(st.size() == 0) {
            max = x;
            st.push(x);
        } else {
            if(x > max) {
                st.push( 2*x + max );
                max = x;
            } else {
                st.push(x);
            }
        }
    }

    public void pop() {
        if(st.peek() > max) {
            max = 2*max + st.peek();
        }
        st.pop();
    }

    public int getMax() {
        return max;
    }

    public static void main(String[] args) {
        // 5 8 4 6 1 7
        MaxStack mst = new MaxStack();
        mst.push(5);
        System.out.println(mst.getMax());

        mst.push(8);
        System.out.println(mst.getMax());

        mst.push(4);
        System.out.println(mst.getMax());

        mst.push(6);
        System.out.println(mst.getMax());

        mst.push(1);
        System.out.println(mst.getMax());

        mst.push(7);
        System.out.println(mst.getMax());

        mst.pop();
        System.out.println(mst.getMax());
        mst.pop();
        System.out.println(mst.getMax());
        mst.pop();
        System.out.println(mst.getMax());
        mst.pop();
        System.out.println(mst.getMax());
    }
}
