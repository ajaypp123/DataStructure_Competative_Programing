
/*
Problem: Print Topological Order

- Topological Ordering is only possible with directed acyclic graph.
- Topological sorting/ordering is linier ordering of its vertex
such that every directed edge uv for vertex u to v, u comes before v.

Problem Statement: (When to use)
    - Suppose there is dependency in work like u->v, where u must
    complete before v.
    - Suppose there are files with dependency like {0,1} mean file 1 must
    be completed before 0. Find order so that all files are completed.
    // Here 0, 1 mean 0 depend on 1.
    {{0,1}, {0,3},{1,2}, {2,3}, {4,3},{4,5},{4,6},{5,6}}

    Output: 3 2 1 0 6 5 4
    Mean first complete 3 then 2 then 1 then ....

=====================================================================

There are two algorithm for this:
    1. Kahn (BFS)
    2. DFS
=====================================================================

DFS Algorithm:
    - Simply, In tree all children must be visited before parent.
    - It is like postorder

    // post order: first complete child work then parent work
    fun(u, st, vis) {
        // pre
        vis[u] = true

        // call stack
        for(all unvisited v,  u->v) {
            fun(u, st, vis)
        }

        // post: all dependency completed mean complete current one
        st.push(u);

    }

*/

import java.util.*;

class TopologicalSortDFS {

    private static void DFS(HashMap<Integer, ArrayList<Integer>> hm,
                            boolean[] vis, int u, Stack<Integer> st) {
        // pre: visit node
        vis[u] = true;

        // in: visit all node
        for(int v=0; v<hm.size(); v++) {
            if(!vis[v]) {
                DFS(hm, vis, v, st);
            }
        }

        // post: all child are visited so visit current
        st.push(u);
    }

    private static ArrayList<Integer> topologicalSort(int[][] points) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[hm.size()];

        // Add all points in hashmap
        for(int[] p: points) {
            // 0 -> 1, for 0 complete 1
            if(hm.containsKey(p[0])) {
                hm.get(p[0]).add(p[1]);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(p[1]);
                hm.put(p[0], arr);
            }
        }

        // visit all node
        for(int i=0; i<hm.size(); i++) {
            if(!vis[i]) {
                DFS(hm, vis, i, st);
            }
        }

        // print reverse stack
        ArrayList<Integer> arr = new ArrayList<>();
        while(st.size()!=0) {
            arr.add(st.pop());
        }

        return arr;
    }

	public static void main(String[] args) {
		int points[][] = new int[][]{{0,1}, {0,3},{1,2}, {2,3}, {4,3},{4,5},{4,6},{5,6}};
		System.out.println(topologicalSort(points).toString());
	}
}
