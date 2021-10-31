

/*
Given an integer array nums and a positive integer k, return the most competitive subsequence of nums of size k.

An array's subsequence is a resulting sequence obtained by erasing some (possibly zero) elements from the array.

We define that a subsequence a is more competitive than a subsequence b (of the same length) if in the first position where a and b differ, subsequence a has a number less than the corresponding number in b. For example, [1,3,4] is more competitive than [1,3,5] because the first position they differ is at the final number, and 4 is less than 5.

Example 1:
Input: nums = [3,5,2,6], k = 2
Output: [2,6]
Explanation: Among the set of every possible subsequence: {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]}, [2,6] is the most competitive.

Example 2:
Input: nums = [2,4,3,3,5,4,9,6], k = 4
Output: [2,3,3,4]

=============================================


*******************************************
Similar to remove k digit to get smallest string

In this below question k = len -k
***********************************************


After analysis
from every possible set return set which appear first in lexicographical order.

Here, to obtain order we need to remove left grater element
So, simply ans length = k
    mean we can remove total_len - k

    removeCount = total_len - k

    for traverse
        if(recount == 0)
            break
        if(top > i)
            st.pop
            st.push i
            removeCount--

    Now remove all element from stack till removeCount became zero

*/

import java.util.*;

public class MostComSubSeq {

    public int[] mostCompetitive(int[] nums, int k) {
        //{3,5,2,6} 2
        int[] res = new int[k];
        // for lexi order need stack
        Stack<Integer> st = new Stack<>();
        st.push(nums[0]);

        int removeCount = nums.length - k;

         //{3,5,2,6} 2
        // remove left grater, we can remove len - k
        for(int i=1; i<nums.length; i++) {
            //if(removeCount == 0) {
            //    break;
            //}

            // pop till peek is grater or removeCount is not 0
            while(!st.isEmpty() && st.peek() > nums[i] && removeCount>0) {
                st.pop();
                removeCount--;
            }
            st.push(nums[i]);
        }
        System.out.println(st.toString());

        // remove pending element
        while(removeCount != 0) {
            st.pop();
            removeCount--;
        }

        while(!st.isEmpty()) {
            res[--k] = st.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,3,3,5,4,9,6};
        int[] arr1 = new int[]{3,5,2,6};

        int[] res;
        res = new MostComSubSeq().mostCompetitive(arr, 4);
        System.out.println(Arrays.toString(res));

        res = new MostComSubSeq().mostCompetitive(arr1, 2);
        System.out.println(Arrays.toString(res));
    }
}
