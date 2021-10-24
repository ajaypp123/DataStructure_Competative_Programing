
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

    Map: {0=[1, 3], 1=[2], 2=[3], 4=[3, 5, 6], 5=[6]}
    Output: [3, 2, 1, 0, 6, 5, 4]
    Mean first complete 3 then 2 then 1 then ....
=====================================================================

Time Complexity: O(V+E)

=====================================================================

There are two algorithm for this:
    1. Kahn (BFS)
    2. DFS
=====================================================================

BFS Algorithm:
    - Simply those node which has in-degree 0 can be completed last.
    - When in-degree of 0 work taken out then there adj node in-degree reduced by 1.
    - recursively we can get list and print in reverse.

    1. Converts points to map
    2. Calculate in-degree for each node
    3. Add all in-degree 0 node in queue
    4. create count=0 to track how many visited
    4. while queue empty
        - pop one node and count++
        - reduce in-degree of adj node by 1
            - if indegree became 0 then add node in queue
    5. If count == length
        - then all node visited and work completed
        - else there is cycle in requirement graph.

*/

import java.util.*;

public class TopologicalSortBFS {

    private static List<Integer> topologicalSort(int[][] points) {
        // Calculate in-degree and converted to hashMap
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        HashSet<Integer> vertex = new HashSet<>();

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

        System.out.println("Map: " + hm.toString());

        // Calculate in-degree
        int[] indegree = new int[vertex.size()];
        for(int i: hm.keySet()) {
            for(int j: hm.get(i)) {
                ++indegree[j];
            }
        }

        // Add all node in queue having indegree 0
        LinkedList<Integer> que = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        int count=indegree.length;
        for(int i=0; i<indegree.length; i++) {
            if(indegree[i]==0) {
                que.add(i);
            }
        }

        // visit all node having indegree 0
        while(que.size()!=0) {
            // pop from queue
            int v = que.getFirst();
            que.removeFirst();
            res.addLast(v);
            count--;

            // Decrease indegree of adj and then add in queue if in-degree 0
            if(hm.containsKey(v)) {
                for(int i: hm.get(v)) {
                    indegree[i]--;
                    if(indegree[i]==0) {
                        que.addLast(i);
                    }
                }
            }

        }

        if(count!=0) {
            System.out.println("Cycle in graph; This method can not print but only detect.");
            res.clear();
            return res;
        }
        return res;
    }

	public static void main(String[] args) {
        // Without Cycle
		int points1[][] = new int[][]{{0,1}, {0,3},{1,2}, {2,3}, {4,3},{4,5},{4,6},{5,6}};
		System.out.println("Output: " + topologicalSort(points1).toString());

        // With Cycle
        // 4 - 5 - 6 -4
		int points2[][] = new int[][]{{0,1},{0,3},{1,2},{2,3},{4,3},{4,5},{6, 4},{5,6}};
		System.out.println("Output: " + topologicalSort(points2).toString());
	}
}
