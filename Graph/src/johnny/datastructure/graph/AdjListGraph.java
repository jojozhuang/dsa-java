package johnny.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * A graph, implemented using an adjacency list.
 */
public class AdjListGraph {
    private LinkedList<Vertex>[] adjList; // array of adjacency list
    private Vertex[] vertexList; // maintains the vertex list

    @SuppressWarnings("unchecked")
    public AdjListGraph(String[] verts)
    {
        adjList = new LinkedList[verts.length];
        vertexList = new Vertex[verts.length];

        // initialize array
        for (int i=0; i< adjList.length; i++) {
            adjList[i] = new LinkedList<Vertex>();
            vertexList[i] = new Vertex(i, verts[i]);
        }
    }

    public void addEdge(int start, int end) {
        adjList[start].add(vertexList[end]);
        adjList[end].add(vertexList[start]);
    }

    public LinkedList<Vertex>[] getAdjList() {
        return adjList;
    }

    public void displayVertex(int index) {
        System.out.print(vertexList[index].name);
    }

    // dfs
    private Stack<Vertex> stack = new Stack<Vertex>();
    public void dfs() {
        vertexList[0].visited = true;
        displayVertex(0);
        stack.push(vertexList[0]);
        while (!stack.isEmpty()) {
            int index = getAdjUnvisitedVertex(stack.peek().index);
            if (index == -1) { // no unvisited neighbor
                stack.pop();
            } else {
                vertexList[index].visited = true;
                displayVertex(index);
                stack.push(vertexList[index]);
            }
        }

        for (Vertex vertex : vertexList) {
            vertex.visited = false;
        }
    }

    // bfs
    private Queue<Vertex> queue = new LinkedList<Vertex>();
    public void bfs() {
        vertexList[0].visited = true;
        displayVertex(0); 
        queue.add(vertexList[0]);
        while (!queue.isEmpty()) {
            Vertex v1 = queue.poll();
            int v2;
            while ((v2=getAdjUnvisitedVertex(v1.index)) != -1) {
                vertexList[v2].visited = true;
                displayVertex(v2);
                queue.add(vertexList[v2]);
            }
        }

        for (Vertex vertex : vertexList) {
            vertex.visited = false;
        }
    }

    private int getAdjUnvisitedVertex(int index) {
        for (int i=0; i<adjList[index].size(); i++) {
            if (adjList[index].get(i).visited == false) {
                return adjList[index].get(i).index;
            }
        }
        return -1;
    }
}
