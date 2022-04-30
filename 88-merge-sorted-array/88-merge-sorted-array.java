class Solution {
    // Input: nums1 = [1,2,3,0,0,0,0,0], m = 3, nums2 = [1, 2, 3, 5, 6], n = 5
    //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    // Output: [1,2,2,3,5,6]
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p3 = nums1.length - 1;
        while(p1 >= 0 && p2 >= 0 && p3 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[p3] = nums1[p1];
                p1--;
            }else{
                nums1[p3] = nums2[p2];
                p2--;
            }
            p3--;
        }

        while(p2 >= 0){
            nums1[p3] = nums2[p2];
            p3--;
            p2--;
        }

    }
}