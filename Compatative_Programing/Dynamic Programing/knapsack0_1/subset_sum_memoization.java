
/*
2 3 7 8 20

11


*/
public class subset_sum_memoization {

    public static void main(String[] args) {
        int[] W = {2, 5, 1, 3, 4};
        int capacity = 7;
        int item = 5;

        boolean result = subset(W, capacity, item);
        System.out.println(result);
    }

    private static boolean subset(int[] arr, int target, int item) {

        int T[][] = new int[item+1][target+1];

        //Initalize
        for(int i=0; i<T.length; i++) {
            for(int j=0; j<T[i].length; j++) {
                T[i][j] = -1;
            }
        }

        //call
        // -1 not assign 1 false 0 true
        subset(arr, target, item, T);
        return T[item][target] == 0;
    }

    private static int subset(int[] arr, int target, int item, int[][] T) {
        if(target == 0) {
            return 0;
        } else if(target<0 || item==0) {
            return 1;
        }

        if(T[item][target] != -1) {
            return T[item][target];
        }

        int b = subset(arr, target, item-1, T);
        int c = subset(arr, target-arr[item-1], item-1, T);
        T[item][target] = (b==0 || c==0)?0:1;
        return T[item][target];
    }

}
