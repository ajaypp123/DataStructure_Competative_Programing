class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //Time and complexity = O(n * m) where n is the number of rows and 
        // m is the number of cols
        
        Queue<int[]> queue = new LinkedList<>();
        // {row, col, depth so far}
        queue.add(new int[]{0, 0, 0});
        int nRow = grid.length, nCol = grid[0].length;
        boolean[][] visited = new boolean[nRow][nCol];
        //{row, col}
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, 1}, {-1, -1},
                              {1, 1}, {1, -1}};
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            //error checking
            if(top[0] >= nRow || top[0] < 0 || top[1] >= nCol || top[1] < 0
              || visited[top[0]][top[1]] || grid[top[0]][top[1]] == 1) continue;
            visited[top[0]][top[1]] = true;
            // if we reach the ending
            if(top[0] == nRow -1 && top[1] == nCol - 1){
                return grid[top[0]][top[1]] == 1 ? -1 : top[2] + 1;
            }
            //adding all 8 directions
            for(int[] direction : directions){
                queue.add(new int[]{top[0] + direction[0], top[1] + direction[1],
                                   top[2] + 1});
            }
            
        }
        return -1;
    }
}