

/*
Max sum in windows
        int[] arr = new int[]{12, -1, -7, 8, -16, 13, 30, 28};
        int[] ans = maxSum(arr, 3);

        ans = 13 + 30 + 28
*/




public class MaxSumWindow {

    private static int maxSum(int[] arr, int k) {
        if(k > arr.length)
            return -1;

        int max = 0;
        int curr = 0;

        int i=0, j=0;
        // capture first window
        for(j=0; j<k; j++) {
            curr += arr[j];
        }
        max = curr;

        j = k;
        //12, -1, -7, 8, -16, 13, 30, 28
        while(j<arr.length) {
            curr -= arr[i++];
            curr += arr[j++];
            max = Math.max(max, curr);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, -1, -7, 8, -16, 13, 30, 28};
        int ans = maxSum(arr, 3);
        System.out.println(ans);
    }
}
