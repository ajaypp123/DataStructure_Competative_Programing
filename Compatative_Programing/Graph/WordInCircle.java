
/*
Problem Statement:
    Check if a set of words can be rearranged to form a circle

Explain:
    Given a set of words, check if the individual words can be rearranged to form a circle. Two words, X and Y, can be put together in a circle if the last character of X is the same as the first character of Y or vice-versa.

Example:
    Consider the following set of words:
    [ANT, OSTRICH, DEER, TURKEY, KANGAROO, TIGER, RABBIT, RAT, TOAD, YAK, HYENA]

Output: true
    The words can be rearranged as follows to form a circle. Note that, for any pair of consecutive words (X → Y) in the circle, the last character of the word X is the same as the first character of the word Y.

           ANT → TIGER → RABBIT → TOAD
            ↑                      ↓
          HYENA                   DEER
            ↑                      ↓
         OSTRICH                  RAT
            ↑                      ↓
         KANGAROO   ←  YAK   ←   TURKEY

=====================================================================
Solution:
    - After analysis, Here we have to check if Eulerian cycle exists in directed graph.

    ConditionL
        1. in_degree == out_degree
        2. single strongly connected component
*/


public class WordInCircle {

    private static boolean checkCycle(String[] words) {
        // return checkDegree(words) && isSingleStronglyConnected(words)
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"ANT", "OSTRICH", "DEER", "TURKEY", "TOAD", "YAK",
                        "KANGAROO", "TIGER", "RABBIT", "RAT", "HYENA"};
        System.out.println(checkCycle(words));
    }
}
