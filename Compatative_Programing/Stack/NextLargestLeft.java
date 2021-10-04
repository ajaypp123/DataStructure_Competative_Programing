

/**
 *
 * arr = [1,3,2,4}
 * outpur: [-1, -1, 3, -1]
 * ==============================
 *
 * first -1
 *
 * 1. left to rigth
 * 2. pop till size 0
 *      if(top>i) res[i] = top
 *      else pop
 * 3. if st size 0 -1
 * 4. push
 */

import java.util.*;

public class NextLargestLeft {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,4};
        int[] res = nextGLeft(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] nextGLeft(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int curr = 0;

        // 1. left to rigth
        for(int i=0; i<arr.length; i++) {
            curr = arr[i];
            //2. pop till size 0
            while(st.size() != 0) {
                if(st.peek() > curr) {
                    arr[i] =  st.peek();
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
