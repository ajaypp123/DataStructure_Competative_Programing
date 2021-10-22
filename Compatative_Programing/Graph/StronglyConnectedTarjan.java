
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


Four Type of edges:
    Suppose tree
            1
        2   3   4
    5   6   7   8   9

    1. Tree Edge:
        - Edge between parent to child. Eg: 1-->2
        - It can be found by adj node.

    2. Forward Edge:
        - Edge between indirect parent to child. Eg: 1-->5. // here 3 is in middle.
        - It is also Tree edge.

    3. Backward Edge:
        - Edge from child to parent. Eg: 5-->1
        - It can be found by DFS, if element in stack and already visited then this is forward edge.

    4. Cross Edge: Edge between sibling.
        - Eg: 6-->8
        - In DFS if adj element was already visited and removed from stack then it is cross edge.


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
{0=[0, 1, 2], 3=[3], 4=[4, 5, 6], 7=[7]}
====================================================

Algorithm: Tarjan Algorithm:

    - This algorithm is used to find strongly connected component in graph.
    - We can keep track of node visited and then find SSC.

Step:

    DFS()
        visit st.peek = top
        update arrival time and low time for top

        for each adj of top
            if adj is not visited
                // forward or tree edge
                st.push(adj)
                DFS()
                low[top] = min(low[adj], low[top])

            else if adj visited and in stack
                // backward edge
                low[top] = low[adj]

            else
                // cross edge skip it
                continue;

        // visited all adj of top now pop it
        st.pop()
        visited[poped element] = -1



    findSSC(low[])
        for(i=0 to len)
            // if low[i] == i : it is root add key in map
            hm.put(i, arraylist)
        for(i=0 to len)
            hm.get(low[i]).add(i)

==========================================================================
Time Complexity:
    - O(V+E) // DFS
==========================================================================

Tarjan's vs Kosaraju's Algorithm:
    -
*/

import java.util.*;

class StronglyConnectedTarjan {

    private static List<List<Integer>> getMap(int V, int[][] points) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<V; i++) {
            List<Integer> li = new ArrayList<>();
            list.add(li);
        }

        for(int[] p: points) {
            int x = p[0];
            int y = p[1];
            // x -> y
            list.get(x).add(y);
        }
        return list;
    }

    private static int DFS(List<List<Integer>> map, Stack<Integer> st,
                            int[] discover, int[] low, int[] visited, int timer) {
        // visit v
        int top = st.peek();
        visited[top] = 1;
        discover[top] = timer;
        low[top] = timer;

        // add all adj node
        for(int adj: map.get(top)) {
            // if adj is not visited yet
            if(visited[adj] == 0) {
                st.push(adj);
                DFS(map, st, discover, low, visited, ++timer);
                low[top] = Math.min(low[top], low[adj]);

            } else if(visited[adj] == 1) {
                // visited and in stack, found back edge ie adj --> top --> adj
                low[top] = low[adj];
            } else {
                // it is cross edge, and adj is already part of strongly connected component
                // skip it
                continue;
            }
        }

        // all adj are visited, now we can remove it
        visited[top] = -1;
        st.pop();
        return timer;
    }

    private static int stronglyConnected(int V, int[][] points) {
        // perform DFS for that get map
        List<List<Integer>> map = getMap(V, points);
        // Stack for DFS
        Stack<Integer> st = new Stack<>();
        // track visited, low arrival and arrival/discover
        int[] discover = new int[V];
        int[] low = new int[V];
        int[] visited = new int[V];
        Arrays.fill(low, Integer.MAX_VALUE);

        // Add first element to stack
        int t = 0;
        for(int i=0; i<V; i++) {
            if(visited[i] == 0) {
                st.push(i);
                t = DFS(map, st, discover, low, visited, t);
            }
        }

        // low have root of all connected component
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for(int i=0; i<V; i++) {
            if(hm.containsKey(low[i])) {
                hm.get(low[i]).add(i);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                hm.put(low[i], arr);
            }
        }
        System.out.println("Map: " + hm.toString());
        return hm.size();
    }

	public static void main(String[] args) {
        /*
            Map: {0=[0, 1, 2], 3=[3], 4=[4, 5, 6], 7=[7]}
            Output: 4

            Map: {0=[0, 1, 2], 1=[4, 5, 6], 3=[3], 4=[7]}
            Output: 4
        */
		int points1[][] = new int[][]{{0,1},{1,2},{2,0},  {2,3},{3,4},  {4,5},{5,6},{6,4},  {4,7},{6,7}};
		System.out.println("Output: " + stronglyConnected(8, points1));

        System.out.println();

        int points2[][] = new int[][]{{0,1},{1,2},{2,0},  {2,3},{4,3},  {4,5},{5,6},{6,4},  {4,7},{6,7}};
		System.out.println("Output: " + stronglyConnected(8, points2));
	}
}
