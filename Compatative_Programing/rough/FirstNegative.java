
import java.util.*;

class FirstNegative {
    public static void main(String[] args) {
        int[] arr = new int[]{12, -1, -7, 8, -16, 13, 30, 28};
        int[] ans = firstN(arr, 3);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] firstN(int[] arr, int k) {
        int[] res = new int[arr.length-k+1];

        int flag = 0;
        // travel first block
        int i = 0;
        int count = 0;


        //        1      3
        ////{12, -1, -7, 8, -16, 13, 30, 28};
        ////[-1, -1, -7, -16, -16, 0]
        for(int j=k-1; j<arr.length; j++) {
            // check if i in range
            if(i < j-k+1) {
                i = j-k+1;
            }

            do {
                if(arr[i] < 0) {
                    res[count++] = arr[i];
                    flag = 1;
                    break;
                }
                i++;
            } while(i != j);

            // found or not
            if(flag == 0) {
                res[count++] = 0;
            }
            flag = 0;
        }
        return res;
    }
}