
/*
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

===================================

if length == k
    return "0"
else

Stack:
Input: num = "1432219", k = 3
Output: "1219"
*****************************************
Similar to remove grater left element
*******************************************
   re 4    re 3    re 2
4  =>   3   =>  2   =>  2
1       1       1       1

put back in string
    1219
remove if any zero in start and return string

*/




/*

fun(String s, int k)

    if(len==k) {
        return "0";
    }

    Stack<I> st
    st.push(s.charAt(0)-'0')

    for(i=1; i<len; i++) {

        if(k==0) {
            break
        }

        int curr = s.charAt(i) - '0'
        if(curr < st.peek()) {
            st.pop()
            k--
        }
        st.push(curr)
    }

    // now add stack to remaining string
    remain = s.sub(i, len+1)

    while(st not empty) {
        remain = st.pop() + remain;
    }

    // remove all zero if it is in start like 00300 => 300 || 000 => 0
    for(i=0 to len) {
        if(no "0" || len == 1) {
            break
        }
        s = s.sub(i+1, len+1)
    }

    return remain;

*/