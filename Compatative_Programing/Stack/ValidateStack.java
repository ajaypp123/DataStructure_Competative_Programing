/*
Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4),
pop() -> 4,
push(5),
pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
*/

import java.util.*;

public class ValidateStack {

    private static boolean validateStack(int[] pushArr, int[] popArr) {

        Stack<Integer> st = new Stack<>();
        st.push(pushArr[0]);

        int i = 1; //push
        int j = 0; //pop

        while(i<pushArr.length) {
            // if peek same as top then pop
            while(!st.isEmpty() && st.peek() == popArr[j]) {
                st.pop();
                j++;
            }
            st.push(pushArr[i]);
            i++;
        }

        while(j<popArr.length) {
            if(st.isEmpty()) {
                return false;
            } else if(st.peek() == popArr[j]) {
                st.pop();
                j++;
            } else {
                return false;
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        int[] push = new int[]{1,2,3,4,5};
        int[] pop = new int[]{4,5,3,2,1};

        System.out.println(validateStack(push, pop));
    }
}
