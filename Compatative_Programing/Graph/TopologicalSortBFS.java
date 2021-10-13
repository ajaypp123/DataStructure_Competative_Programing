
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
*/

public class TopologicalSortBFS {
	public static void main(String[] args) {
		int points[][] = new int[][]{{0,1}, {0,3},{1,2}, {2,3}, {4,3},{4,5},{4,6},{5,6}};
		//System.out.println(topologicalSort(points).toString());
	}
}
