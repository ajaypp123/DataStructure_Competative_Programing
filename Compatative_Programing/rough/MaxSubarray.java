
/*
Return size of max subarray of sum 5
arr {4, 1, 1, 1, 2, 3, 5}
sum 5
============================
Sliding Window variable size:

    4, 1, 1, 1, 2, 3, 5
i=0
j=1
check i to j-1 sum
1. ==
    check max size j-1-i+1
2. size > sum
    i++
3. <
    j++
*/


import java.util.*;

class MaxSubarray {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 1, 1, 2, 3, 5};
        int ans = getMaxSize(arr, 5);
        System.out.println(ans);
    }

    private static int getMaxSize(int[] arr, int sum) {
        int max = 0;
        // 4, 1, 1, 1, 2, 3, 5
        int i =0, j = 0;
        int target = 0;

        while(j<arr.length) {
            if(target == sum) {
                /*
                check i to j-1 sum
                1. ==
                    check max size j-1-i+1
                */
                if(max < j-1-i+1) {
                    System.out.println(i + " " + (j-1));
                    max = j-1-i+1;
                }
                target += arr[j];
                j++;
            } else if(target > sum) {
                /*
                    2. size > sum
                    i++
                */
                target -= arr[i];
                i++;
            } else {
                /*
                    3. <
                    j++
                */
                target += arr[j];
                j++;
            }
        }
        return max;
    }
}