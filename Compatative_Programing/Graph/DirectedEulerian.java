
/*
Eulerian trail (or Eulerian path):
    Problem:
        - An Eulerian trail (or Eulerian path) is a path in a graph that visits every edge exactly once. Given a directed graph, check whether it has an Eulerian path or not.
        - All edge should be visited and traverse exactly once.
        - vertex can be visited again.

    Example:
        new Edge(0, 1), new Edge(1, 2), new Edge(2, 3), new Edge(3, 1),
        new Edge(1, 4), new Edge(4, 3), new Edge(3, 0), new Edge(0, 5),
        new Edge(5, 4)

    Output: True
        // It has Eulerian path: 0 —> 1 —> 2 —> 3 —> 0 —> 5 —> 4 —> 3 —> 1 —> 4
        // In above path all edges are covered.

    Condition for Eulerian Path:
        1. Degree
            - max 1 vertex can have in-degree = 1 + out-degree
            - max 1 vertex can have out-degree = 1 + in-degree
            - All remaining vertex should have in-degree == out-degree
        2. Connected component
            - Convert graph into undirected graph
            - All vertex of undirected graph should be path of single connected component.

    Complexity:
        - same as connected component: O(V+E)
================================================================================

Eulerian Cycle:
    Problem:
        - Given a directed graph, check if it is possible to construct a cycle that visits each edge exactly once, i.e., check whether the graph has an Eulerian cycle or not.


    Example: (Add new Edge(4,0))
        new Edge(0, 1), new Edge(1, 2), new Edge(2, 3), new Edge(3, 1),
        new Edge(1, 4), new Edge(4, 3), new Edge(3, 0), new Edge(0, 5),
        new Edge(5, 4), new Edge(4,0)

    Output: True
        // Eulerian Cycle: 0 —> 1 —> 2 —> 3 —> 0 —> 5 —> 4 —> 3 —> 1 —> 4 -> 0
        // In above path all edges are covered.

    Condition for Eulerian Cycle:
        1. Degree
            - All vertex should have in-degree == out-degree
        2. SSC
            - All vertex should belong to single strongly connected component.

    Complexity:
        - same as connected component: (2*O(V+E)) // 2 DFS
*/

import java.util.*;

class Vertex {
    public int in_degree;
    public int out_degree;
    public int vertex;

    Vertex(int v) {
        this.vertex = v;
        in_degree = 0;
        out_degree = 0;
    }

    public int hashCode() {
        return vertex;
    }

    public boolean equals(Vertex v1) {
        return this.vertex==v1.vertex;
    }
}

class DirectedEulerian {

    private static HashMap<Integer, Vertex> getSet(int[][] graph) {
        HashMap<Integer, Vertex> hs = new HashMap<>();
        /*
        HashSet<Vertex> hs  = new HashSet<>();
        for(i=0 to graph.length) {
            hs.add(i, new Vertex(i));
        }

        // Update degree
        for(edge in graph) {
            // e[0]--> e[1]
            hs.get(e[0]).out_degree++;
            hs.get(e[1]).out_degree++;
        }
        */
        return hs;
    }

    private static boolean isEulerianPath(int[][] graph) {
        boolean result = false;

        // 1. Check degree condition
        boolean most_in_degree = false;
        boolean most_out_degree = false;
        HashMap<Integer, Vertex> hm  = getSet(graph);
        for(int v: hm.keySet()) {
            // one can have in=Out+1 or out=in+1
            if(!most_in_degree && hm.get(v).in_degree == hm.get(v).out_degree+1) {
                most_in_degree=true;
            } else {
                result = false;
                return result;
            }

            if(!most_out_degree && hm.get(v).in_degree+1 == hm.get(v).out_degree) {
                most_out_degree=true;
            } else {
                result = false;
                return result;
            }
        }

        // 2. convert to undirected and check if it is single connected component
        // result = isConnectedComponent(g) // g is undirected graph
        return result;
    }

    private static boolean isEulerianCycle(int[][] graph) {
        boolean result = false;
        return result;
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

        int[][] graph1 = new int[][]{
                                        {0, 1, 0, 0, 0},
                                        {0, 0, 0, 1, 1},
                                        {0, 1, 0, 0, 1},
                                        {0, 0, 0, 0, 1},
                                        {0, 0, 0, 0, 0}
                                    };

        System.out.println(isEulerianPath(graph));
        System.out.println(isEulerianCycle(graph1));
    }
}