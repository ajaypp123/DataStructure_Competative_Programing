


/*
All Pair shortest path algorithm.
-------------------------------------
Algorithm:
    1. Floyd Warshall
    2. Johnson's algorithm

=============================================

Floyd Warshall:

Problem:
Given a set of vertices V in a weighted graph where its edge weights w(u, v) can be negative, find the shortest path weights d(s, v) from every source s for all vertices v present in the graph. If the graph contains a negative-weight cycle, report it.

Example: Adjacency matrix

      0    1    2    3
----------------------------
0 |   0   30   -2   30
1 |   4    0    3   30
2 |  30   30    0    2
3 |   I   -1   30    0

All Pair Shortest Path Distance:
  0  -1  -2    0
  4   0   2    4
  5   1   0    2
  3  -1   1    0

Path
The shortest path from 0 —> 1 is (0 2 3 1)
The shortest path from 0 —> 2 is (0 2)
The shortest path from 0 —> 3 is (0 2 3)
The shortest path from 1 —> 0 is (1 0)
The shortest path from 1 —> 2 is (1 0 2)
The shortest path from 1 —> 3 is (1 0 2 3)
The shortest path from 2 —> 0 is (2 3 1 0)
The shortest path from 2 —> 1 is (2 3 1)
The shortest path from 2 —> 3 is (2 3)
The shortest path from 3 —> 0 is (3 1 0)
The shortest path from 3 —> 1 is (3 1)
The shortest path from 3 —> 2 is (3 1 0 2)

Floyd Warshall:
    - It used to find shortest path, from all vertex to all vertex.
    - Simple way is to perform dijkstra or bellman ford for all path.


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
    Here logic is for each i->j path check i->k->j k belong to all v and select minimum


    // As to find shortest path from each vertex to each vertex create matrix
    // Self distance = 0
    for each vertex v
        dist[v][v] = 0

    // Add remaining distance
    for each edge (u, v)
        dist[u][v] = weight(u, v)

    for k from 0 to |V| – 1
        for i from 0 to |V| – 1
            for j from 0 to |V| – 1
                if (dist[i][k] + dist[k][j]) is less than dist[i][j] then
                    dist[i][j] = dist[i][k] + dist[k][j]

===============================================

Complexity: O(V*V*V)
    - If all weight is positive then dijkstra will be use full to run for all vertex. then time complexity = V*dijkstra = V*O (V + E*log(V)), which is less than O(V*V*V)
    - for Bellman for run for each vertex then time complexity = V*V*V*V

*/


public class FloydWarshall {

    private static String getPath(int u, int v, int[][] parent) {
        // get path for u->v
        String path="";
        // If destination parent is source then print path
        if(parent[u][v] == u) {
            return path +"->"+ v;
        }

        // u->v parent is not u then get u-->k->v, where k=parent[u][v]
        return getPath(u, parent[u][v], parent) + "->" + v;
    }

    private static void printSolution(int[][] cost, int[][] parent) {
        for(int i=0; i<cost.length; i++) {
            for(int j=0; j<cost.length; j++) {
                if(i==j) {continue;}
                System.out.printf("Path (%d to %d), Min Cost: %d, Route: [%d%s]\n",
                                i, j, cost[i][j], i, getPath(i, j, parent));
            }
        }
    }

    private static void setCostPath(int[][] graph, int[][] cost, int[][] parent) {
        int I = Integer.MAX_VALUE;
        // set distance and path for each edge
        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph.length; j++) {
                // set cost for i-->j : default cost is same as given
                cost[i][j] = graph[i][j];

                // Set path for i-->j
                // self edge not exits so set 0
                if(i==j) {
                    parent[i][j] = 0;
                } else if(graph[i][j]==I) {
                    // cost of i-->j is INFINITY if no edge exists so set parent to -1
                    parent[i][j] = -1;
                } else {
                    // there is edge so set parent of i-->j is i
                    parent[i][j] = i;
                }
            }
        }
    }

    private static void shortestPath(int[][] graph) {
        int I = Integer.MAX_VALUE;
        // Create resultant matrix
        int[][] cost = new int[graph.length][graph.length];
        int[][] parent = new int[graph.length][graph.length];
        setCostPath(graph, cost, parent);

        // Apply algorithm
        // For each edge i-->j, compare i-->j with i-->k-->j
        // For each middle vertex k
        for(int k=0; k<graph.length; k++) {
            // For each edge i-->j
            for(int i=0; i<graph.length; i++) {
                for(int j=0; j<graph.length; j++) {

                    // check if i-->k and k-->j path exists
                    if(cost[i][k]==I || cost[k][j]==I) {
                        // path not exists check next edge
                        continue;
                    }

                    // cost compare i-->j with i-->k--j
                    if(cost[i][j] > cost[i][k]+cost[k][j]) {
                        cost[i][j] = cost[i][k]+cost[k][j];

                        // Update parent of i-->j to k-->j
                        parent[i][j] = parent[k][j];
                    }
                }
                // If there is negative distance in self edge then there is negative cycle
                if (cost[i][i] < 0) {
                    System.out.println("Negative-weight cycle found!!");
                    return;
                }
            }
        }

        printSolution(cost, parent);
    }

	public static void main(String[] args) {
        /*
        The shortest path from 0 —> 1, Min Cost: -1, Route: (0 2 3 1)
        The shortest path from 0 —> 2, Min Cost: -2, Route: (0 2)
        The shortest path from 0 —> 3, Min Cost: 0, Route: (0 2 3)
        The shortest path from 1 —> 0, Min Cost: 4, Route: (1 0)
        The shortest path from 1 —> 2, Min Cost: 2, Route: (1 0 2)
        The shortest path from 1 —> 3, Min Cost: 4, Route: (1 0 2 3)
        The shortest path from 2 —> 0, Min Cost: 5, Route: (2 3 1 0)
        The shortest path from 2 —> 1, Min Cost: 1, Route: (2 3 1)
        The shortest path from 2 —> 3, Min Cost: 2, Route: (2 3)
        The shortest path from 3 —> 0, Min Cost: 3, Route: (3 1 0)
        The shortest path from 3 —> 1, Min Cost: -1, Route: (3 1)
        The shortest path from 3 —> 2, Min Cost: 1, Route: (3 1 0 2)
        */
        int I = Integer.MAX_VALUE;

        // given adjacency representation of the matrix
        int[][] adjMatrix = new int[][]
                {
                        { 0, I, -2, I },
                        { 4, 0, 3, I },
                        { I, I, 0, 2 },
                        { I, -1, I, 0 }
                };

        // Run Floyd–Warshall algorithm
        shortestPath(adjMatrix);
	}
}
