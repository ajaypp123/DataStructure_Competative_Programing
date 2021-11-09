
/*
Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array such that the integers in the subsequence are sorted in increasing order. For example, if input is

{1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100),

{3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10)

{10, 5, 4, 3}, then output should be 10
*/


public class LISMemoization {

    private static int maxSum(int[] arr, int i, int prev, int[] T) {
        if(i==T.length) {
            return 0;
        }

        if(T[i] != 0) {
            System.out.println("Found");
            return T[i];
        }

        // 1, 101, 2, 3, 100, 4, 5
        int max = 0;
        if(arr[i-1] < prev) {
            max = maxSum(arr, i+1, prev, T);
            //System.out.println(arr[i]);
        } else {
            max = Math.max(
            arr[i-1] + maxSum(arr, i+1, arr[i-1], T),
            maxSum(arr, i+1, prev, T));
            //System.out.println(arr[i]);
        }

        return max;
    }

    private static int getLongLength(int[] arr, int i, int prev, int[] T) {
        if(i == T.length) {
            return 0;
        }

        if(T[i] != 0) {
            System.out.println("Found");
            return T[i];
        }

        // 1, 101, 2, 3, 100, 4, 5
        int max = 0;
        if(arr[i-1] < prev) {
            max = getLongLength(arr, i+1, prev, T);
        } else {
            max = Math.max(
            1 + getLongLength(arr, i+1, arr[i-1], T),
            getLongLength(arr, i+1, prev, T));
        }
        T[i] = max;
        return max;
    }

    private static int longLength(int[] arr) {
        if(arr.length == 1) {
            return 1;
        }

        // arr, i
        int T[] = new int[arr.length + 1];
        T[0] = 0;
        return getLongLength(arr, 1, 0, T);
    }

    private static int maxSum(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }

        // arr, i
        int T[] = new int[arr.length + 1];
        T[0] = 0;
        return maxSum(arr, 1, 0, T);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 101, 2, 3, 100, 4, 5};
        System.out.println(longLength(arr));
        System.out.println(maxSum(arr));
    }
}
