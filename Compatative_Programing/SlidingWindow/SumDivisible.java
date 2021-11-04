import java.util.HashMap;

/*
Input : arr[] = {2, 7, 6, 1, 4, 5}, k = 3
Output : 4
The subarray is {7, 6, 1, 4} with sum 18,
which is divisible by 3.

Input : arr[] = {-2, 2, -5, 12, -11, -1, 7}
Output : 5

*/


public class SumDivisible {

    private static int lenKDivisibleSum(int[] arr, int k) {
        int max = 0;
        // reminder = (((sum % k) + k) % k)
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int reminder = 0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            reminder = (((sum % k) + k) % k);

            // 2, 7, 6, 1, 4, 5
            if(reminder == 0) {
                max = i + 1;  // at start will be 0
            } else if(!map.containsKey(reminder)) {
                map.put(reminder,i);
            } else {
                max = Math.max(max, i - map.get(reminder));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 6, 1, 4, 5};
        System.out.println(lenKDivisibleSum(arr, 3));
    }
}
