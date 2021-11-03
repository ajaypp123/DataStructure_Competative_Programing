
/*
1. You are given an array of integers(arr).
2. You have to find the count of equivalent subarrays.
3. A subarray is equivalent if,
   count of unique integers in the subarray = count of unique integers in the given array.

{2 1 3 2 3}
Output = 5

{2 1 3 2 3}
Output = 5  {2 1 3} {2 1 3 2} {2 1 3 2 3} {1 3 2} {1 3 2 3}
*/


public class EquivalentSubArray {

    private static int countEquivalentSubArray(int[] arr) {
        int count = 0;
        // Same as [Longest substring with k distinct char](LongestDistinctString.java)
        /*
            hs1 // total distinct char in string

            for i=0 to n

                hs2 = new

                for j=i to n
                    put j in hs2
                    if(hs1 size == hs2 size)
                        count++

        */

        return count;
   }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 3, 2, 3};
        System.out.println(countEquivalentSubArray(arr));
    }
}
