

/*

Input:   nums[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
         m = 2
Output:  5 7
We are allowed to flip maximum 2 zeroes. If we flip
nums[5] and nums[7], we get 8 consecutive 1's which is
maximum possible under given constraints



Input:   nums[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
         m = 1
Output:  7
We are allowed to flip maximum 1 zero. If we flip
nums[7], we get 5 consecutive 1's which is maximum
possible under given constraints.

Input:   nums[] = {0, 0, 0, 1}
         m = 4
Output:  0 1 2
Since m is more than number of zeroes, we can flip
all zeroes.

*/

import java.util.*;

public class LongFlipNZero {

    private static List<Integer> longFlipOne(int[] nums, int k) {
        LinkedList<Integer> curr = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        // 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1

        int i=0, j=0;
        int max = 0;
        int maxi=0, maxj=0;

        while(j<nums.length) {

            // advance j
            // 0,0,1,1,1,0,0
            while(j<nums.length) {
                if(curr.size() == k && nums[j] == 0) {
                    break;
                }

                if(nums[j] == 0) {
                    curr.addLast(j);
                }

                if(max < j-i+1) {
                    max = j-i+1;
                    result = (LinkedList<Integer>) curr.clone();
                    maxi = i;
                    maxj = j;
                }

                j++;
            }

            // advance i till 1 is released
            // release if j is not in its limit
            if(j<nums.length && curr.size() > 0) {
                i = curr.getFirst() + 1;
                curr.removeFirst();
            }

            // if  curr.size() is 0 mean j is not processed
            if(curr.size() == 0) { j++; i=j; }
        }

        System.out.println("Longest length: " + max);
        System.out.println("Start : " + maxi + ", End: " + maxj);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        System.out.println(longFlipOne(nums, 2).toString());

        int[] nums2 = new int[]{0,0,1,1,1,0,0};
        System.out.println(longFlipOne(nums2, 0).toString());
    }
}
