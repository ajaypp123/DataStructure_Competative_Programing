
/*
Problem:
    Undirected graph.
    Find all articulation Point.

Articulation Point:
    The vertex is articulation point, if after removing vertex the number of component increases.

Application:
    - It is used to find single point of failure in network. Which is also articulation point. If we remove this then it will divide network in sub network.

Example:
    1-2-3
    Here in  2 is articulation point as removing it will increases connected component.
    But 1, 3 are not increasing component after removing it.

    1--2--3
    |-----|
    No one is articulation point.

========================================================================

Solution 1: Brute force.
    for each point
        remove point
        then perform DFS and check if connected component increases.
            if component increase then it will be articulation point
        add point
    - V*O(V+E)

Solution 2:


*/

class ArticulationPoint {

    public static void main(String[] args) {
        /*
         * Map: {0=[0, 1, 2], 3=[3], 4=[4, 5, 6], 7=[7]} Output: 4
         *
         * Map: {0=[0, 1, 2], 1=[4, 5, 6], 3=[3], 4=[7]} Output: 4
         */
        int points1[][] = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 4 },
                { 4, 7 }, { 6, 7 } };
        // System.out.println("Output: " + stronglyConnected(8, points1));

        System.out.println();

        int points2[][] = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 2, 3 }, { 4, 3 }, { 4, 5 }, { 5, 6 }, { 6, 4 },
                { 4, 7 }, { 6, 7 } };
        // System.out.println("Output: " + stronglyConnected(8, points2));
    }
}
