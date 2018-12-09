package johnny.dsa.graph.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import johnny.dsa.graph.AdjMatrixGraph;

import java.util.Arrays;

public class AdjMatrixGraphTest {

    @Test
    public void testAdjMatrixGraph() {
        System.out.println("testAdjMatrixGraph");
        /*
        Vertex | A | B | C | D | E
        -------|---|---|---|---|---
        A      | 0 | 1 | 0 | 0 | 1
        B      | 1 | 0 | 1 | 1 | 1
        C      | 0 | 1 | 0 | 1 | 0
        D      | 0 | 1 | 1 | 0 | 1
        E      | 1 | 1 | 0 | 1 | 0
        */
        AdjMatrixGraph amg = createMatrixGraph();
        // print [A, B, C, D, E]
        System.out.print("Vertices: ");
        System.out.println(Arrays.toString(amg.getVertices()));
        // print [[0, 1, 0, 0, 1], [1, 0, 1, 1, 1], [0, 1, 0, 1, 0], [0, 1, 1, 0, 1], [1, 1, 0, 1, 0]]
        System.out.print("Matrix: ");
        System.out.println(Arrays.deepToString(amg.getAdjMatrix()));
    }
    
    @Test
    public void testDFS() {
        System.out.println("testDFS");
        /*
        Vertex | A | B | C | D | E
        -------|---|---|---|---|---
        A      | 0 | 1 | 0 | 0 | 1
        B      | 1 | 0 | 1 | 1 | 1
        C      | 0 | 1 | 0 | 1 | 0
        D      | 0 | 1 | 1 | 0 | 1
        E      | 1 | 1 | 0 | 1 | 0
        */
        AdjMatrixGraph amg = createMatrixGraph();
        String[] result = amg.dfs();
        // print Visits: [A, B, C, D, E]
        System.out.print("Visits: ");
        System.out.println(Arrays.toString(result));
        assertArrayEquals(new String[] {"A","B","C","D","E"}, result);
    }
    
    @Test
    public void testBFS() {
        System.out.println("testBFS");
        /*
        Vertex | A | B | C | D | E
        -------|---|---|---|---|---
        A      | 0 | 1 | 0 | 0 | 1
        B      | 1 | 0 | 1 | 1 | 1
        C      | 0 | 1 | 0 | 1 | 0
        D      | 0 | 1 | 1 | 0 | 1
        E      | 1 | 1 | 0 | 1 | 0
        */
        AdjMatrixGraph amg = createMatrixGraph();
        String[] result = amg.bfs();
        // print Visits: [A, B, E, C, D]
        System.out.print("Visits: ");
        System.out.println(Arrays.toString(result));
        assertArrayEquals(new String[] {"A","B","E","C","D"}, result);
    }
    
    private AdjMatrixGraph createMatrixGraph() {
        AdjMatrixGraph amg = new AdjMatrixGraph(5);
        amg.addVertex("A");
        amg.addVertex("B");
        amg.addVertex("C");
        amg.addVertex("D");
        amg.addVertex("E");
        amg.addEdge(0, 1);  //AB
        amg.addEdge(0, 4);  //AE
        amg.addEdge(1, 2);  //BC
        amg.addEdge(1, 3);  //BD
        amg.addEdge(1, 4);  //BE
        amg.addEdge(2, 3);  //CD
        amg.addEdge(3, 4);  //DE
        return amg;
    }
}
