package johnny.datastructure.graph;

import java.util.LinkedList;

/*
 * A graph, implemented using an adjacency list.
 */
public class AdjListGraphInteger {
    private LinkedList<Integer>[] adjList; // array of adjacency list

    @SuppressWarnings("unchecked")
    public AdjListGraphInteger(int size)
    {
        adjList = new LinkedList[size];

        // initialize array
        for (int i=0; i< adjList.length; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int start, int end) {
        adjList[start].add(end);
        adjList[end].add(start);
    }

    public LinkedList<Integer>[] getAdjList() {
        return adjList;
    }

}
