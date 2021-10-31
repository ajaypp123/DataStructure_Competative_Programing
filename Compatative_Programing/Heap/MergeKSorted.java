
/*
Input:  4 sorted lists of variable length

[10, 20, 30, 40]
[15, 25, 35]
[27, 29, 37, 48, 93]
[32, 33]

Output:

[10, 15, 20, 25, 27, 29, 30, 32, 33, 35, 37, 40, 48, 93]
*/

import java.util.*;

public class MergeKSorted {



    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(
                                        Arrays.asList(10, 20, 30, 40),
                                        Arrays.asList(15, 25, 35),
                                        Arrays.asList(27, 29, 37, 48, 93),
                                        Arrays.asList(32, 33)
                                    );

        //printSorted(lists);
    }
}
