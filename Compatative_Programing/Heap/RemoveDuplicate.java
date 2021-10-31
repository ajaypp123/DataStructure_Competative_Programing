
/*
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in alphabetical order among all possible results.



Example 1:
Input: s = "bcabc"
Output: "abc"

Example 2:
Input: s = "cbacdcbc"
Output: "acdb"
*/

import java.util.*;

public class RemoveDuplicate {

    private String removeDuplicateLetters(String s) {
        PriorityQueue<Character> pq = new PriorityQueue<>();

        for(char ch: s.toCharArray()) {
            pq.add(ch);
        }

        String res = "" + pq.remove();

        while(!pq.isEmpty()) {
            char ch = pq.remove();

            if(res.charAt(res.length()-1) != ch) {
                res += ch;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicate().removeDuplicateLetters("cbacdcbc"));
    }
}
