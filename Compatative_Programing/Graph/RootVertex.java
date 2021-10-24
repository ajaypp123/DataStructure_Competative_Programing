
/*
Problem:
    Find Root vertex of graph.

    A root vertex of a directed graph is a vertex u with a directed path from u to v for every pair of vertices (u, v) in the graph. In other words, all other vertices in the graph can be reached from the root vertex.

Example:
        new Edge(0, 1), new Edge(1, 2),
        new Edge(2, 3), new Edge(3, 0), new Edge(4, 3),
        new Edge(4, 5), new Edge(5, 0)

Output:
4       // all vertex can be visited by root

===============================================================

Solution 1:
    We need to find root of directed graph.
    we can use DFS/BFS and last vertex can be root

    for(i=0 to V)
        if(!vis[i])
            DFS(i, st, vis)
            root = i

    Now here root will updated every time we see unvisited vertex, and last vertex which
    visit all vertex is root.


    Condition:
        1. if directed/undirected graph with multiple component have to root.
        2. For undirected graph we can reach from any point to any point so all are root.

Solution 2:
    - Maintain parent array, and set parent for each v is v
    - for each edge u->v
        // Update parent parent of v is u
        x = Find(u)
        y = Find(v)
        if(x==y) {
            // no update need
        }
        parent[y] = x

    - for(i=0 to v)
        if(parent[i]==i)
            return i
========================================================================================

*/

import java.util.*;

public class RootVertex {

    private static int rootSearch(int[][] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(vis, false);

        // For every unvisited ele add into stack
        // use full for disjoint set
        int root = -1;
        for(int i=0; i<vis.length; i++) {
            if(!vis[i]) {
                st.push(i);
                DFS(graph, st, vis);
                root = i;
            }
        }

        // Confirm if graph is not disconnected graph
        st.clear();
        st.push(root);
        Arrays.fill(vis, false);
        DFS(graph, st, vis);
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                return -1;
            }
        }

        return root;
    }

    private static void DFS(int[][] graph, Stack<Integer> st, boolean[] vis) {
        // visit top
        int ele = st.peek();
        vis[ele] = true;

        // add first adj to stack
        for(int i=0; i<vis.length; i++) {
            if(!vis[i] && graph[ele][i]!=0) {
                st.push(i);
                DFS(graph, st, vis);
            }
        }

        // all adj for ele are visited so pop it
        st.pop();
    }

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
									{ 2, 0, 3, 8, 5 },
									{ 0, 3, 0, 0, 7 },
									{ 6, 8, 0, 0, 9 },
									{ 0, 5, 7, 9, 0 } };
        System.out.println(rootSearch(graph));
	}
}
