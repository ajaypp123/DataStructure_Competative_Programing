class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max=0;
        int[][]visited=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                max=Math.max(max,dfs(matrix,i,j,-1,visited));
            }
        }
        return max;
    }
    public int dfs(int[][]m,int i,int j,int prev,int[][]visited){
        if(i<0 || j<0 || i>=m.length || j>=m[0].length || m[i][j]==-1 || m[i][j]<=prev){
            return 0;
        }
        if(visited[i][j]!=0){
            return 1+visited[i][j];
        }
        int temp=m[i][j];
        int res=0;
        res=Math.max(res,dfs(m,i-1,j,temp,visited));
        res=Math.max(res,dfs(m,i+1,j,temp,visited));
        res=Math.max(res,dfs(m,i,j-1,temp,visited));
        res=Math.max(res,dfs(m,i,j+1,temp,visited));
        visited[i][j]=res;
        return 1+res;
    }
}