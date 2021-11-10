

/*
Maximum Non-Overlapping Bridges
====================================

Consider a 2-D map with a horizontal river passing through its center. There are n cities on the southern bank with x-coordinates a(1) … a(n) and n cities on the northern bank with x-coordinates b(1) … b(n). You want to connect as many north-south pairs of cities as possible with bridges such that no two bridges cross. When connecting cities, you can only connect city a(i) on the northern bank to city b(i) on the southern bank. Maximum number of bridges that can be built to connect north-south pairs with the aforementioned constraints.

Input : 6 4 2 1
        2 3 6 5
Output : Maximum number of bridges = 2
Explanation: Let the north-south x-coordinates
be written in increasing order.

1  2  3  4  5  6
  \  \
   \  \        For the north-south pairs
    \  \       (2, 6) and (1, 5)
     \  \      the bridges can be built.
      \  \     We can consider other pairs also,
       \  \    but then only one bridge can be built
        \  \   because more than one bridge built will
         \  \  then cross each other.
          \  \
1  2  3  4  5  6

Input : 8 1 4 3 5 2 6 7
        1 2 3 4 5 6 7 8
Output : Maximum number of bridges = 5

*/

import java.util.*;

class CityPairs {
    int north, south;
    CityPairs(int north, int south) {
        this.north = north;
        this.south = south;
    }
}

public class NonOverLapBridges {

    private static int maxBridges(CityPairs[] pairs, int n) {
        if(pairs.length < 2) {
            return pairs.length;
        }

        int[] res = new int[n];
        res[0] = 1;

        /*
        for i=1 to res.length
            for j=0 to i-1
                if not overlap // both point should be left or right
                // pair.i.north - pair.j.north * i.south - j.south > 0
                // - * - = + and + * + = + mean not overlapping
                    res[i] = Math.max(res[i], 1 + res[j])

        */
        return 0;
    }

    public static void main(String[] args) {
        int n = 4;
        CityPairs[] pairs = new CityPairs[n];
        pairs[0] = new CityPairs(6, 2);
        pairs[1] = new CityPairs(4, 3);
        pairs[2] = new CityPairs(2, 6);
        pairs[3] = new CityPairs(1, 5);
        System.out.println("Maximum number of bridges = "
                           + maxBridges(pairs, n));
    }
}
