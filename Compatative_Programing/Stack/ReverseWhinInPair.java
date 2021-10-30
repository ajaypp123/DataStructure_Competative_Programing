


/*
Example 1:
Input: s = "(abcd)"
Output: "dcba"

Example 2:
Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.

Example 3:
Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.

Example 4:
Input: s = "a(bcdefghijkl(mno)p)q"
Output: "apmnolkjihgfedcbq"


==========================
"(u(love)i)" => (uevoli) => iloveu

    - simply if ) then pop str till (
        then pop (
        reverse extracted string and put it in
====================================================
    for(0 to n)
        // from "(u(love)i)" this push "(u(love"
        if ch not )
            push(ch)
        else
            str = ""
            // "(u(love" => "(uevol"
            while(top != '(')
                str = pop() + str;
            pop()
            for ch in str
                push(ch)
*/


public class ReverseWhinInPair {

}
