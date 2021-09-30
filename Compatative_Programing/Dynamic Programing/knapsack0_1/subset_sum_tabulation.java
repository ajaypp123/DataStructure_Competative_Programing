
/*
2 3 7 8 10

11

    0   1   3   4   5   6   7   8   9   10 11
0   t   f   f   f ...
2   t
3   t               ij
7   .
8
10

5
3

3>5 x
5>3 yes no
yes arr[i-1] + T[i-1][j-arr[i-1]]
no  arr[i-1][j]
[i][j]

*/

public class subset_sum_tabulation {
    public static void main(String[] args) {
        int[] W = {2, 5, 1, 3, 4};
        int capacity = 7;
        int item = 5;

        boolean result = subset(W, capacity, item);
        System.out.println(result);
    }

    private static boolean subset(int[] arr, int target, int item) {

        if(target == 0) {
            return true;
        }
        if(item == 0) {
            return false;
        }

        //Initalize
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
}
