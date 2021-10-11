
/*
3. Graph connected/unconnected component
    - DFS
    - BFS
    - Union Find (Only for undirected graph) (Not in this file)

Count and Print Number of component graph

==============================================

Algorithm:

    for(each v) {
        if(vis == false) {
            count++;
            DFS or BFS
        }
    }
*/

import java.util.*;

interface Search {
    public void Traverse(int[][] graph, int i, boolean[] vis, ArrayList<Integer> arr);
}

class DFS implements Search {

    public void Traverse(int[][] graph, int i, boolean[] vis, ArrayList<Integer> arr) {
        Stack<Integer> st = new Stack<>();
        st.push(i);

        DFSStack(graph, st, vis, arr);
    }

    private static void DFSStack(int[][] graph, Stack<Integer> st, boolean[] vis, ArrayList<Integer> arr) {
        int vertex = st.peek();
        arr.add(vertex);
        vis[vertex] = true;

        // for every unvisited node
        for(int i=0; i<vis.length; i++) {
            if(!vis[i] && graph[vertex][i]!=0) {
                st.push(i);
                DFSStack(graph, st, vis, arr);
            }
        }
        st.pop();
    }
}

class BFS implements Search {

    public void Traverse(int[][] graph, int i, boolean[] vis, ArrayList<Integer> arr) {
        // queue
        LinkedList<Integer> que = new LinkedList<>();
        que.addFirst(i);

        while(que.size() > 0) {
            int ver = que.getFirst();
            que.removeFirst();
            arr.add(ver);
            vis[ver] = true;

            // Add adj element
            for(int j=0; j<graph[0].length; j++) {
                if(graph[ver][j] != 0 && vis[j]==false) {
                    que.addLast(j);
                }
            }
        }
    }
}

class ConnectedGraph_3 {

    private static int countComponent(Search algo, int[][] graph) {
        // visited array
        int vertexCount = graph.length;
        boolean[] vis = new boolean[vertexCount];
        int countCom = 0;

        // for every unvisited node
        for(int i=0; i<vertexCount; i++) {
            if(!vis[i]) {
                ArrayList<Integer> arr = new ArrayList<>();
                countCom++;
                algo.Traverse(graph, i, vis, arr);
                System.out.println(arr.toString());
            }
        }
        return countCom;
    }

    public static void main(String[] args) {
        // 5 Connected component
        int[][] graph = new int[][]{
                                        {0, 1, 1, 0, 0},
                                        {1, 0, 0, 0, 0},
                                        {1, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 1},
                                        {0, 0, 0, 1, 0}
                                    };

        //int points[][] = new int[][]{{0,1}, {0,3}, {3,0}, {1,2}, {2,3}};
        // Convert points[] to Graph then find cycle
        // It need to get adjacent node and only done by BFS and DFS as directed graph
        Search s1 = new DFS();
        Search s2 = new BFS();
        System.out.println("Output: " + countComponent(s1, graph));
        System.out.println("Output: " + countComponent(s2, graph));
    }
}