
/**
 *
 * arr = [4, 5, 2, 8, 10}
 * outpur: [-1, 4, -1, 2, 2]
 * ==============================
 *
 * 1. left to rigth
 * 2. pop till size 0
 *      if(top<i) res[i] = top
 *      else pop
 * 3. if st size 0 -1
 * 4. push
 */

import java.util.*;

public class NextSmallestLeft {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 2, 8, 10};
        int[] res = nextGLeft(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] nextGLeft(int arr[]) {
        /*
        * arr = [4, 5, 2, 8, 10}
        * outpur: [-1, 4, -1, 2, 8]
        */
        Stack<Integer> st = new Stack<>();
        int curr = 0;

        for(int i=0; i<arr.length; i++) {
            curr = arr[i];
            while(st.size() != 0) {
                if(st.peek() < curr) {
                    arr[i] = st.peek();
                    break;
                } else {
                    st.pop();
                }
            }
            if(st.size() == 0) {
                arr[i] = -1;
            }
            st.push(curr);
        }

        return arr;
    }
}
