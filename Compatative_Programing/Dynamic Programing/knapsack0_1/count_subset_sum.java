

/*
    arr {2, 3, 5, 6, 8, 10}
    10

    2 yes no | i > target then no

        0   1   2   3   4   5

    0   1   0   0...

    2   1

    3   1                   i/j  {0 2 3} 5  1] j-arr[i-1] < 0    [i-1][j]
                            2] yes total = [i-1][j-arr[i-1]]    [i-1][j]
    5   ..

    6

    8

    10

*/

public class count_subset_sum {

    public static void main(String[] args) {
        int[] W = {2, 3, 5, 6, 8, 10};

        int result = subset_sum(W, 6, 10);
        System.out.println(result);
    }

    private static int subset_sum(int[] W, int n, int target) {
        int T[][] = new int[n+1][target+1];

        // Initalization
        for(int i=0; i<T.length; i++) {
            T[i][0] = 1;
        }

        for(int i=1; i<T.length; i++) {
            for(int j=1; j<T[0].length; j++) {
                // is possible
                if(j-W[i-1] < 0) {
                    T[i][j] = T[i-1][j];
                } else {
                    T[i][j] = T[i-1][j] + T[i-1][j-W[i-1]];
                }
            }
        }
        return T[n][target];
    }
}