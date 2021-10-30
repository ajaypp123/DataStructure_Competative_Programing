

/*
Example 1:
Input: s = "][]["
Output: 1
Explanation: You can make the string balanced by swapping index 0 with index 3.
The resulting string is "[[]]".

Example 2:
Input: s = "]]][[["
Output: 2
Explanation: You can do the following to make the string balanced:
- Swap index 0 with index 4. s = "[]][][".
- Swap index 1 with index 5. s = "[[][]]".
The resulting string is "[[][]]".

Example 3:
Input: s = "[]"
Output: 0
Explanation: The string is already balanced.


=============================================
Close = 0;
close ++ if found ) else close--
At every change of close compared with max_close

*/


public class MinSwapBalance {
    public static int minSwaps(String s) {
        // find extra pair
        // if [ then close-- if ] close++
        int close = 0, closeMax =0;

        for(char ch: s.toCharArray()) {
            switch(ch) {
                case '[':
                    close--;
                    break;
                case ']':
                    close++;
                    closeMax = Math.max(close, closeMax);
                    break;
            }
        }

        return (closeMax + 1)/2;
    }

    public static void main(String[] args) {
        System.out.println(minSwaps("]]][[["));
    }
}