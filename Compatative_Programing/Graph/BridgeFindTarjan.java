
/*
Problem:
    Undirected graph.
    Find bridge edges in graph.

Bridge:
    The edge is called bridge edge if after removing this edge the number of connected component increased.

Example:
    1-2
    Here in graph 1-2 is bridge edge as if we remove it then component will get increases.

========================================================================

Solution:

1. Brute Force
    for(each edge)
        remove edge
        DFS() // if connected component increases then edge is bridge
        add edge
    - E*O(V+E)

2. Tarjan Solution
    - If there is no back edge from current point to its parent then it is edge.
    - from tarjan algorithm we can find bridge.
    - while backtrack if low arrival of adj is grater then it is bridge edge.

    1---2-------3
        |       |
        -----4---

    ** Here we need to differentiate tree edge and forward edge.
    eg:
        Here, 1--2 for 2, 1 is adj and already visited but not use full as it is tree edge.

        But, 4---2 for 4, 2 is adj and already visited but it is forward edge and use full to update parent.

    - above problem can be solved by keeping parent array.

    Here 1--2 is bridge edge.
    call        arrival   low arrival    parent   backtrack low arrival
-------------------------------------------------------------------------
    DFS(1)          1       1              1            1   // min(1,2) bridge
    DFS(2)          2       2              1            2
    DFS(3)          3       3              2            2
    DFS(4)          4       4              3           2

*/

import java.util.*;

class BridgeEdge {
    int x;
    int y;

    BridgeEdge(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return " " + this.x + " -- " + this.y;
    }
}

public class BridgeFindTarjan {

    private static List<List<Integer>> getMap(int V, int[][] points) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            List<Integer> li = new ArrayList<>();
            list.add(li);
        }

        for (int[] p : points) {
            int x = p[0];
            int y = p[1];
            // x -> y
            list.get(x).add(y);
            list.get(y).add(x);
        }
        return list;
    }

    private static int DFS(List<List<Integer>> map, int top, int[] discover, int[] low, int[] visited, int[] parent,
            int timer, List<BridgeEdge> list) {
        // visit v
        visited[top] = 1;
        discover[top] = timer;
        low[top] = timer;

        // add all adj node
        for (int adj : map.get(top)) {

            // if adj is not visited yet
            if (visited[adj] == 0) {
                parent[adj] = top;
                DFS(map, adj, discover, low, visited, parent, ++timer, list);
                low[top] = Math.min(low[top], low[adj]);
                // Find bridge in graph
                if (low[adj] > discover[top]) {
                    list.add(new BridgeEdge(top, adj));
                }

            } else if (adj != parent[top]) {
                low[top] = Math.min(low[top], discover[adj]);
            }
        }

        // all adj are visited, now we can remove it
        visited[top] = -1;
        return timer;
    }

    private static List<BridgeEdge> findBridge(int V, int[][] points) {
        // perform DFS for that get map
        List<List<Integer>> map = getMap(V, points);
        // track visited, low arrival and arrival/discover
        int[] discover = new int[V];
        int[] low = new int[V];
        int[] visited = new int[V];
        int[] parent = new int[V];
        Arrays.fill(low, Integer.MAX_VALUE);
        // all are self parent
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        // Add first element to stack
        List<BridgeEdge> list = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                t = DFS(map, i, discover, low, visited, parent, t, list);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        /*
         * Bridges in first graph [3 4] [0 3]
         *
         * Bridges in second graph [2 3] [1 2] [0 1]
         *
         * Bridges in third graph [1 6]
         *
         */
        int[][] edge1 = new int[][] { { 1, 0 }, { 0, 2 }, { 2, 1 }, { 0, 3 }, { 3, 4 } };
        System.out.println("Graph1 : " + findBridge(5, edge1));
        System.out.println();

        int[][] edge2 = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 } };
        System.out.println("Graph2: " + findBridge(4, edge2));
        System.out.println();

        int[][] edge3 = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 1, 3 }, { 1, 4 }, { 1, 6 }, { 3, 5 }, { 4, 5 } };
        System.out.println("Graph3: " + findBridge(7, edge3));
        System.out.println();
    }
}
