
/*
Binary Strings with no consecutive 0's

Input: 1
Output: 1 (1, 0)

Input: 3
Output: 4 (11, 10, 01)

*/

public class CountBinary {

    private static int binaryCount(int n) {
        if(n==0) {
            return 0;
        }


        // Instated array we can only use variable as only previous value needed to take decision
        int[] zero = new int[n];
        int[] one = new int[n];
        zero[0] = 1;
        one[0] = 1;

        for(int i=1; i< zero.length; i++) {
            zero[i] = one[i-1];
            one[i] = zero[i-1] + one[i-1];
        }

        return zero[n-1] + one[n-1];
    }

    public static void main(String[] args) {
        System.out.println(binaryCount(10));
    }
}
