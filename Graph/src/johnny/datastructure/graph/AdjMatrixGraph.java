package johnny.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import johnny.datastructure.common.Vertex;

/*
 * A graph, implemented using an adjacency matrix.
 */
public class AdjMatrixGraph {
    private int[][] matrix;    // adjacency matrix
    private Vertex[] vertices; // array of vertices
    private int size;          // current number of vertices

    public AdjMatrixGraph(int capacity)
    {
        matrix = new int[capacity][capacity];
        vertices = new Vertex[capacity];
        size = 0;

        // initialize matrix
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public void addVertex(String name) {
        int index = size++;
        vertices[index] = new Vertex(index, name);
    }

    public void addEdge(int start, int end) {
        matrix[start][end] = 1;
        matrix[end][start] = 1; 
    }

    // dfs
    private Stack<Vertex> stack = new Stack<Vertex>();
    public String[] dfs() {
        String[] res = new String[size];
        vertices[0].visited = true;
        int idx = 0;
        res[idx++] = vertices[0].name;
        stack.push(vertices[0]);
        while (!stack.isEmpty()) {
            int index = getUnvisitedVertex(stack.peek().index);
            if (index == -1) { // no unvisited neighbor
                stack.pop();
            } else {
                vertices[index].visited = true;
                res[idx++] = vertices[index].name;
                stack.push(vertices[index]);
            }
        }

        // reset vertices
        for (Vertex vertex : vertices) {
            vertex.visited = false;
        }
        
        return res;
    }

    // bfs
    private Queue<Vertex> queue = new LinkedList<Vertex>();
    public String[] bfs() {
        String[] res = new String[size];
        vertices[0].visited = true;
        int idx = 0;
        res[idx++] = vertices[0].name;
        queue.add(vertices[0]);
        while (!queue.isEmpty() ) {
            Vertex vertex = queue.poll();
            int nextIdx = getUnvisitedVertex(vertex.index);
            while (nextIdx != -1) {
                vertices[nextIdx].visited = true;
                res[idx++] = vertices[nextIdx].name;
                queue.add(vertices[nextIdx]);
                nextIdx = getUnvisitedVertex(vertex.index);
            }
        }

        // reset vertices
        for (Vertex vertex : vertices) {
            vertex.visited = false;
        }
        
        return res;
    }

    private int getUnvisitedVertex(int index) {
        for (int i = 0; i < size; i++) {
            if (matrix[index][i] == 1 && vertices[i].visited == false) {
                return i;
            }
        }
        return -1;
    }
    

    public Vertex[] getVertices() {
        return vertices;
    }

    public int[][] getAdjMatrix() {
        return matrix;
    }
}
