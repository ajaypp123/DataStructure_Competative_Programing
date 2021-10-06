

/*

Find max substring with k unique char
str "aabacbebebe"
k=3
*/
import java.util.*;

public class MaxSubstring {
    public static void main(String[] args) {
        String str = "aabacbebebe";

        int max = maxWindow(str, 3);
        System.out.println(max);
    }

    static int maxWindow(String s, int k) {
        // "aabacbebebe"
        int max = 0;

        HashMap<Character, Integer> hm = new HashMap<>();

        int i = 0, j =0;
        // travel j till k unique
        // k+1 i++ till k then again j++
        while(j<s.length()) {
            // i to j j-i+1
            // add j in map
            hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0)+1);

            // size ==
            if(hm.size() == k) {
                max = (j-i+1)>max?j-i+1:max;
                j++;
            } else if(hm.size() > k && i < j) {
                // size grater remove i
                hm.put(s.charAt(i), hm.get(s.charAt(i))-1);
                if(hm.get(s.charAt(i)) == 0) {
                    hm.remove(s.charAt(i));
                }
                i++;
            } else {
                // size less remove i
                j++;
            }
        }
        return max;
    }
}
