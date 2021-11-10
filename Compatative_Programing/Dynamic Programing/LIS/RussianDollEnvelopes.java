/*
Russian Doll Envelopes
===========================

You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.

Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

*/

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length < 2) {
            return envelopes.length;
        }

        int[] res = new int[n];
        res[0] = 1;

        /*
        for i=1 to res.length
            for j=0 to i-1
                if not overlap
                // - * - = + and + * + = + mean not overlapping
                    res[i] = Math.max(res[i], 1 + res[j])

        */
        return 0;
    }
}