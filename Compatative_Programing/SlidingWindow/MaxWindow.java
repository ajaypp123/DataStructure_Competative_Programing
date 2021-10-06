
/*

Find max sum for sliding window
arr[] = {2,3,5,2,9,7,1}
k=3
========================
        2,3,5           10
          3,5,2         10
            5,2,9       16
              2,9,7     18
                9,7,1   17      Max = 18
*/

public class MaxWindow {
    public static void main(String[] args) {
        int arr[] = new int[]{2,3,5,2,9,7,1};

        int max = maxWindow(arr, 3);
        System.out.println(max);
    }

    private static int maxWindow(int[] arr, int k) {
        // max
        int max = 0;
        int sum = 0;

        //travel k slide
        //{2,3,5,2,9,7,1}
        for(int j=0; j<k; j++) {
            sum += arr[j];
        }
        max = sum;
        // travel for other
        int i = 0;
        int j = k-1;
        while(j<arr.length-1) {
            sum -= arr[i++];
            sum += arr[++j];
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
