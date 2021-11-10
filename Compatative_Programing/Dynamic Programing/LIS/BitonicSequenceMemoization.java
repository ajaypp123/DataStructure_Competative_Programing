
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

import java.util.*;

public class BitonicSequenceMemoization {

    private static int getLongLengthDesc(int[] arr, int i, int prev, int[] T) {
        if(i == T.length) {
            return 0;
        }

        if(T[i] != 0) {
            System.out.println("Found");
            return T[i];
        }

        // 1, 101, 2, 3, 100, 4, 5
        int max = 0;
        if(arr[i-1] >= prev) {
            max = getLongLengthInc(arr, i+1, prev, T);
        } else {
            max = Math.max(
            1 + getLongLengthInc(arr, i+1, arr[i-1], T),
            getLongLengthInc(arr, i+1, prev, T));
        }
        T[i] = max;
        return max;
    }

    private static int getLongLengthInc(int[] arr, int i, int prev, int[] T) {
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
            max = getLongLengthInc(arr, i+1, prev, T);
        } else {
            max = Math.max(
            1 + getLongLengthInc(arr, i+1, arr[i-1], T),
            getLongLengthInc(arr, i+1, prev, T));
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
        // inc
        getLongLengthInc(arr, 1, 0, T);
        //desc
        int T1[] = new int[arr.length + 1];
        T1[0] = 0;
        getLongLengthDesc(arr, 1, 0, T1);

        System.out.println(Arrays.toString(T));
        System.out.println(Arrays.toString(T1));

        int ans = 0;
        for(int i=0; i<T.length; i++) {
            ans = Math.max(ans, T[i] + T1[i] - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(longLength(arr));
    }
}
