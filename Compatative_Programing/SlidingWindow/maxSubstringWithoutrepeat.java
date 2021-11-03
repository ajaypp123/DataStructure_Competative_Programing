
/*

Find max substring with k unique char
str "aabacbebebe"
k=3   // acbe
*/
import java.util.*;

public class maxSubstringWithoutrepeat {


    static int maxWindow1(String s) {
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

    private static int maxWindow(String s) {
        // String str = "aabacbebebe";
        int i=0, j=0;
        int size = 0;
        HashSet<Character> hs = new HashSet<>();

        while(j<s.length()) {
            // advance j
            while(j<s.length() && !hs.contains(s.charAt(j))) {
                hs.add(s.charAt(j));
                j++;
            }

            size = Math.max(size, j-i);
            System.out.println(i + " " + j);

            // advance i
            while(j<s.length() && hs.contains(s.charAt(j))) {
                hs.remove(s.charAt(i++));
            }

        }
        return size;
    }

    public static void main(String[] args) {
        String str = "aabacbebebe";

        System.out.println(maxWindow(str));
        System.out.println(maxWindow1(str));
    }

}
