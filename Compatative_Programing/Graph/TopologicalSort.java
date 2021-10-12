
/*
Problem: Print Topological Order

- Topological Ordering is only possible with directed acyclic graph.
- Topological sorting/ordering is linier ordering of its vertex
such that every directed edge uv for vertex u to v, u comes before v.
=====================================================================

There are two algorithm for this:
    1. Kahn (BFS)
    2. DFS
*/

import java.util.*;

class TopologicalSort {

    private static ArrayList<Integer> topologicalSort(int[][] points) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        for(int[] p: points) {
            // 0 -> 1
            if(hm.containsKey(p[0])) {
                hm.get(p[0]).add(p[1]);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(p[1]);
                hm.put(p[0], arr);
            }
        }


    }

	public static void main(String[] args) {
		int points[][] = new int[][]{{5,0}, {4,0}, {4,1}, {5,2}, {2,3}, {3,1}};
		System.out.println(topologicalSort(points).toString());
	}
}
