

/*
Given array, can we divide array in two subset
so that sum of both partition is equal


{1, 5, 11, 5}
Output: true   [11]  [5, 5, 1]

*/



public class EqualPartitionSum {

    private static boolean equalPartition(int[] arr, int item) {
        int target = 0;
        for(int i=0; i<arr.length; i++) {
            target += arr[i];
        }
        target = target/2;

        if(target == 0) {
            return true;
        }
        if(item == 0) {
            return false;
        }

        //Initialize
        boolean T[][] = new boolean[item+1][target+1];

        for(int i=0; i<T.length; i++) {
            T[i][0] = true;
        }

        for(int i=0; i<T[0].length; i++) {
            T[0][i] = false;
        }

        //call T[i][j]
        for(int i=1; i<T.length; i++) {
            for(int j=1; j<T[0].length; j++) {
                if(j-arr[i-1] < 0) {
                    T[i][j] = T[i-1][j];
                } else {
                    T[i][j] = (T[i-1][j-arr[i-1]]==true || T[i-1][j] == true)?true:false;
                }
            }
        }
        return T[item][target];
    }

    public static void main(String[] args) {
        int[] W = {1, 5, 11, 5};
        int item = 4;

        boolean result = equalPartition(W, item);
        System.out.println(result);
    }
}
