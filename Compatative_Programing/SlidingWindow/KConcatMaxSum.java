
/*
Given an integer array arr and an integer k, modify the array by repeating it k times.
For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].
Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in that case is 0.
As the answer can be very large, return the answer modulo 109 + 7.

Example 1:
Input: arr = [1,2], k = 3
Output: 9

Example 2:
Input: arr = [1,-2,1], k = 5
Output: 2

Example 3:
Input: arr = [-1,-2], k = 7
Output: 0
*/

public class KConcatMaxSum {

    private static int Kadans(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }

        int max = arr[0];
        int curr = arr[0];

        for(int i=1; i<arr.length; i++) {
            curr += arr[i];
            max = Math.max(max, curr);

            if(curr < 0) {
                curr = 0;
            }
        }

        return max;
    }

    private static int maxSum(int[] arr, int k) {
        if(k==1) {
            return Kadans(arr);
        }

        int sum = 0;
        for(int i: arr) {
            sum+=i;
        }

        int[] T = new int[arr.length*2];
        for(int i=0; i<arr.length; i++) {
            T[i] = arr[i];
            T[i+arr.length] = arr[i];
        }
        int max = Kadans(T);

        if(sum < 0) {
            return max;
        }
        return max + (k-2)*sum;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,-2,1};
        System.out.println(maxSum(arr, 5));
    }
}