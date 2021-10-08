
import java.util.*;

public class DFS {
	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
									{ 2, 0, 3, 8, 5 },
									{ 0, 3, 0, 0, 7 },
									{ 6, 8, 0, 0, 9 },
									{ 0, 5, 7, 9, 0 } };

        printDFS(graph);
	}

    private static void printDFS(int[][] graph) {
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[graph.length];

        st.push(0);
        vis[0] = 1;

        Show(st, graph, vis);
    }

    private static void Show(Stack<Integer> st, int[][] g, int[] vis) {
        if(st.size() == 0) {
            return;
        }
        int v = st.peek();
        System.out.println(v);

        for(int i=0; i<g[v].length; i++) {
            if(g[v][i]!=0 && vis[i]!=1 && v!=i) {
                st.push(i);
                vis[i] = 1;
                Show(st, g, vis);
            }
        }
        st.pop();
    }
}
