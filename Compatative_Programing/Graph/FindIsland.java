
/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

// perform dfs and mark visited
for i
    for j
        if ij not visited
            DFS(ij visited graph)
*/

public class FindIsland {

    private static int DFS(char[][] graph, boolean[][] visited, int i, int j, int size) {
        // If visited or out of bound then return
        if(i>=visited.length || j>=visited[0].length || i<0 || j<0 || visited[i][j] || graph[i][j] == '0') {
            return 0;
        }
        visited[i][j] = true;

        // move four side
        size += DFS(graph, visited, i+1, j, size);
        size += DFS(graph, visited, i-1, j, size);
        size += DFS(graph, visited, i, j+1, size);
        size += DFS(graph, visited, i, j-1, size);
        return size + 1;
    }

    private static int findISlandCount(char[][] graph) {
        // convert to HashMap
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        int count = 0;
        int size_island = 0;

        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].length; j++) {
                if(visited[i][j] == false && graph[i][j] == '1') {
                    count++;
                    size_island = 0;
                    size_island = DFS(graph, visited, i, j, size_island);
                    System.out.println("Found island of size: " + size_island);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] graph = new char[][] {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        int c = findISlandCount(graph);
        System.out.println(c);
    }
}
