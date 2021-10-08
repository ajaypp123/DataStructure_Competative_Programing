

/*
[1, 5, 11, 6]
s1 - s2 = min

min=MAX
1 s1, s2
f(arr, n, s1, s2)

n and (s1,s2)
------------------
Worst case:
[] [...] =
sum = 0, total
n = 0, n

        0, 1, 2 ... total

    0
    1
    5               i/j sum     j-arr[n-1] > 0 x
                                yes T[n-1][j-arr[n-1]]
                                no  T[n-1][j]
                                yes || no
*/

public class MaxSubsetSum {

    public static void main(String args[]) {
        System.out.println(minDiff(new int[]{1,5,11,6}));
    }

    private static int minDiff(int[] num) {
        int total = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<num.length; i++) {
            total += num[i];
        }

        boolean[][] T = new boolean[num.length+1][total+1];

        //Initialization
        for(int i=0; i<T.length; i++) {
            T[i][0] = true;
        }

        for(int i=1; i<T.length; i++) {
            for(int j=1; j<T[0].length; j++) {
                if(j-num[i-1] < 0) {
                    T[i][j] = T[i-1][j];
                } else {
                    T[i][j] = T[i-1][j] || T[i-1][j-num[i-1]];
                }
            }
        }

        for(int i=0; i<T[T.length-1].length; i++) {
            if(T[T.length-1][i] && Math.abs(2*i-total) < min) {
                min = Math.abs(i-(total-i));
            }
        }

        //fun(num, num.length, 0, T);
        return min;
    }
}