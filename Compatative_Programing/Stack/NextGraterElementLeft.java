
/**
 *
 * arr = [1,3,2,4}
 * output: [-1, -1, 3, -1]
 */

import java.util.*;

public class NextGraterElementLeft {

    private static int[] nextGraterLeft(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[arr.length];

        if(result.length == 0) {return result;}
        Arrays.fill(result, -1);
        st.push(arr[0]);

        // 1,3,2,4
        for(int i=1; i<arr.length; i++) {
            while(st.size() != 0) {
                if(st.peek() > arr[i]) {
                    result[i] = st.peek();
                    break;
                } else {
                    st.pop();
                }
            }
            st.push(arr[i]);
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(Arrays.toString(nextGraterLeft(new int[]{1,3,2,4})));
    }
}