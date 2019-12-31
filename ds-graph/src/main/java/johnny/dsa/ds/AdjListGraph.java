package johnny.dsa.ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * A graph, implemented using an adjacency list.
 */
public class AdjListGraph {
    private LinkedList<Vertex>[] vertexList; // list of adjacency vertex
    private Vertex[] vertices;               // array of vertices
    private int size;                        // current number of vertices
    
    public AdjListGraph(int capacity)
    {
        vertexList = new LinkedList[capacity];
        vertices = new Vertex[capacity];
        size = 0;

        // initialize array
        for (int i = 0; i< vertexList.length; i++) {
            vertexList[i] = new LinkedList<Vertex>();
        }
    }
    
    public void addVertex(String name) {
        int index = size++;
        vertices[index] = new Vertex(index, name);
    }

    public void addEdge(int start, int end) {
        vertexList[start].add(vertices[end]);
        vertexList[end].add(vertices[start]);
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
        for (int i = 0; i < vertexList[index].size(); i++) {
            if (vertexList[index].get(i).visited == false) {
                return vertexList[index].get(i).index;
            }
        }
        return -1;
    }

    public Vertex[] getVertices() {
        return vertices;
    }
    
    public LinkedList<Vertex>[] getVertexList() {
        return vertexList;
    }
}
