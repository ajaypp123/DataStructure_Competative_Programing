
/**
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

===================================================

[2,1,5,6,2,3]

2   1   5   6   2   3
2   6   10  6   8   3
2   6   10  6   6   3

left to rigth
5             3 2 1                     3
4             2 1                       8
3             6 5 1                     6
2               5 1                     5
1               1                       2
0               2                       2

2   1   5   6   2   3
2   2   5   6   4   3

rigth to left
0       2         2 1                    2
1       1         1                      5
2       5         5 2                   10
3       6         6 2                   6
4       2         2                     4    1
5       3        . 3                    3    0

2   2   5   6   4   3
2   5   10  6   4   3
=======================
2   6   10  6   6   3

Max
res = 2   6   10  6   6   3
Stack = index   ele     cost
*/

import java.util.*;

class Stock {
    public int index;
    public int res;
}

public class MaxAreaHistogram {

    static int MAX = 0;

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,6,2,3};
        //int[] arr = new int[]{2,4};
        //int[] arr = new int[]{0,0};
        //int[] arr = new int[]{1,1};
        int res = histtogramMax(arr);
        System.out.println(res);
    }

    private static int histtogramMax(int[] arr) {

        Stack<Stock> stk = new Stack<>();
        int[] res = new int[arr.length];

        // left to right [2,1,5,6,2,3]
        for(int i=0; i<arr.length; i++) {
            Stock st = new Stock();
            st.index = i;
            st.res = arr[i];
            if(arr[i] == 0) {
                res[i] = 0;
                stk.push(st);
                continue;
            }
            while(stk.size() != 0) {
                if(arr[stk.peek().index] < arr[i]) {
                    break;
                }
                st.res += ((stk.peek().res / arr[stk.peek().index]) * arr[i]);
                stk.pop();
            }
            res[i] = st.res;
            stk.push(st);
        }

        System.out.println(Arrays.toString(res));
        stk.clear();

        // rigth to left [2,1,5,6,2,3]
        for(int i=arr.length-1; i>=0; i--) {
            Stock st = new Stock();
            st.index = i;
            st.res = res[i];
            if(arr[i] == 0) {
                res[i] = 0;
                stk.push(st);
                continue;
            }
            while(stk.size() != 0) {
                if(arr[stk.peek().index] < arr[i]) {
                    break;
                }
                st.res += ((stk.peek().res / arr[stk.peek().index]) * arr[i]);
                stk.pop();
            }
            res[i] = st.res - arr[i];
            if(MAX < st.res) {
                MAX = st.res;
            }
            stk.push(st);
        }
        System.out.println(Arrays.toString(res));
        return MAX;
    }


}
