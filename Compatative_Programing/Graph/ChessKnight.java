

/*
Chess Knight minimum movement

Find minimum movement for knight to move from A to B

===============================================================================
Algorithm:
    - we can convert vertex to graph of 8*8=64 vertex
    - knight starting point is root and destination


V {
    i, j;
}

parent[8][8]   store v.i-1 v.j-1

createGraph(source, i, j)
    // all point should be in range 0-7 then it is edge from ij-->
    // if destination is already covered then skip it
    // till all visited or destination
    i+1 j+2
    i+1 j-2
    i-1 j+2
    i-1 j-2
    i+2 j+1
    i+2 j-1
    i-2 j+1
    i-2 j-1
    parent[i][j] = 0

BFS(graph, source, destination)

*/


public class ChessKnight {
    public static void main(String[] args) {

    }
}
