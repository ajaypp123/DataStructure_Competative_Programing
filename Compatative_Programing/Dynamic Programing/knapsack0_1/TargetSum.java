

/*
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.



Example 1:
Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

Example 2:
Input: nums = [1], target = 1
Output: 1
*/

import java.util.Arrays;

public class TargetSum {
    // Similar to - [Count Subset Sum with Given Difference](./knapsack0_1/CountSubsetDiff.java)

    private static int countTargetSum(int[] W, int target) {
        // 1,1,1,1,1
        // s1 s2 : (total-s2) - s2 = target  = total - 2s2
        int total = 0;
        for(int w: W) {
            total += w;
        }

        int[][] T = new int[W.length+1][target+1];

        for(int i=0; i<T.length; i++) {
            T[i][0] = 1;
        }

        for(int i=1; i<T.length; i++) {
            for(int j=1; j<T[0].length; j++) {
                if(j-W[i-1] < 0) {
                    T[i][j] = T[i-1][j];
                } else {
                    T[i][j] = T[i-1][j] + T[i-1][j-W[i-1]];
                }
            }
        }

        int count = 0;
        // 2j - total  total=5 target=3

        for(int j=0; j<T[0].length; j++) {
            //System.out.println(T[T.length-1][j]);
            if(T[T.length-1][j] > 0) {
                if(Math.abs(2*j-total) == target) {
                    System.out.println(T[T.length-1][j] + " " + j);
                    // j-(total-j) = 2j-total == diff
                    count += T[T.length-1][j];
                }
            }
        }
        System.out.println(Arrays.toString(T[T.length-1]));
        return count;
    }

    public static void main(String[] args) {
        int[] W = {1,1,1,1,1};

        int result = countTargetSum(W, 3);
        System.out.println(result);
    }
}
