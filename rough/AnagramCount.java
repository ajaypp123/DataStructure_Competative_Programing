
import java.util.*;

class AnagramCount {
    public static void main(String[] args) {
        String s1 = "aabaabaa";
        String s2 = "aaba";
        int ans = countAnagram(s1, s2);
        System.out.println(ans);
    }

    private static int countAnagram(String s1, String s2) {
        /*
            String s1 = "aabaabaa";
            String s2 = "aaba";
            Output: 4
            =============================
            Anagram is any string which is continues but rearranged
            eg: aaba    abaa    aaba    abaa

            "aabaabaa"  -   Sliding window

            Map: a: 3 b: 1,     counter

            Step:
            1 map
            2 travel first seq and check

        */
        int result = 0;

        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s2.length(); i++) {
            hm.put(s2.charAt(i), hm.getOrDefault(s2.charAt(i), 0) + 1);
        }
        int count = hm.size();;

        /*
            String s1 = "aabaabaa";
            String s2 = "aaba";
        */
        for(int i=0; i<s2.length(); i++) {
            // s1 i in map
            if(hm.containsKey(s1.charAt(i))) {
                hm.put(s1.charAt(i), hm.get(s1.charAt(i))-1);
                count = (hm.get(s1.charAt(i))==0)?count-1:count;
            }
        }

        result = (count==0)?1:0;
        /*
            String s1 = "aabaabaa";
            String s2 = "aaba";
        */
        // travel k+1 to n
        int j = 0;
        for(int i=s2.length(); i<s1.length(); i++,j++) {
            // add current i in in hm
            if(hm.containsKey(s1.charAt(i))) {
                hm.put(s1.charAt(i), hm.get(s1.charAt(i))+1);
                count = (hm.get(s1.charAt(i))==1)?count+1:count;
            }

            // j int hm count--
            if(hm.containsKey(s1.charAt(j))) {
                hm.put(s1.charAt(j), hm.get(s1.charAt(j))-1);
                count = (hm.get(s1.charAt(i))==0)?count-1:count;
            }

            if(count == 0) {
                result++;
            }
        }
        //System.out.println(count);
        return result;
    }
}