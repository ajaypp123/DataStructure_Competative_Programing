class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        
        for(int i=0; i<graph.length; i++) {
            if(color[i] == 0) {
                boolean res = DFS(graph, i, 1, color);
            
                if(!res) {
                    return res;
                }
            }
        }
        return true;
    }
    
    private boolean DFS(int[][] graph, int v, int c, int[] color) {
        color[v] = c;
        
        for(int adj: graph[v]) {
            if(color[v] == color[adj]) {
                return false;
            }
            if(color[adj] == 0) {
                boolean res = DFS(graph, adj, (color[v]%2)+1, color);
                if(!res) {
                    return res;
                }
            }
        }
        
        return true;
    }
}