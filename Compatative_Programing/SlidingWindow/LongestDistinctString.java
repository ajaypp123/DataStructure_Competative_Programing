
/*
"aabbcc", k = 3

There are substrings with exactly 3 unique characters
{"aabbcc" , "abbcc" , "aabbc" , "abbc" }
*/

import java.util.*;

public class LongestDistinctString {

    private static int getLongString(String str, int k) {
        int i = 0, j = 0, max = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        // "aabbccd"
        while(j<str.length()) {

            // advance j
            while(map.size() <= k && j<str.length()) {
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
                if(map.size() == k) {
                    System.out.println(i + " " + j);
                    max = Math.max(max, j-i+1);
                }
                j++;
            }

            while(map.size() > k) {
                // advance i
                map.put(str.charAt(i), map.get(str.charAt(i))-1);
                if(map.get(str.charAt(i)) == 0) {
                    map.remove(str.charAt(i));
                }
                i++;
            }
        }
        return max;
   }

    public static void main(String[] args) {
        System.out.println(getLongString("haabbccd", 3));
    }
}
