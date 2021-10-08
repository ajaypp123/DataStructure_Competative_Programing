

/*

		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
									{ 2, 0, 3, 8, 5 },
									{ 0, 3, 0, 0, 7 },
									{ 6, 8, 0, 0, 9 },
									{ 0, 5, 7, 9, 0 } };
        Cost = 16
Edge   Weight
0 - 1    2
1 - 2    3
0 - 3    6
1 - 4    5

0 --> 1  2
1 --> 2  3
1 --> 4  5
0 --> 3  6
16

*/

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

class SpanningTree {

    private static boolean isCycle(int[][] graph) {
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[graph.length];
        vis[0] = 1;
        st.push(0);
        int flag = 0;

        // 0 not vis    1 vis in stack  -1 vis not in stack
        while(st.size() != 0) {
            int v = st.peek();

            // find first dept
            for(int i=0; i<graph.length; i++) {
                if(i!=v && graph[v][i] != 0) {
                    if(vis[i] == 1) {
                        return true;
                    } else if(vis[i] == 0) {
                        vis[i] = 1;
                        flag = 1;
                        st.push(i);
                    } else {
                        continue;
                    }
                }
            }

            if(flag == 0) {
                st.pop();
                vis[v] = -1;
            }
            flag=0;
        }
        return false;
    }

    private int MST(int[][] graph) {
        int[] p = new int[graph.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // add graph in pq as edge
        for(int i=0; i<graph.length; i++) {

            // set parent array
            p[i] = i;

            for(int j=i+1; j<graph.length; j++) {
                if(graph[i][j] != 0) {
                    pq.add(new Edge(i, j, graph[i][j]));
                }
            }
        }

        // graph
        Graph g = new Graph();

        // total select v-1
        while(pq.size() !=0 || g.count!=graph.length-1) {
            Edge e = pq.peek();
            pq.remove();

            int x = findP(p, e.x);
            int y = findP(p, e.y);

            if(x != y) {
                g.add(e);
                //setP(p, e.x, x);
                setP(p, e.y, e.x);
            }
        }

        for(Edge e: g.edges) {
            System.out.println(e.x + " --> " + e.y + "  " + e.cost);
        }
        return g.cost;
    }

    private static void setP(int[] p, int ele, int parent) {
        p[ele] = parent;
    }

    private static int findP(int[] p, int ele) {
        if(ele == p[ele]) {
            return ele;
        } else {
            return findP(p, p[ele]);
        }
    }

	public static void main(String[] args) {
		SpanningTree t = new SpanningTree();
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
									{ 2, 0, 3, 8, 5 },
									{ 0, 3, 0, 0, 7 },
									{ 6, 8, 0, 0, 9 },
									{ 0, 5, 7, 9, 0 } };

        // System.out.println(t.isCycle(graph));
        System.out.println(t.MST(graph));
	}
}
