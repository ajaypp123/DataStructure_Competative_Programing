
/*
Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array such that the integers in the subsequence are sorted in increasing order. For example, if input is

{1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100),

{3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10)

{10, 5, 4, 3}, then output should be 10
*/


public class LISRecursion {

    private static int maxSum(int[] arr, int i, int prev) {
        if(i==arr.length) {
            return 0;
        }

        // 1, 101, 2, 3, 100, 4, 5
        int max = 0;
        if(arr[i] < prev) {
            max = maxSum(arr, i+1, prev);
            //System.out.println(arr[i]);
        } else {
            max = Math.max(
            arr[i] + maxSum(arr, i+1, arr[i]),
            maxSum(arr, i+1, prev));
            //System.out.println(arr[i]);
        }

        return max;
    }

    private static int getLongLength(int[] arr, int i, int prev) {
        if(i==arr.length) {
            return 0;
        }

        // 1, 101, 2, 3, 100, 4, 5
        int max = 0;
        if(arr[i] < prev) {
            max = getLongLength(arr, i+1, prev);
        } else {
            max = Math.max(
            1 + getLongLength(arr, i+1, arr[i]),
            getLongLength(arr, i+1, prev));
        }

        return max;
    }

    private static int longLength(int[] arr) {
        if(arr.length == 1) {
            return 1;
        }

        // arr, i
        return getLongLength(arr, 0, 0);
    }

    private static int maxSum(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }

        // arr, i
        return maxSum(arr, 0, 0);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 101, 2, 3, 100, 4, 5};
        System.out.println(longLength(arr));
        System.out.println(maxSum(arr));
    }
}
