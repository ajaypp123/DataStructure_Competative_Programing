import java.util.*;
import java.util.Arrays;

/*
Input: arr[] = {1, 2, 1, 3, 4, 2, 3};
       k = 4
Output: 3 4 4 3

Explanation:
First window is {1, 2, 1, 3}, count of distinct numbers is 3
Second window is {2, 1, 3, 4} count of distinct numbers is 4
Third window is {1, 3, 4, 2} count of distinct numbers is 4
Fourth window is {3, 4, 2, 3} count of distinct numbers is 3

Input: arr[] = {1, 2, 4, 4};
       k = 2
Output: 2 2 1

Explanation:
First window is {1, 2}, count of distinct numbers is 2
First window is {2, 4}, count of distinct numbers is 2
First window is {4, 4}, count of distinct numbers is 1
*/


public class DistinctElement {

    private static int[] distinctArray(int[] arr, int k) {
        int[] result = new int[arr.length-k+1];

        // First Window
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        result[0] = map.size();

        int i = 0;
        for(int j=k; j<arr.length; j++) {
            // remove i, insert j then result
            map.put(arr[i], map.getOrDefault(arr[i], 0)-1);
            if(map.get(arr[i]) == 0) {
                map.remove(arr[i]);
            }
            i++;
            map.put(arr[j], map.getOrDefault(arr[j], 0)+1);
            result[i] = map.size();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 3, 4, 2, 3};
        System.out.println(Arrays.toString(distinctArray(arr, 4)));
    }
}
