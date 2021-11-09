
/*
Given an integer N and a 2D array cost[][3], where cost[i][0], cost[i][1], and cost[i][2] is the cost of painting ith house with colors red, blue, and green respectively, the task is to find the minimum cost to paint all the houses such that no two adjacent houses have the same color.

Input: N = 3, cost[][3] = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}}
Output: 10
Explanation:
Paint house 0 as blue. Cost = 2. Paint house 1 as green. Cost = 5. Paint house 2 as blue. Cost = 3.
Therefore, the total cost = 2 + 5 + 3 = 10.


*/


import java.lang.*;

public class PaintHouse {

    private static int minCost(int costs[][]) {
        if(costs.length * costs[0].length == 0) {
            return 0;
        }

        // update cost it self
        /*

        min1_index , min2_index store for each row

        for i = 0 length
            for j = 0 to length
                if i == 0
                    cost[i][j] = cost[i][j]
                else
                    cost[i][j] = cost[i][j] + Min(
                            i-1 row but not cost[i-1][j]
                        )

        return min of last row
        */
        return 0;
    }

    // Driver code
    public static void main(String[] args) {

        int costs[][] = { { 14, 2, 11 },
                        { 11, 14, 5 },
                        { 14, 3, 10 } };

        // Function Call
        System.out.println(minCost(costs));
    }
}
