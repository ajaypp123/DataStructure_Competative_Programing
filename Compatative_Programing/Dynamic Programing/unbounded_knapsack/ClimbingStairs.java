
/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

import java.util.Arrays;

class ClimbingStairs {

    public int climbStairsMinMove(int n) {
        if(n==1) {
            return 1;
        }

        int[] arr = new int[n+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;

        for(int j=1; j<arr.length; j++) {
            // select 1 or 2 step
            for(int i=1; i<3; i++) {
                if(j-i >= 0) {
                    arr[j] = Math.min(arr[j-i] + 1, arr[j]);
                }
            }
        }
        return arr[arr.length-1];
    }

    public int climbStairsTotalWay(int n) {
        if(n==1) {
            return 1;
        }

        int[] arr = new int[n+1];
        arr[0] = 1;

        for(int j=1; j<arr.length; j++) {
            // select 1 or 2 step
            for(int i=1; i<3; i++) {
                if(j-i >= 0) {
                    arr[j] += arr[j-i];
                }
            }
        }
        return arr[arr.length-1];
    }
}