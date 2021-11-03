
/*
Input:  arr[] = {10, 12, 11};
Output: Length of the longest contiguous subarray is 3

Input:  arr[] = {14, 12, 11, 20};
Output: Length of the longest contiguous subarray is 2

Input:  arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
Output: Length of the longest contiguous subarray is 5
*/

import java.util.*;

public class LongContiguousArray {

    private static int lenContiguous(int[] arr) {
        int length = 1;

        // for every window
            // if max - min == window size
        // 1, 56, 58, 57, 90, 92, 94, 93, 91, 45
        // 6 7 7 9 // 4-1 = 9-6 so its should not be duplicate element

        for(int i=0; i<arr.length; i++) {

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            HashSet<Integer> hs = new HashSet<>();

            for(int j=i; j<arr.length; j++) {

                // break if duplicate
                if(hs.contains(arr[j])) {
                    break;
                }

                // parse element
                hs.add(arr[j]);
                min = Math.min(arr[j], min);
                max = Math.max(arr[j], max);

                // break if not continues
                if(max-min == j-i) {
                    System.out.println(i + " " + j);
                    length = Math.max(length, j-i+1);
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        System.out.println(lenContiguous(arr));
    }
}
