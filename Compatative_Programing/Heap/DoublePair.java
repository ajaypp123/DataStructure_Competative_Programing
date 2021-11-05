
/*
Given an integer array of even length arr, return true if it is possible to reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, or false otherwise.



Example 1:
Input: arr = [3,1,3,6]
Output: false

Example 2:
Input: arr = [2,1,2,6]
Output: false

Example 3:
Input: arr = [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
*/

import java.util.*;

public class DoublePair {

    private static boolean canReorderDoubled(int[] arr) {
        // HashMap <int, count>
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

         //3,1,3,6
         // 4,-2,2,-4

        // for +ve check from backward
        for(int i=arr.length-1; i>=0; i--) {
            // if negative break it
            if(arr[i] < 0) {
                break;
            }

            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            } else if(map.containsKey(arr[i] * 2)) {
                map.put(arr[i] * 2, map.get(arr[i] * 2)-1);
                if(map.get(arr[i] * 2) == 0)
                    map.remove(arr[i] * 2);
            } else {
                map.put(arr[i], 1);
            }
            System.out.println(map.toString());
        }

        for(int i=0; i<arr.length; i++) {
            if(arr[i] >= 0) {
                break;
            }

            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            } else if(map.containsKey(arr[i] * 2)) {
                map.put(arr[i] * 2, map.get(arr[i] * 2)-1);
                if(map.get(arr[i] * 2) == 0)
                    map.remove(arr[i] * 2);
            } else {
                map.put(arr[i], 1);
            }
            System.out.println(map.toString());
        }

        if(map.containsKey(0) && map.get(0) % 2 == 0) {
            map.remove(0);
        }

        return map.size() == 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,-2,2,-4};
        System.out.println(canReorderDoubled(arr));
        arr = new int[]{3,1,3,6};
        System.out.println(canReorderDoubled(arr));

        // [2,1,2,1,1,1,2,2] true
        arr = new int[]{2,1,2,1,1,1,2,2};
        System.out.println(canReorderDoubled(arr));

        // [2,4,0,0,8,1] true
        arr = new int[]{2,4,0,0,8,1};
        System.out.println(canReorderDoubled(arr));
    }
}
