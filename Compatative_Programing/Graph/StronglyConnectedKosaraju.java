
/*

Strongly Connected Component:
    Strongly connected graph:
        - If we can reach from every point to every other point then the given graph is strongly connected graph.
    Strongly Connected component (SSC):
        - If we divided graph so that every sub-graph is strongly connected graph then they called strongly connected component.
        - Single node is always strongly connected graph.
        - After reversing all edges then also SSC behavior remain same. Reversing all edges called transpose of graph.
    Undirected graph:
        - SSC in undirected graph = Number of connected component.

Problem:

Input:
    {x,y} mean edge x-->y
    {{0,1}{1,2}{2,0}  {2,3}{3,4}  {4,5}{5,6}{6,4}  {4,7}{6,7}}

Output:
    4 Connected component
    0,1,2
    3
    4,5,6
    7

====================================================

Algorithm: Kosaraju Algorithm

    - Use transpose property. SSC component will not change even if we reversed edge.
    EG:
        1.    SSC1 --> SSC2 <-- SSC3
        2.    SSC1 <-- SSC2 --> SSC3      // Both have 3 component
    - count = 1
    - If we done DFS/BFS on first then we can go to SSC1 to SSC2. But not from SSC2 to SSC3, so count++;
    - But in 2 after reverse we cannot move from SSC1 to SSC2, so count++. and next we can visit SSC2 and SSC3 in one traverse.
    - count = 3.

    Algorithm:
        - DFS/BFS add all visited node in Stack/LinkList.
        - Reverse graph
        - Again DFS/BFS traverse by removing each node from stack.

==========================================================================
Time Complexity:
    - 3(V+E) // as traversing 3 times ie DFS-Reverse-DFS.
==========================================================================

*/

import java.util.*;

class StronglyConnectedKosaraju {

    private static void fillStackDFS(HashMap<Integer, ArrayList<Integer>> graph, int u,
                                    Stack<Integer> st, boolean[] visited) {
        // mark visited
        visited[u] = true;

        // visit adjacent node
        if(graph.containsKey(u)) {
            for(int i: graph.get(u)) {
                if(!visited[i]) {
                    fillStackDFS(graph, i, st, visited);
                }
            }
        }

        // push in stack
        st.push(u);
    }

    private static String popStackDFS(HashMap<Integer, ArrayList<Integer>> graph, int u,
                                    Stack<Integer> st, boolean[] visited) {
        // mark visited
        visited[u] = true;
        String component = "" + u;

        // visit adjacent node
        if(graph.containsKey(u)) {
            for(int i: graph.get(u)) {
                if(!visited[i]) {
                    component += popStackDFS(graph, i, st, visited);
                }
            }
        }

        return component;
    }

    private static HashMap<Integer, ArrayList<Integer>> getMap(int[][] points, boolean reverse) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        int x,y;

        // Add all points in hashmap
        for(int[] p: points) {

            // If reverse true then switch role p[0] and p[1]
            if(reverse) {
                x = p[1];
                y = p[0];
            } else {
                y = p[1];
                x = p[0];
            }

            if(hm.containsKey(x)) {
                hm.get(x).add(y);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(y);
                hm.put(x, arr);
            }
        }

        return hm;
    }

    private static int stronglyConnected(int V, int[][] points) {
        // First convert to graph
        HashMap<Integer, ArrayList<Integer>> graph = getMap(points, false);
        System.out.println("Graph: " + graph.toString());

        // reverse graph
        HashMap<Integer, ArrayList<Integer>> graphReverse = getMap(points, true);
        System.out.println("Graph Reverse: " + graphReverse.toString());

        // DFS: declare stack and visited array
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        // counter set
        int count = 0;

        // DFS
        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                // count++;
                fillStackDFS(graph, i, st, visited);
            }
        }

        // perform dfs on transpose
        Arrays.fill(visited, false);
        while(st.size()!=0) {
            int u = st.pop();
            if(!visited[u]) {
                count++;
                String component = popStackDFS(graphReverse, u, st, visited);
                System.out.println("Component " + count + ": " + component);
            }
        }

        return count;
    }

	public static void main(String[] args) {
		int points1[][] = new int[][]{{0,1},{1,2},{2,0},  {2,3},{3,4},  {4,5},{5,6},{6,4},  {4,7},{6,7}};
		System.out.println("Output: " + stronglyConnected(8, points1));

        System.out.println();

		int points2[][] = new int[][]{{0,1},{1,2},{2,0},  {2,3},{4,3},  {4,5},{5,6},{6,4},  {4,7},{6,7}};
		System.out.println("Output: " + stronglyConnected(8, points2));
	}
}