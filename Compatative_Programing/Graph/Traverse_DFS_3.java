
/*
Implement graph traverse BFS from given metrix
--------------------------------------
Complexity: (Eg: 1 - 2 - 3 - 4 - 5)
Time: O(V+E)
Space: O(V+V-1)=O(2V)    v:queue:v-1     v:vis:v
---------------------------------------

BFS
---
Stack

1. need stack and visted array
2. while count < vertex
        add first unvisted array
        call DFS(stack, vis)
            peek mark visted
            for all adj
                push first unvisted
                call DFS(st)
*/

import java.util.*;

public class Traverse_DFS_3 {

    private static void DFirstSearch(int[][] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(vis, false);

        // For every unvisited ele add into stack
        // usefull for disjoint set
        for(int i=0; i<vis.length; i++) {
            if(!vis[i]) {
                st.push(i);
                DFS(graph, st, vis);
            }
        }

    }

    private static void DFS(int[][] graph, Stack<Integer> st, boolean[] vis) {
        // visit top
        int ele = st.peek();
        System.out.println(ele);
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

        // int points[][] = new int[][]{{0,1}, {0,3}, {3,0}, {1,2}, {2,3}};
        // Convert points[] to Graph and then traverse

        DFirstSearch(graph);
	}
}
