
/*

Find max substring with k unique char
str "aabacbebebe"
k=3
*/
import java.util.*;

public class maxSubstringWithoutrepeat {

    public static void main(String[] args) {
        String str = "aabacbebebe";

        int max = maxWindow(str, 3);
        System.out.println(max);
    }

    static int maxWindow(String s, int k) {
        if(s.length() == 0) {
            return 0;
        }
        // "aabacbebebe"
        int max = 0;
        HashSet<Character> hs = new HashSet<>();

        int i = 0, j = 0;
        while(j<s.length()) {
            // size ==
            if(hs.contains(s.charAt(j))) {
                hs.remove(s.charAt(i));
                i++;
            } else {
                // size less remove i
                hs.add(s.charAt(j));
                max = hs.size()>max?hs.size():max;
                j++;
            }
        }
        return max;
    }
}
