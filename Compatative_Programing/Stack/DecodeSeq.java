
/*

IIDDIDID  ——>  125437698    125437698
IDIDII    ——>  1325467
DDDD      ——>  54321
IIII      ——>  12345

*/

import java.util.*;

public class DecodeSeq {

    private static String decode(String str) {
        String result = "";
        int counter = 0;

        // put I int last of str
        str += "I";

        // Stack to store D
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == 'I') {
                counter++;
                // stack can be empty or not
                if(st.isEmpty()) {
                    result += counter;
                } else {
                    st.push(counter);
                    while(!st.isEmpty()) {
                        result += st.pop();
                    }
                }
            } else {
                counter++;
                st.push(counter);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        /*
        IIDDIDID  ——>  125437698    125437698
        IDIDII    ——>  1325467
        DDDD      ——>  54321
        IIII      ——>  12345
        */
        System.out.println(decode("IIDDIDID").equals("125437698"));
        System.out.println(decode("IDIDII").equals("1325467"));
        System.out.println(decode("DDDD").equals("54321"));
        System.out.println(decode("IIII").equals("12345"));
    }
}
