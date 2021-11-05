
/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

Example 1:
Input: numerator = 1, denominator = 2
Output: "0.5"

Example 2:
Input: numerator = 2, denominator = 1
Output: "2"

Example 3:
Input: numerator = 2, denominator = 3
Output: "0.(6)"

Example 4:
Input: numerator = 4, denominator = 333
Output: "0.(012)"

Example 5:
Input: numerator = 1, denominator = 5
Output: "0.2"
*/

import java.util.*;

public class FractionDecimal {

    private static String fractionToDecimal(int numerator, int denominator) {
        String ans = "";
        long n = numerator;
        long d = denominator;
        // 4 333   0.012

        // if 0 return
        if(numerator == 0) {
            return "0";
        }

        if(n < 0 && d < 0) {
            n *= -1;  d *= -1;
        } else if(n < 0) {
            n *= -1;
            ans  = "-" + ans;
        } else if(d < 0) {
            d *= -1;
            ans  = "-" + ans;
        }

        ans += n/d + "";
        if(n%d != 0)
            ans += ".";

        HashMap<Long, Integer> map = new HashMap<>();
        int pos = -1;
        String remain = "";
        long reminder = n % d;

        while(reminder != 0) {
            pos++;
            // 4 333   0.012
            if(map.containsKey(reminder)) {
                int start = map.get(reminder);
                remain = remain.substring(0, start) + "("
                            + remain.substring(start) + ")";
                break;
            } else {
                map.put(reminder, pos);
                remain += (reminder * 10)/d;
                reminder = (reminder * 10)%d;
            }
        }
        return ans + remain;
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 5));
        System.out.println(fractionToDecimal(2, 3));
        System.out.println(fractionToDecimal(4, 333));
        System.out.println(fractionToDecimal(-1, -2147483648)); // "0.0000000004656612873077392578125"
        System.out.println(fractionToDecimal(1, -2147483648));
        //System.out.println(-10000000000%-2147483648);
    }
}
