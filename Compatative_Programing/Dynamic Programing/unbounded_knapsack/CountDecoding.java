
/*
Let 1 represent ‘A’, 2 represents ‘B’, etc. Given a digit sequence, count the number of possible decodings of the given digit sequence.

Input:  digits[] = "121"
Output: 3
// The possible decodings are "ABA", "AU", "LA"

Input: digits[] = "1234"
Output: 3
// The possible decodings are "ABCD", "LCD", "AWD"

*/

public class CountDecoding {

    private static int decodeCount(String str) {
        // consider space 1 and building 0
        if(str.length()==0) {
            return 0;
        }

        int[] res = new int[str.length()];
        res[0] = 1;

        for(int i=1; i<res.length; i++) {
            int p = ( ((str.charAt(i-1)-'0') * 10) + (str.charAt(i)-'0') );

            if(p<=26) {
                res[i] = res[i-1] + 1;
            } else {
                res[i] = res[i-1];
            }
        }
        return res[res.length-1];
    }

    public static void main(String[] args) {
        System.out.println(decodeCount("123412"));
    }
}
