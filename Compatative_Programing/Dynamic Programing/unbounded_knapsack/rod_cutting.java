import java.util.Arrays;

/*
    cuts profit = 0    1   5   8   9   10  17  17  20
    N = 8
    cut in i length gives profit of cut profit [i]
    Output:22

    0   1   2   3   4   5   6   7   8
    0   1           i
                    arr[4] = Max(arr[4], arr[i] + arr[4-i]) i = 0 to L

     0  1  5   8   9   10  17  17  20
    [0, 1, 6, 11, 16, 21, 26, 31, 36]
*/




public class rod_cutting {

    public static void main(String[] args) {
        int[] P = {1, 5, 8, 9, 10, 17, 17, 20};
        int length = 8;

        int result = cutRod(P, length);
        System.out.println(result);
    }

    static int cutRod(int[] arr, int n) {
        if(arr.length == 0 || n == 0) {
            return 0;
        }
        int[] res = new int[n+1];

        for(int i=1; i<res.length; i++) {
            for(int j=i; j>0; j--) {
                res[i] = Math.max(res[i], arr[j-1] + res[i-j]);
            }
        }
        System.out.println(Arrays.toString(res));
        return res[n];
    }
}
