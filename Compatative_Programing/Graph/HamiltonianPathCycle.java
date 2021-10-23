
/*
Hamiltonian:
    - Visit all vertex exactly once

Hamiltonian Path:
    - Visit all vertex exactly once

Hamiltonian Cycle:
    - Visit all vertex exactly once and last edge connecting source and vertex
*/

import java.util.*;

public class HamiltonianPathCycle {

    public static void DFS(int[][] graph, int source, int[] visited, LinkedList<Integer> que, List<LinkedList<Integer>> result) {

        visited[source]=1;
        que.addLast(source);

        // check if all visited
        if(que.size() == graph.length) {
            LinkedList<Integer> clone = new LinkedList<>(que);
            result.add(clone);

            // If there is edge from last visited to source then it is cycle
            if(graph[source][0] == 1) {
                System.out.println("Cycle: " + clone.toString());
            }
        }

        // visit current node
        for(int i=0; i<graph.length; i++) {
            // If edge exist and adj is unvisited
            if(graph[source][i]==1 && visited[i]==0) {
                DFS(graph, i, visited, que, result);
            }
        }

        visited[source]=0;
        que.removeLast();
    }

    private static List<LinkedList<Integer>> hamiltonian(int[][] graph, int source) {
        // Perform DFS and travel each path
        int[] visited = new int[graph.length];
        LinkedList<Integer> que = new LinkedList<>();
        List<LinkedList<Integer>> result = new ArrayList<>();

        //visited[source] = 1;
        //que.addLast(source);
        DFS(graph, source, visited, que, result);
        return result;
    }

    public static void main(String[] args) {
        /*
                        new Edge(0, 1), new Edge(0, 2), new Edge(0, 3),
                new Edge(1, 2), new Edge(1, 3), new Edge(2, 3)
        */
        int[][] graph = new int[][] {
            {0,1,1,1},
            {1,0,1,1},
            {1,1,0,1},
            {1,1,1,0},
        };

        List<LinkedList<Integer>> list = hamiltonian(graph, 0);
        for(LinkedList<Integer> li: list) System.out.println(li.toString());
    }
}
