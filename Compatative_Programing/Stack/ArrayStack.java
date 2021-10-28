
interface IStack {
    public void push(int i) throws Exception;
    public int pop() throws Exception;
    public int peek();
}

public class ArrayStack implements IStack{

    int arr[];
    int top;
    int middle;

    ArrayStack() {
        arr = new int[50];
        top = -1;
        middle = -1;
    }

    @Override
    public void push(int i) throws Exception {
        if(top == 50-1) {
            throw new Exception("Overflow");
        }
        top++;
        updateMiddle();
        arr[top] = i;
    }

    @Override
    public int pop() throws Exception {
        if(top == -1) {
            throw new Exception("Underflow");
        }
        top--;
        updateMiddle();
        return arr[top+1];
    }

    @Override
    public int peek() {
        return arr[top];
    }

    private void updateMiddle() {
        // 0 1 2 3 4 5 6
        middle = top/2;
    }

    public int getMiddle() throws Exception {
        if(middle == -1) {
            throw new Exception("Underflow");
        }
        return arr[middle];
    }

    public static void main(String[] args) {
        ArrayStack st = new ArrayStack();
        try {
            st.push(0);
            System.out.println(st.getMiddle());

            st.push(1);
            System.out.println(st.getMiddle());

            st.push(2);
            System.out.println(st.getMiddle());

            st.push(3);
            System.out.println(st.getMiddle());

            st.push(4);
            System.out.println(st.getMiddle());

            System.out.println(st.peek());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}