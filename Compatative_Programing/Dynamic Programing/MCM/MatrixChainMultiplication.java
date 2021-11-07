
/**
Input: p[] = {40, 20, 30, 10, 30}
Output: 26000
There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
Let the input 4 matrices be A, B, C and D.  The minimum number of
multiplications are obtained by putting parenthesis in following way
(A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30

Input: p[] = {10, 20, 30, 40, 30}
Output: 30000
There are 4 matrices of dimensions 10x20, 20x30, 30x40 and 40x30.
Let the input 4 matrices be A, B, C and D.  The minimum number of
multiplications are obtained by putting parenthesis in following way
((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30

Input: p[] = {10, 20, 30}
Output: 6000
There are only two matrices of dimensions 10x20 and 20x30. So there
is only one way to multiply the matrices, cost of which is 10*20*30
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
