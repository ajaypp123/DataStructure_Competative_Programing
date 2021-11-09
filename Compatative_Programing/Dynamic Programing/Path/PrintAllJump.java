
/*
1. You are given a number N representing number of elements.
2. You are given N space separated numbers (ELE : elements).
3. Your task is to find & print
    3.1) "MINIMUM JUMPS" need from 0th step to (n-1)th step.
    3.2) all configurations of "MINIMUM JUMPS".
NOTE: Checkout sample question/solution video inorder to have more insight.


arr[] = 3 3 0 2 1 2 4 2 0 0
all path from first to last

arr[i] = 3 mean it can jump 1, 2, 3

*/

public class PrintAllJump {

    private static int minCost(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }

        int[] res = new int[arr.length];
        res[arr.length-1] = 1;

        // 3 3 0 2 1 2 4 2 0 0
        for(int i=arr.length-2; i>=0; i--) {
            for(int j=1; j<=arr[i]; j++) {
                if(i+j < arr.length) {
                    res[i] += res[i+j];
                }
            }
        }
        return res[0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
        System.out.println(minCost(arr));
    }
}
