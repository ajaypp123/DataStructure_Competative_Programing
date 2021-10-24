
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

import java.util.*;

// BFS Cycle Detect
class BFSCycle {
    /*
        - Consider Queue
        - Visited array
            1. visited element          1
            2. not visited              0
            3. visited and in Queue    -1
    */

    public static boolean isCycle(int[][] graph) {
        // Create Queue and visited array
        LinkedList<Integer> que = new LinkedList<>();
        int vis[] = new int[graph.length];
        int countVisited = 0;
        que.addLast(0);
        vis[0] = 1;

        while(que.size()!=0 && countVisited<graph.length) {

            // if que is empty and countVisited != vertex count
                    // then add unvisited node to que
            if(que.size()==0) {
                // Add first unvisited node
                for(int i=0; i<vis.length; i++) {
                    if(vis[i]==0) {
                        que.addLast(i);
                        vis[i] = 1;
                    }
                }
            }

            // mark que first visited and add all adj
            int node = que.getFirst();
            vis[node] = -1;
            que.removeFirst();

            for(int i=0; i<graph.length; i++) {
                if(graph[node][i]!=0) {
                    if(vis[i]==1) {
                        return true;
                    } else {
                        que.add(i);
                        vis[i] = 1;
                    }
                }
            }
        }
        return false;
    }
}

public class DirectedCycleDetection_4 {

    private static boolean isCycle(int[][] graph) {
        return BFSCycle.isCycle(graph);
    }

    public static void main(String[] args) {
        // Cycle exists
        int[][] graph = new int[][]{
                                        {0, 1, 1, 1, 1, 0},
                                        {1, 0, 0, 1, 0, 0},
                                        {1, 0, 0, 0, 1, 1},
                                        {1, 1, 0, 0, 0, 1},
                                        {1, 0, 1, 0, 0, 0},
                                        {0, 0, 1, 1, 0, 0},
                                    };

        // Cycle not exists
        int[][] graph1 = new int[][]{
                                        {0, 1, 0, 0, 0},
                                        {0, 0, 0, 1, 1},
                                        {0, 1, 0, 0, 1},
                                        {0, 0, 0, 0, 1},
                                        {0, 0, 0, 0, 0}
                                    };

        // int points[][] = new int[][]{{0,1}, {0,3}, {3,0}, {1,2}, {2,3}};
        // Convert points[] to Graph then find cycle
        // It need to get adjacent node and only done by BFS and DFS as directed graph

        System.out.println(isCycle(graph));
        System.out.println(isCycle(graph1));
    }
}
