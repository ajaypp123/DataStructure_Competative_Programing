
/*
Detect if there is cycle in graph

===================================

* There can be two type of graph

1. Directed graph Cycle Detection Algorithm
    1. BFS
    2. DFS

2. Undirected graph Cycle Detection Algorithm
    1. Union Find Disjoint Set
    2. BFS
    3. DFS

Note: graph can be disconnected.
*/

// Union Find Cycle Detect
class UnionFind {

}

// BFS Cycle Dtect
class BFSCycle {
    /*
        - Consider Queue
        - Visited array
            1. visited element          1
            2. not visited              0
            3. visited and in Queue    -1
    */
}

// DFS Cycle Detect
class DFSCycle {
    /*
        - Consider Stack
        - Visited array
            1. visited element          1
            2. not visited              0
            3. visited and in Stack    -1
    */
}

public class CycleDetection_4 {

    private static boolean isCycle(int[][] graph) {
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                                        {0, 1, 1, 1, 1, 0},
                                        {1, 0, 0, 1, 0, 0},
                                        {1, 0, 0, 0, 1, 1},
                                        {1, 1, 0, 0, 0, 1},
                                        {1, 0, 1, 0, 0, 0},
                                        {0, 0, 1, 1, 0, 0},
                                    };
        System.out.println(isCycle(graph));
    }
}
