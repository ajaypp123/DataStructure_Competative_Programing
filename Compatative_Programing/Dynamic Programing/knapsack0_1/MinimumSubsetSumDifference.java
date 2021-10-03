/*
arr: [1, 11, 5, 6]
output: 1

For all : (Devide element in 2 parts)
[1] [11, 5, 6]
[11,1] [5,6]

Minimum difference is: [11,1] [5,6] = 1
-----------------------------------------------------
Solution:
Each element can take part in one or other part

s1 and s2 set
1 can either go to set 1 or 2


Solution1: Memoization:
=============
This is similart to equal subset sum
In equal subset sum
s1-s2 = 0
But here s1-s2 is minimum

Now, sum of all element = total
then total-s2 = s1
20=10+10
20=18+2
from them find pair with minimum value

Solution2:
================
Extrem case
s1=[] s2=[1, 11, 5, 6]
s1-s2 = 23



// Store sum only
ele\sum     0   1   2   3   ....

0           0   0   0   0
1           0
11          0
5                       i/j
6           ----1--

*/

public class MinimumSubsetSumDifference {
    public static void main(String[] args) {
        int[] W = {1, 11, 5, 6};

        int result = subset_sum(W);
        System.out.println(result);
    }

    private static int subset_sum(int[] W) {
        int min = Integer.MAX_VALUE;
        int total = 0;

        for(int i=0;i<W.length;i++) {
            total += W[i];
        }

        int T[][] = new int[W.length+1][total+1];

        for(int i=0; i<T.length-1; i++) {
            T[i][0] = 1;
        }

        for(int i=1; i<T.length; i++) {
            for(int j=1; j<T[i].length; j++) {
                if(j-W[i-1] < 0) {
                    T[i][j] = T[i-1][j];
                } else {
                    T[i][j] = T[i-1][j]==1?1:0;
                    T[i][j] = T[i][j]==1?1:T[i-1][j-W[i-1]];
                }
                //System.out.println(T[i][j]);
            }
        }

        for(int j=0; j<T[0].length; j++) {
            //System.out.println(T[T.length-1][j]);
            if(T[T.length-1][j] == 1) {
                if(min > Math.abs(2*j-total)) {
                    min = Math.abs(2*j-total);
                }
            }
        }

        return min;
    }
}
