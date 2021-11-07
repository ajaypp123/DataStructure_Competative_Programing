
/*
Input: p[] = {40, 20, 30, 10, 30}
Output: 26000
There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
Let the input 4 matrices be A, B, C and D.  The minimum number of
multiplications are obtained by putting parenthesis in following way
(A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30

Input: p[] = {10, 20, 30, 40, 30}
Output: 30000
There are 4 matrices of dimensions 10x20, 20x30, 30x40 and 40x30.
Let the input 4 matrices be A, B, C and D.  The minimum number of
multiplications are obtained by putting parenthesis in following way
((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30

Input: p[] = {10, 20, 30}
Output: 6000
There are only two matrices of dimensions 10x20 and 20x30. So there
is only one way to multiply the matrices, cost of which is 10*20*30
*/

import java.util.*;

public class MCMMemoization {

    private static int MCM(int[] arr, int i, int j, int[][] T) {
        // 1,3,1,5,8,1
        if(j-i <= 0) {
            return 0;
        }

        if(T[i][j] != -1) {
            return T[i][j];
        }

        for(int k=i; k<j; k++) {

            T[i][k] = MCM(arr, i, k, T);
            T[k+1][j] = MCM(arr, k+1, j, T);

            int mul = (arr[i-1] * arr[k] * arr[j]);

            if(T[i][j] == -1) {
                T[i][j] = T[i][k] + T[k+1][j] + mul;
            } else {
                T[i][j] = Math.min(T[i][j], T[i][k] + T[k+1][j] + mul);
            }
        }

        return T[i][j];
    }

    private static int MCM(int[] arr) {
        if(arr.length <= 2) {
            return 0;
        }

        int i=1, j=arr.length-1;
        int[][] T = new int[arr.length][arr.length];

        for(int p=0; p<T.length; p++) {
            Arrays.fill(T[p], -1);
        }

        return MCM(arr, i, j, T);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,3,1,5,8,1};

        int min = MCM(arr);
        System.out.println(min);
    }
}
