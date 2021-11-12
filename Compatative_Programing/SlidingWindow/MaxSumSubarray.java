/*
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum.

{-2, -3, 4, -1, -2, 1, 5, -3}
Output: 7 {4, -1, -2, 1, 5}
*/

public class MaxSumSubarray {

    private static int maxSumRecursion(int[] arr, int i, int sum) {
        if(i == arr.length) {
            return 0;
        }

        int curr = sum + arr[i];
        int new_sum = 0;
        if(sum < 0) {
            // exclude current item
            new_sum = maxSumRecursion(arr, i+1, 0);
        } else {
            new_sum = maxSumRecursion(arr, i+1, curr);
        }

        return Math.max(new_sum, sum);
    }

    private static int maxSum(int[] arr) {
        // {-2, -3, 4, -1, -2, 1, 5, -3};
        if(arr.length == 0) {
            return 0;
        }

        //int i=0, j=1;
        int max = arr[0];
        int curr = arr[0];

        // {-2, -3, 4, -1, -2, 1, 5, -3};
        for(int i=1; i<arr.length; i++) {
            curr = curr + arr[i];

            max = Math.max(max, curr);

            if(curr < 0) {
                curr = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSum(arr));
        System.out.println(maxSumRecursion(arr, 1, arr[0]));
    }
}