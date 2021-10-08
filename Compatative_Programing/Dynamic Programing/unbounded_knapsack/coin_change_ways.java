import java.util.Arrays;

/*
    cuts profit = 1 2 3
    N = 5
    Output: (total ways) 5
    1 1 1 1 1
    1 1 1 2
    1 2 2
    1 1 3
    3 2



    0   1   2   3   4   5
0   1   0   0   0   0   0
1   1   1   1   1   1   1
2   1   1   2   2   3   3
3   1   1   2   3   4   5



            i   i - arr[j-1] >= 0
                total += arr[i-arr[j-1]] till total coins

(){
    //n==0 -> 0
    //res[5+1]
    res[0] = 1

    for(i to a.len){
        for(j=1 to res.len) {
            if(j-a[i]>=0) {
                r[j] = res[j]+res[j-a[i]]
            }
        }
    }
}

*/


public class coin_change_ways {

    public static void main(String[] args) {
        int[] coin = {1, 2, 3};
        int total = 5;

        int result = totalWay(coin, total);
        System.out.println(result);
    }

    static int totalWay(int[] arr, int n) {
        //Base
        if(n==0) {
            return 1;
        }

        //Initalization
        int[] res = new int[n+1];
        res[0] = 1;

        for(int j=0; j<arr.length; j++) {
            for(int i=arr[j]; i<res.length; i++) {
                if(i - arr[j] >= 0) {
                    res[i] += res[i-arr[j]];
                }
            }
        }
        System.out.println(Arrays.toString(res));
        return res[n];
    }
}
