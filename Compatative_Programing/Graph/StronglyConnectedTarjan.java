
/*

Strongly Connected Component:
    Strongly connected graph:
        - If we can reach from every point to every other point then the given graph is strongly connected graph.
    Strongly Connected component (SSC):
        - If we divided graph so that every sub-graph is strongly connected graph then they called strongly connected component.
        - Single node is always strongly connected graph.
        - After reversing all edges then also SSC behavior remain same. Reversing all edges called transpose of graph.
    Undirected graph:
        - SSC in undirected graph = Number of connected component.


Four Type of edges:
    Suppose tree
            1
        2   3   4
    5   6   7   8   9

    1. Tree Edge: Edge between parent to child. Eg: 1-->2
    2. Forward Edge: Edge between indirect parent to child. Eg: 1-->5. // here 3 is in middle.
    3. Backward Edge: Edge from child to parent. Eg: 5-->1
    4. Cross Edge: Edge between sibling. Eg: 6-->8


Problem:
    Input:
        {x,y} mean edge x-->y
        {{0,1}{1,2}{2,0}  {2,3}{3,4}  {4,5}{5,6}{6,4}  {4,7}{6,7}}

    Output:
        4 Connected component
        0,1,2
        3
        4,5,6
        7

====================================================

Algorithm: Kosaraju Algorithm


==========================================================================
Time Complexity:

==========================================================================

Tarjan's vs Kosaraju's Algorithm:
    -
*/

import java.util.*;

class StronglyConnectedTarjan {

    private static int stronglyConnected(int V, int[][] points) {
        // counter set
        int count = 0;
        return count;
    }

	public static void main(String[] args) {
		int points1[][] = new int[][]{{0,1},{1,2},{2,0},  {2,3},{3,4},  {4,5},{5,6},{6,4},  {4,7},{6,7}};
		System.out.println("Output: " + stronglyConnected(8, points1));

        System.out.println();

		int points2[][] = new int[][]{{0,1},{1,2},{2,0},  {2,3},{4,3},  {4,5},{5,6},{6,4},  {4,7},{6,7}};
		System.out.println("Output: " + stronglyConnected(8, points2));
	}
}