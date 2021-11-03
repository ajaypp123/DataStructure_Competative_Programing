
/*

Find min window contains all letter from s2 in s1 window
        String s1 = "ADOBECODEBANC";
        String s2 = "ABC";
        Output: 4 ("ADOBECODE'BANC'")
*/

import java.util.*;


public class MinWindowSubstring {

    static int minWindow1(String s1, String s2) {
        /*
        String s1 = "ADOBECODEBANC";
        String s2 = "ABC";
        */
        int min = s1.length();

        // "ADOBECODEBANC"
        // map s2
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c: s2.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }

        // "ADOBECODEBANC"
        int i=0, j=0, count=hm.size(), flag=0;
        while(i != s1.length() && flag==0) {
            // put j
            if(hm.containsKey(s1.charAt(j))) {
                hm.put(s1.charAt(j), hm.get(s1.charAt(j))-1);
                count = hm.get(s1.charAt(j))==0?count-1:count;
            }

            // "ADOBECODEBANC"
            // i=1 j=10 A=0 B=1 C=0 count=1
            if(count == 0) {
                min = min>j-i+1?j-i+1:min;
                // reduce till count != 0
                while(count == 0) {
                    // reduce
                    if(hm.containsKey(s1.charAt(i))) {
                        hm.put(s1.charAt(i), hm.get(s1.charAt(i))+1);
                        count = hm.get(s1.charAt(i))>0?count+1:count;
                    }
                    i++;
                    // check min and update
                    min = min>j-i+1 && count==0 ?j-i+1:min;
                    flag=j==s1.length()-1 && count>0?1:0;
                }
            }
            j++;
        }

        return min;
    }

    private static int minWindow(String s1, String s2) {
        // String s1 = "ADOBECODEBANC";
        // String s2 = "ABC";

        // map of s2
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: s2.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        System.out.println(map.toString());

        int count = map.size();
        int i = 0, j = 0, size = s1.length();

        // String s1 = "ADOBECODEBANC";
        // String s2 = "ABC";
        while(j<s1.length()) {
            // advance j
            //System.out.println(map.toString() + " " + i + " " + j);
            while(j<s1.length()) {
                char ch = s1.charAt(j);
                if(map.containsKey(ch)) {
                    map.put(ch, map.get(ch)-1);
                    count = map.get(ch)==0?count-1:count;
                }

                System.out.println(map.toString() + " " + i + " " + j);

                if(count == 0) {
                    size = Math.min(size, j-i+1);
                    j++;
                    //System.out.println(i + " " + j + " " + size);
                    break;
                }
                j++;
            }

            // advance i
            // String s1 = "ADOBECODEBANC";
            // String s2 = "ABC";
            while(i<=j) {
                char ch = s1.charAt(i++);
                if(map.containsKey(ch)) {
                    map.put(ch, map.get(ch)+1);
                    count = map.get(ch)!=0?count+1:count;
                }
                System.out.println(map.toString() + " " + i + " " + j);
                if(count == 0) {
                    size = Math.min(size, j-i);
                } else {
                    break;
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String s2 = "ABC";

        System.out.println(minWindow(s1, s2));
        System.out.println(minWindow1(s1, s2));
    }
}
