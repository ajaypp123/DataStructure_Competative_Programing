
/*
Problem Statement: Arrival and departure time of vertices in DFS

Given a graph, find the arrival and departure time of its vertices in DFS. The arrival time is the time at which the vertex was explored for the first time in the DFS, and departure time is the time at which we have explored all the neighbors of the vertex, and we are ready to backtrack.

*/

import java.util.*;

public class ArrivalDepartureDFS {

	public static void main(String[] args) {
        /*
            Vertex 0 (0, 11)
            Vertex 1 (1, 2)
            Vertex 2 (3, 10)
            Vertex 3 (4, 7)
            Vertex 4 (8, 9)
            Vertex 5 (5, 6)
            Vertex 6 (12, 15)
            Vertex 7 (13, 14)
        */
		int graph[][] = new int[][] {
                                    { 0, 1, 1, 0, 0, 0, 0, 0},
									{ 0, 0, 0, 0, 0, 0, 0, 0},
									{ 0, 0, 0, 1, 1, 0, 0, 0},
									{ 0, 1, 0, 0, 0, 1, 0, 0},
									{ 0, 0, 0, 0, 0, 1, 0, 0},
                                    { 0, 0, 0, 0, 0, 0, 0, 0},
                                    { 0, 0, 0, 0, 0, 0, 0, 1},
                                    { 0, 0, 0, 0, 0, 0, 0, 0}};

        int[] arrival = new int[graph.length];
        int[] departure = new int[graph.length];

        DFS(graph, arrival, departure);

        for(int i=0; i<graph.length; i++) {
            System.out.printf("Vertex %d (%d, %d)\n", i, arrival[i], departure[i]);
        }
	}

    private static void DFS(int[][] graph, int[] arrival, int[] departure) {
        boolean[] vis = new boolean[graph.length];
        Arrays.fill(vis, false);
        int count = -1;

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                count = Traverse(graph, i, vis, arrival, departure, count);
            }
        }
    }

    private static int Traverse(int[][] g, int v, boolean[] vis,
                                int[] arrival, int[] departure, int count) {
        vis[v] = true;
        arrival[v] = ++count;

        for(int i=0; i<g[v].length; i++) {
            if(g[v][i]!=0 && !vis[i] && v!=i) {
                count = Traverse(g, i, vis, arrival, departure, count);
            }
        }

        departure[v] = ++count;
        return count;
    }
}
