
/*
Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.

Input : arr[] = {5, 5, 10, 100, 10, 5}
Output : 110

Input : arr[] = {1, 2, 3}
Output : 4

Input : arr[] = {1, 20, 3}
Output : 20

*/



public class NonAdjMax {
    
    private static int maxNonAdjSumMemoization(int[] arr, int n, int[] T) {
        if(n<=0) {
            return 0;
        }
        
        if(T[n] != -1) { return T[n]; }
        
        //max
        int max = Math.max(
            maxNonAdjSum(arr, n-1, T),
            maxNonAdjSum(arr, n-2, T) + arr[n-1]);
        T[n] = max;
        return max;
    }
    
    private static int maxNonAdjSum(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }

        int[] yes = new int[arr.length];
        int[] no = new int[arr.length];
        yes[0] = arr[0];

        for(int i=1; i<arr.length; i++) {
            yes[i] = no[i-1] + arr[i];
            no[i] = Math.max(yes[i-1], no[i-1]);
        }

        return Math.max(yes[yes.length-1], no[no.length-1]);
    }

    public static void main(String[] args) {
        int[] W = {5, 5, 10, 100, 10, 5};

        int result = maxNonAdjSum(W);
        System.out.println(result);
    }
}
