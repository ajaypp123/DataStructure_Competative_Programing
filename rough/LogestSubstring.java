

import java.util.*;

class MaxSubarray {
    public static void main(String[] args) {
        String s1 = "aabacbebebe";
        int ans = getMaxSize(s1, 3);
        System.out.println(ans);
    }

    static void getMaxSize(String s, int k) {
        // Return max six with k unique char
        int max = -1;

        //"aabacbebebe"
        // i j = 0 travel j till k unique char
        // string i to j-1 size j-i-1
        HashMap<Character, Integer> hm = new HashMap<>();

        int i = 0, j = 0;
        while(j<s.length()) {
            // i to j match update max

            if(hs.size() == k) {

            }
            // less j++

            // max i++
        }
    }
}