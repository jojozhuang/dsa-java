package johnny.datastructure.graph;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/*
 * A graph, implemented using an adjacency matrix.
 */
public class AdjMatrixGraph {
    private int MAX_VERTS = 0;
    private Vertex[] vertexList; // array of vertices
    private int[][] adjMatrix; // adjacency matrix
    private int nVerts; // current number of vertices
    private Stack<Vertex> stack;
    private Queue<Vertex> queue;

    public AdjMatrixGraph(int maxverts)
    {
        MAX_VERTS = maxverts; // maximum number of vertices
        vertexList = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        stack = new Stack<Vertex>();
        queue = new PriorityQueue<Vertex>();

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
        System.out.print(vertexList[index].label);
    }

    // dfs
    public void dfs() {
        vertexList[0].visited = true;
        displayVertex(0);
        stack.push(vertexList[0]);
        while (!stack.isEmpty()) {
            int index = getAdjUnvisitedVertex(stack.peek().index);
            if(index == -1) { // no unvisited neighbor
                stack.pop();
            } else {
                vertexList[index].visited = true;
                displayVertex(index);
                stack.push(vertexList[index]);
            }
        }

        // stack is empty, so we’re done 
        for (int i=0; i<nVerts; i++) {
            vertexList[i].visited = false;
        }
    }

    // bfs
    public void bfs() {
        vertexList[0].visited = true;
        displayVertex(0); 
        queue.add(vertexList[0]);
        while (!queue.isEmpty() ) {
            Vertex v1 = queue.poll();
            int v2;
            while ((v2=getAdjUnvisitedVertex(v1.index)) != -1) {
                vertexList[v2].visited = true;
                displayVertex(v2);
                queue.add(vertexList[v2]);
            }
        }

        // queue is empty, so we’re done 
        for (int i=0; i<nVerts; i++) {
            vertexList[i].visited = false;
        }
    }

    private int getAdjUnvisitedVertex(int index) {
        for(int i=0; i<nVerts; i++) {
            if(adjMatrix[index][i] == 1 && vertexList[i].visited == false) {
                return i;
            }
        }
        return -1;
    }
}
