
/*
Find the longest path in a Directed Acyclic Graph (DAG)
-------------------------------------
Given a directed acyclic graph (DAG) and a source vertex, find the cost of the longest path from the source vertex to all other vertices present in the graph. If the vertex can’t be reached from the given source vertex, print its distance as infinity.

Edges:
    new Edge(0, 6, 2), new Edge(1, 2, -4),
    new Edge(1, 4, 1), new Edge(1, 6, 8),
    new Edge(3, 0, 3), new Edge(3, 4, 5),
    new Edge(5, 1, 2), new Edge(7, 0, 6),
    new Edge(7, 1, -1), new Edge(7, 3, 4),
    new Edge(7, 5, -4)

Output:
    dist(7, 0) =  7 (7 ——> 3 ——> 0)
    dist(7, 1) = -1 (7 ——> 1)
    dist(7, 2) = -5 (7 ——> 1 ——> 2)
    dist(7, 3) =  4 (7 ——> 3)
    dist(7, 4) =  9 (7 ——> 3 ——> 4)
    dist(7, 5) = -4 (7 ——> 5)
    dist(7, 6) =  9 (7 ——> 3 ——> 0 ——> 6)

===============================================
Solution: It is reverse of bellman ford
===============================================
Complexity: O(VE) i.e. O((V-1)*E)
*/

import java.util.*;

public class LongestPath {

    private static String getPath(int destination, int[] parent) {
        String path = "" + destination;
        if(destination == parent[destination]) {
            return path;
        }

        return getPath(parent[destination], parent) + "-->" + path ;
    }

    private static void printData(int source, int[] distance, int[] parent) {
        for(int i=0; i<distance.length; i++) {
            System.out.println(String.format(
                "Path (%d to %d), Min Cost: %d, Route: [%s]",
                source, i, distance[i], getPath(i, parent)));
        }
    }

    private static void longestPath(int V, int[][] graph, int source,
                                    int[] distance, int[] parent) {
        // Default distance for each vertex is INFINITY and parent is source
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, source);
        distance[source] = 0;

        // relax each edge v-1 times
        for(int i=0; i<V-1; i++) {

            // relax each edge
            for(int[] edge: graph) {
                // for edge {u,v,dis} if d[v] > d[u] + cost(u,v)
                int u = edge[0];
                int v = edge[1];
                int cost = edge[2];

                if(u==1 && v==2) {
                    System.out.println(distance[v]);
                }

                if(distance[v] < distance[u]+cost || distance[v]==Integer.MAX_VALUE) {
                    // update distance
                    distance[v] = distance[u]+cost;

                    // update parent;
                    // 0(source)-->1(u)-->2(v)
                    // v parent will change from source to u
                    parent[v] = u;
                }
            }
        }

        // Check if negative cycle exists by relaxing one more time
        for(int[] edge: graph) {
            // for edge {u,v,dis} if d[v] > d[u] + cost(u,v)
            if(distance[edge[1]] > distance[edge[0]]+edge[2]) {
                System.out.println("Negative cycle exists");
                break;
            }
        }
    }

	public static void main(String[] args) {
        /*
                {0, 6, 2}, {1, 2, -4},
                {1, 4, 1}, {1, 6, 8},
                {3, 0, 3}, {3, 4, 5},
                {5, 1, 2}, {7, 0, 6},
                {7, 1, -1}, {7, 3, 4},
                {7, 5, -4}
        */
		int graph[][] = new int[][] {
                {0, 6, 2}, {1, 2, -4},
                {1, 4, 1}, {1, 6, 8},
                {3, 0, 3}, {3, 4, 5},
                {5, 1, 2}, {7, 0, 6},
                {7, 1, -1}, {7, 3, 4},
                {7, 5, -4}};

        int[] dis = new int[8];
        int[] parent = new int[8];
        longestPath(8, graph, 7, dis, parent);
        printData(7, dis, parent);
	}
}
