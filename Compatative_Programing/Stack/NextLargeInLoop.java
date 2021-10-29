




/**
 *
 * arr = [1, 2, 3, 4, 2]
 * output: [2, 3, 4, -1, 3]
 * ==============================
 *
 * last 4   -1
 * 1. First add last ele to stack and replace word with -1
 * 2. for(i=n-2 to 0)
 *      while(st.size())
 *
 */

import java.util.*;


public class NextLargeInLoop {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,4};
        int[] res = nextG(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] nextG(int arr[]) {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<Integer>();
        int flag = 0;
        int loop = 0;

        while(loop <2) {
            for(int i=arr.length-1; i>=0; i--) {
                // pop till top>curr if yes set flag
                while(st.size() != 0) {
                    if(st.peek() > arr[i]) {
                        res[i] = st.peek();
                        flag = 1;
                        break;
                    } else {
                        st.pop();
                    }
                }
                if(flag == 0) {
                    res[i] = -1;
                }
                st.push(arr[i]);
                flag = 0;
            }
            loop++;
        }
        return res;
    }
}
