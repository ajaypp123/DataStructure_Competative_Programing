


/*
Single source shortest path algorithm.
-------------------------------------
Algorithm:
    1. Dijkstra
    2. Bellman Ford (Work with negative path also but slower)

=============================================

Problem:
Given a source vertex s from a set of vertices V in a weighted graph where its edge weights w(u, v) can be negative, find the shortest path weights d(s, v)  from source s for all vertices v present in the graph. If the graph contains a negative-weight cycle, report it.

Example:
Edges: {u, v, distance}
{0,1,-1} {0,2,4} {1,2,3} {1,3,2} {1,4,2}
{3,2,5} {3,1,1} {4,3,-3}

Path:
The distance of vertex 0 from the source is 0. Its path is [ 0 ]
The distance of vertex 1 from the source is -1. Its path is [ 0 1 ]
The distance of vertex 2 from the source is 2. Its path is [ 0 1 2 ]
The distance of vertex 3 from the source is -2. Its path is [ 0 1 4 3 ]
The distance of vertex 4 from the source is 1. Its path is [ 0 1 4 ]

BellmanFord
    - It used to find shortest path, can work with negative edges.


Limitation:
    - If graph have negative cycle then it will not work.
    - If undirected graph have negative edge (mean negative cycle 1-2 and 2-1 distance negative), then it will not work.

Negative Cycle:
    - {0,1, -2}, {1,2, 2}, {2,1, -2}
    - Relaxing:
                    0       1          2
        -------------------------------------
            0       0      INFINITY   INFINITY
           01       0       -2        INFINITY
          012       0       -2          0
         0120       -2      -2          0
    - Here we continue relaxing value will keep reducing called negative cycle.

Algorithm:
    Get shortest path:
        *- In dijkstra we relax every edge only once time, but in Bellman Ford we relax each edge (V-1) times, which cover all distance and gives minimum.
    Find negative edge:
        *- If we are relaxing (V-1) then we get shortest path, but if we relaxed one more time i.e. (v-1)+1 then
            - If there is no change then there is no negative cycle.
            - If path reduced then there is negative path

    // Step 1 – initialize the graph. In the beginning, all vertices weight of
    // INFINITY and a null parent, except for the source, where the weight is 0

    for each vertex v in vertices
        distance[v] = INFINITY
        parent[v] = NULL

    distance[source] = 0
    // Step 2 – relax edges repeatedly
        for i = 1 to V-1    // V – number of vertices
            for each edge (u, v) with weight w
                if (distance[u] + w) is less than distance[v]
                    distance[v] = distance[u] + w
                    parent[v] = u

    // Step 3 – check for negative-weight cycles
    for each edge (u, v) with weight w
        if (distance[u] + w) is less than distance[v]
            return “Graph contains a negative-weight cycle”

    return distance[], parent[]

===============================================

Complexity: O(VE) i.e. O((V-1)*E)
*/

import java.util.*;

public class BellmanFord {

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

    private static void shortestPath(int V, int[][] graph, int source,
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

                if(distance[v] > distance[u]+cost) {
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
        Shortest Path:
            The distance of vertex 0 from the source is 0. Its path is [ 0 ]
            The distance of vertex 1 from the source is -1. Its path is [ 0 1 ]
            The distance of vertex 2 from the source is 2. Its path is [ 0 1 2 ]
            The distance of vertex 3 from the source is -2. Its path is [ 0 1 4 3 ]
            The distance of vertex 4 from the source is 1. Its path is [ 0 1 4 ]
        */
		int graph[][] = new int[][] {
                        {0,1,-1}, {0,2,4},
                        {1,2,3}, {1,3,2},
                        {1,4,2}, {3,2,5},
                        {3,1,1}, {4,3,-3}};

        int[] dis = new int[5];
        int[] parent = new int[5];
        shortestPath(5, graph, 0, dis, parent);
        printData(0, dis, parent);
	}
}
