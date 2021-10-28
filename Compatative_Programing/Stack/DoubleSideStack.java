
/*
With single array build double stack.

    st1 -->  1   2   3   4  <-- st2
*/

public class DoubleSideStack {

    int arr[];
    int top1;
    int top2;

    DoubleSideStack(int size) {
        arr = new int[size];
        top1 = -1;
        top2 = size;
    }

    public void push(int st_no, int i) throws Exception {
        // st_no 1 or 2
        // 1--><--2 // for both if next position already taken then overflow
        if(top1 == top2-1) {
            throw new Exception("Overflow");
        }
        if(st_no == 1) {
            arr[++top1] = i;
        } else {
            arr[--top2] = i;
        }
    }

    public int pop(int st_no) throws Exception {
        // pop
        if(top1 == -1 || top2 == arr.length) {
            throw new Exception("Underflow");
        }
        if(st_no == 1) {
            return arr[top1--];
        } else {
            return arr[top2++];
        }
    }

    public int peek(int st_no) {
        if(st_no == 1) {
            return arr[top1];
        } else {
            return arr[top2];
        }
    }

    public static void main(String[] args) {
        DoubleSideStack st = new DoubleSideStack(3);
        try {
            st.push(1, 0);
            System.out.println(st.peek(1));

            st.push(2, 0);
            System.out.println(st.peek(2));

            st.push(1,3);
            System.out.println(st.peek(1));

            st.push(2, 3);
            System.out.println(st.peek(2));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
