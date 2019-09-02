package johnny.dsa.spanningtree;

import java.util.Stack;

public class MinimumSpanningTree {
    private int MAX_VERTS = 0;
    private Vertex[] vertexList; // array of vertices
    private int[][] adjMatrix; // adjacency matrix
    private int nVerts; // current number of vertices

    public MinimumSpanningTree(int maxverts)
    {
        MAX_VERTS = maxverts; // maximum number of vertices
        vertexList = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        // initialize matrix
        for(int i=0; i<MAX_VERTS; i++) {
            for(int j=0; j<MAX_VERTS; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    public void addVertex(String label) {
        int index = nVerts++;
        vertexList[index] = new Vertex(index, label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public Vertex[] getVertices() {
        return vertexList;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void displayVertex(int index) {
        System.out.print(vertexList[index].name);
    }

    // mst, similar with dfs
    private Stack<Vertex> stack = new Stack<Vertex>();
    public void mst() {
        vertexList[0].visited = true; // different start vertex leads to different mst.
        stack.push(vertexList[0]);
        while (!stack.isEmpty()) {
            int currentVertex = stack.peek().index;
            int index = getAdjUnvisitedVertex(currentVertex);
            if (index == -1) { // no unvisited neighbor
                stack.pop();
            } else {
                vertexList[index].visited = true;
                stack.push(vertexList[index]);
                displayVertex(currentVertex);
                displayVertex(index);
                System.out.print(" ");
            }
        }

        // reset vertices
        for (int i=0; i<nVerts; i++) {
            vertexList[i].visited = false;
        }
    }

    private int getAdjUnvisitedVertex(int index) {
        for (int i=0; i<nVerts; i++) {
            if (adjMatrix[index][i] == 1 && vertexList[i].visited == false) {
                return i;
            }
        }
        return -1;
    }
}
