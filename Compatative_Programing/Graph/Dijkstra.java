

// Java Program to Implement Dijkstra's Algorithm
// Using Priority Queue

// Importing utility classes
import java.util.*;

import java.util.*;
import java.lang.*;
import java.io.*;

class Edge implements Comparable<Edge>{

    public int x;
    public int y;
    public int cost;

    Edge(int x, int y, int c) {
        this.x = x;
        this.y = y;
        this.cost = c;
    }

    public int compareTo(Edge e2) {
        if(this.cost > e2.cost) {
            return 1;
        } else if(this.cost < e2.cost) {
            return -1;
        } else {
            return 0;
        }
    }
}

class Graph {
    public ArrayList<Edge> edges;
    public int cost;
    public int count;

    Graph() {
        edges = new ArrayList<>();
        cost = 0;
        count = 0;
    }

    public void add(Edge e) {
        edges.add(e);
        cost += e.cost;
        count++;
    }
}

public class Dijkstra {

    private static void Dis(int[][] g, int s) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0, 0));
        int[] vis = new int[g.length];
        vis[0] = 1;

        while(pq.size() != 0) {
            Edge e = pq.peek();
            pq.remove();

            if(vis[e.y] != 1) {
                System.out.println(e.x + " -> " +e.y +"  "+e.cost);
                vis[e.y] = 1;
            }

            for(int i=0; i<g[e.y].length; i++) {
                if(vis[i]==0 && e.y!=i && g[e.y][i] != 0) {
                    pq.add(new Edge(e.y, i, g[e.y][i]));
                }
            }
        }
    }

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
									{ 2, 0, 3, 8, 5 },
									{ 0, 3, 0, 0, 7 },
									{ 6, 8, 0, 0, 9 },
									{ 0, 5, 7, 9, 0 } };

        // System.out.println(t.isCycle(graph));
        Dis(graph, 0);
	}
}
