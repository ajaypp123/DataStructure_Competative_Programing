
/*
Hamiltonian:
    - Visit all vertex exactly once

Hamiltonian Path:
    - Visit all vertex exactly once

Hamiltonian Cycle:
    - Visit all vertex exactly once and last edge connecting source and vertex
*/

public class HamiltonianPathCycle {

    private static void hamiltonian(int[][] graph, int source) {
        // Perform DFS and travel each path
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] { { 0, 1, 0, 1, 0, 0, 0 }, { 1, 0, 1, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0, 0, 0 },
                { 1, 0, 1, 0, 1, 0, 0 }, { 0, 0, 0, 1, 0, 1, 1 }, { 0, 0, 1, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1, 1, 0 } };

        hamiltonian(graph, 0);
    }
}
