
/*
Input : arr[] = { 5, 10, 5, 2, 7, 1, 9 },
            k = 15
Output : 4
The sub-array is {5, 2, 7, 1}.

give window size
*/


public class LongestSumSubArray {

    private static int windowSize(int[] arr, int k) {
        int size = 0;

        int i=0, j=0;
        int sum = 0;
        while(j<arr.length) {

            // advance j till sum grater than k
            while(sum <= k && j<arr.length) {
                sum += arr[j];
                if(sum == k) {
                    System.out.println(" " + i + " " +j);
                    size = Math.max(size, j-i+1);
                }
                j++;
            }
            // 5, 10, 5, 2, 7, 1, 9

            // advance i till less
            while(sum > k) {
                sum -= arr[i++];
            }
        }

        return size;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 10, 5, 2, 7, 1, 9};
        System.out.println(windowSize(arr, 15));
    }
}
