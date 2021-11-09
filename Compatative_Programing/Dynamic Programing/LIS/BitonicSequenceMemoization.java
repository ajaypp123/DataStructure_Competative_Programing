
/*
Given an array arr[0 … n-1] containing n positive integers, a subsequence of arr[] is called Bitonic if it is first increasing, then decreasing. Write a function that takes an array as argument and returns the length of the longest bitonic subsequence.
A sequence, sorted in increasing order is considered Bitonic with the decreasing part as empty. Similarly, decreasing order sequence is considered Bitonic with the increasing part as empty.
Examples:

Input arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
Output: 6 (A Longest Bitonic Subsequence of length 6 is 1, 2, 10, 4, 2, 1)

Input arr[] = {12, 11, 40, 5, 3, 1}
Output: 5 (A Longest Bitonic Subsequence of length 5 is 12, 11, 5, 3, 1)

Input arr[] = {80, 60, 30, 40, 20, 10}
Output: 5 (A Longest Bitonic Subsequence of length 5 is 80, 60, 30,
*/


public class BitonicSequenceMemoization {

    private static int getLongLength(int[] arr, int i, int prev, boolean flag, int[] T) {
        if(i == T.length) {
            return 0;
        }

        if(T[i] != 0) {
            System.out.println("Found");
            return T[i];
        }

        // 1, 101, 2, 3, 100, 4, 5
        int max = 0;
        // if flag is set true then search small element
        if(flag) {

            if(prev < arr[i-1]) {
                // can not include
                max = getLongLength(arr, i+1, prev, flag, T);
            } else {
                max = Math.max(
                                getLongLength(arr, i+1, prev, flag, T),  // no
                                1 + getLongLength(arr, i+1, arr[i-1], flag, T)  // yes
                            );
            }
        } else {
            // if flag is set false then search big element
            if(prev > arr[i-1]) {

                // include mean set flag
                max = Math.max(
                                getLongLength(arr, i+1, prev, flag, T),  // no
                                1 + getLongLength(arr, i+1, arr[i-1], true, T)  // yes
                            );
            } else {
                max = Math.max(
                                getLongLength(arr, i+1, prev, flag, T),  // no
                                1 + getLongLength(arr, i+1, arr[i-1], flag, T)  // yes
                            );
            }

        }

        T[i] = max;
        return max;
    }

    private static int longLength(int[] arr) {
        if(arr.length == 1) {
            return 1;
        }

        // arr, i
        // if flag false - search increasing
        // if flag true - search descring
        int T[] = new int[arr.length + 1];
        T[0] = 0;
        return getLongLength(arr, 1, 0, false, T);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(longLength(arr));
    }
}
