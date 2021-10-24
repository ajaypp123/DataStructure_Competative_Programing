
/*
Problem: Print all possible Topological Order

- Topological Ordering is only possible with directed acyclic graph.
- Topological sorting/ordering is linier ordering of its vertex
such that every directed edge uv for vertex u to v, u comes before v.

*/

import java.util.*;

public class AllTopologicalSort {

	private static HashMap<Integer, ArrayList<Integer>> getMap(int V, int[][] points) {
        // Calculate in-degree and converted to hashMap
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

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
		System.out.println("Map: " + hm.toString());
		return hm;
	}

	private static void getOrder(HashMap<Integer, ArrayList<Integer>> hm,
								int v, int[] indegree, boolean[] visited) {
		// pop first v
		visited[v] = true;

		// for each adj reduce indegree
		for(int adj: hm.get(v)) {
			if(!visited[adj] && indegree[adj]!=0) {
				indegree[adj]--;
				if(indegree[adj]==0) {
					getOrder(hm, adj, indegree, visited);
				}
			}
		}

	}

    private static List<Integer> topologicalSort(int V, int[][] points) {
        // Calculate in-degree and converted to hashMap
        HashMap<Integer, ArrayList<Integer>> hm = getMap(V, points);
		int[] indegree = new int[V];

        // Calculate in-degree
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

		boolean[] visited = new boolean[indegree.length];
		while(que.size()!=0) {
			getOrder(hm, que.removeFirst(), indegree, visited);
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
		System.out.println("Output: " + topologicalSort(7, points1).toString());
	}
}
