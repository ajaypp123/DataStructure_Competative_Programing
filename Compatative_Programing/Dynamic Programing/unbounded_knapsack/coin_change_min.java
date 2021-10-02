import java.util.Arrays;

/*
    cuts profit = 1 2 3
    N = 5
    Output: (total min coin) 2



    0   1   2   3   4   5
1   0   1   2   3   4   5
2   0   1   1   2   3   3
3   0   1   2   3   4   5

    0       i
            if(j - arr[i] > 0)
                T[i] = Min(T[i], 1 + T[j-arr[i]])
Min(curr)

            i   i - arr[j-1] >= 0
                total += arr[i-arr[j-1]] till total coins

*/



public class coin_change_min {

    public static void main(String[] args) {
        int[] coin = {1, 2, 3};
        int total = 5;

        int result = totalWay(coin, total);
        System.out.println(result);
    }

    static int totalWay(int[] arr, int n) {
        //Base
        if(n==0) {
            return 0;
        }

        //Initalization
        int[] res = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        System.out.println(Arrays.toString(res));

        for(int i=0; i<arr.length; i++) {
            for(int j=1; j<res.length; j++) {
                if(j - arr[i] >= 0) {
                    res[j] = Math.min(res[j], 1 + res[j-arr[i]]);
                }
            }
        }

        System.out.println(Arrays.toString(res));
        return res[n];
    }
}
