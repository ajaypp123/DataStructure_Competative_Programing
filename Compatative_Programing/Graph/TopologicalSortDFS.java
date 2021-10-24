
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

Time Complexity: O(V+E)

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

    private static boolean DFS(HashMap<Integer, ArrayList<Integer>> hm,
                            int[] vis, int u, Stack<Integer> st) {
        boolean isCycle = false;
        // pre: visit node
        vis[u] = 1;

        // in: visit all node v, such that u->v
        if(hm.containsKey(u)) {
            for(int v: hm.get(u)) {
                if(vis[v]==0) {
                    isCycle = DFS(hm, vis, v, st);
                    if(isCycle) {
                        System.out.print(u);
                        break;
                    }
                } else if(vis[v]==1){
                    // It has cycle as v is one of parent node which is already visited.
                    // 1-2-3-1  In DFS vis[1] is 1 and 1 is parent as well as chile of 3. so it has cycle.
                    System.out.print(v +""+ u); // print reverse as stack, and output is created in reverse order
                    return true;
                }
            }
        }

        // post: all child are visited so visit current
        st.push(u);
        // mark -1 as all children are safely parsed
        vis[u] = -1;
        return isCycle;
    }

    private static List<Integer> topologicalSort(int[][] points) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        HashSet<Integer> vertex = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        boolean isCycle = false;

        // Add all points in hashmap
        for(int[] p: points) {
            // 0 -> 1, for 0 complete 1
            vertex.add(p[0]);
            vertex.add(p[1]);
            if(hm.containsKey(p[0])) {
                hm.get(p[0]).add(p[1]);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(p[1]);
                hm.put(p[0], arr);
            }
        }

        // visited array
        // 0: unvisited 1: visited -1: visited and in stack
        int[] vis = new int[vertex.size()];

        System.out.println("Map: " + hm.toString());
        // visit all node
        for(int i=0; i<vis.length; i++) {
            if(vis[i]==0) {
                if(TopologicalSortDFS.DFS(hm, vis, i, st)) {
                    isCycle = true;
                    break;
                }
            }
        }

        // return empty if there is cycle
        // print reverse stack
        LinkedList<Integer> arr = new LinkedList<>();
        if(isCycle) {
            System.out.println();
            System.out.println("Cycle in graph printed above in reverse order");
        } else {
            while(st.size()!=0) {
                arr.addFirst(st.pop());
            }
        }

        return arr;
    }

	public static void main(String[] args) {
        // Without Cycle
		int points1[][] = new int[][]{{0,1}, {0,3},{1,2}, {2,3}, {4,3},{4,5},{4,6},{5,6}};
		System.out.println("Output: " + topologicalSort(points1).toString());

        // With Cycle
        // 4 - 5 - 6 -4
		int points2[][] = new int[][]{{0,1}, {0,3},{1,2}, {2,3}, {4,3},{4,5},{6, 4},{5,6}};
		System.out.println("Output: " + topologicalSort(points2).toString());
	}
}
