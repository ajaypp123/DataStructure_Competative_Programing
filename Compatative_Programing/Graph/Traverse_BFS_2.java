
/*
Implement graph traverse BFS from given metrix

--------------------------------------
Complexity: (Eg: 1 - 2 - 3 - 4 - 5)
Time: O(V+E)
Space: O(V+V-1)=O(2V)    v:queue:v-1     v:vis:v
---------------------------------------

BFS
---
Queue

1. while vis count != vertex
    if q empty travese to find first unvisted num, add in q and break
    a. pop top
    b. mark visited, c++
    b. add all adj in queue

Note: graph can be disconnected.
*/

import java.util.*;

public class Traverse_BFS_2 {

    public static void BFirstSearch(int[][] graph) {
        // need queue and visited array arr
        boolean[] vis = new boolean[graph.length];
        LinkedList<Integer> que = new LinkedList<>();
        Arrays.fill(vis, false);
        int count = 0;

        // Add all visited element
        HashSet<Integer> hs = new HashSet<>();

        // visit queue till count < vertex
        while (count <= graph.length) {

            // If queue is empty then find next unvisited element
            // It help if there is disconnected graphs
            if(que.size()==0) {
                // Find first unvisited node
                for(int i=0; i<vis.length; i++) {
                    if(!vis[i]) {
                        que.addLast(i);
                        break;
                    }
                }
            }

            // pop one ele mark vis
            int ele = que.getFirst();
            que.removeFirst();
            vis[ele] = true;
            hs.add(ele);
            count++;

            // add all unvisited adj element in queue
            for(int i=0; i< graph.length; i++) {
                if(!vis[i] && graph[ele][i]!=0) {
                    que.addLast(i);
                    System.out.println(ele + " --> "+ i);
                }
            }
        }

        // print hs
        for(int i:hs) {
            System.out.print(i);
        }
        System.out.println();
    }

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
									{ 2, 0, 3, 8, 5 },
									{ 0, 3, 0, 0, 7 },
									{ 6, 8, 0, 0, 9 },
									{ 0, 5, 7, 9, 0 } };

        // int points[][] = new int[][]{{0,1}, {0,3}, {3,0}, {1,2}, {2,3}};
        // Convert points[] to Graph and then traverse

        BFirstSearch(graph);
	}
}
