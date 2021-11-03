
/*
    Largest of Zero Sum Subarray
    Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
    Output: 5
    Explanation: The longest sub-array with
    elements summing up-to 0 is {-2, 2, -8, 1, 7}

    Input: arr[] = {1, 2, 3}
    Output: 0
    Explanation:There is no subarray with 0 sum

    Input:  arr[] = {1, 0, 3}
    Output:  1
    Explanation: The longest sub-array with
    elements summing up-to 0 is {0}
*/

import java.util.*;

public class LongZeroSumArray {

    private static int lenZeroSum(int[] arr) {
        int max = 0;
        // {-1,1,-2,2,-3,3,-4,4};
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        //map.put(arr[0], 0);

        //{15, -2, 2, -8, 1, 7, 10, 23};
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if(map.containsKey(sum)) {
                max = Math.max(max, i-map.get(sum));
                System.out.println(map.get(sum)+1 + " to " + i);
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(lenZeroSum(arr));
    }
}
