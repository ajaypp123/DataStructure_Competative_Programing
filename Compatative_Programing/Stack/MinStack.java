
/*

push(x)
    if(x<min)
        st.push(2*x - min)
        min = x
    else
        st.push(x)

pop()
    if(min>st.peek())
        min = 2*min - st.peek()
    st.pop()

min()
    min

*/


import java.util.*;

public class MinStack {
    Stack<Integer> st;
    int min;

    MinStack() {
        min = 0;
        st = new Stack<>();
    }

    public void push(int x) {
        // 5 8 4 6 1 7
        if(st.size() == 0) {
            min = x;
            st.push(x);
        } else {
            if(x<min) {
                st.push( 2*x - min );
                min = x;
            } else {
                st.push(x);
            }
        }
    }

    public void pop() {
        if(st.peek() < min) {
            min = 2*min - st.peek();
        }
        st.pop();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        // 5 8 4 6 1 7
        MinStack mst = new MinStack();
        mst.push(5);
        System.out.println(mst.getMin());

        mst.push(8);
        System.out.println(mst.getMin());

        mst.push(4);
        System.out.println(mst.getMin());

        mst.push(6);
        System.out.println(mst.getMin());

        mst.push(1);
        System.out.println(mst.getMin());

        mst.push(7);
        System.out.println(mst.getMin());

        mst.pop();
        System.out.println(mst.getMin());
        mst.pop();
        System.out.println(mst.getMin());
        mst.pop();
        System.out.println(mst.getMin());
        mst.pop();
        System.out.println(mst.getMin());
    }
}
