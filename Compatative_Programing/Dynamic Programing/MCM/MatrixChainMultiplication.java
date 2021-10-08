
/**
 * {1,3,1,5,8,1}
*/

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int arr[] = new int[]{1,3,1,5,8,1};

        int min = MCM(arr);
        System.out.println(min);
    }

    private static int MCM(int[] arr) {
        if(arr.length < 3) {
            return 0;
        }
        return MCM(arr, 1, arr.length-1);
    }

    private static int MCM(int[] arr, int i, int j) {
        // 1,3,1,5,8,1
        if(i>=j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            int total = MCM(arr, i, k) + MCM(arr, k+1, j)
                        + (arr[i-1] * arr[k] * arr[j]);
            min = Math.min(total, min);
        }

        return min;
    }
}
