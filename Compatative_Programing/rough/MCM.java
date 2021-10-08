
/*
                10, 30, 5, 60 | i=1,k=2,j=3 | ABCD = 0 + 9000 + 10*30*60 = ---

        i=1,j=2 | (AB)C =0                     i=2,j=3 | A(BC) = 0+0+ 30*5*60 = 9000
                            i=2,j=2 | A(B)CD = 0           i=3,j=3 | AB(CD) = 0


*/
import java.util.*;

class MCM {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 30, 5, 60};
        int ans = minMul(arr);
        System.out.println(ans);
    }

    private static int minMul(int[] arr) {
        //40, 20, 30, 10, 30
        // i-1, i   j   k

        return minMul(arr, 1, arr.length-1);
        //return 0;
    }

    private static int minMul(int[] arr, int i, int j) {
        //40, 20, 30, 10, 30
        if(i>=j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for(int k=i; k<j; k++) {
            int min1 = minMul(arr, i, k);
            int min2 = minMul(arr, k+1, j);
            int total = min1 + min2 + (arr[i-1]*arr[k]*arr[j]);
            if(total < min) {
                min = total;
            }
        }
        return min;
    }
}