package johnny.datastructure.graph.test;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.datastructure.graph.AdjMatrixGraph;

public class AdjMatrixGraphTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAdjMatrixGraph() {
        System.out.println("testAdjMatrixGraph");
        /*
        Vertex | A | B | C | D
        -------|---|---|---|---
        A      | 0 | 1 | 1 | 1
        B      | 1 | 0 | 0 | 1
        C      | 1 | 0 | 0 | 0
        D      | 1 | 1 | 0 | 0
        */
        AdjMatrixGraph amg = new AdjMatrixGraph(4);
        amg.addVertex("A");
        amg.addVertex("B");
        amg.addVertex("C");
        amg.addVertex("D");
        amg.addEdge(0, 1);
        amg.addEdge(0, 2);
        amg.addEdge(0, 3);
        amg.addEdge(1, 0);
        amg.addEdge(1, 3);
        amg.addEdge(2, 0);
        amg.addEdge(3, 0);
        amg.addEdge(3, 1);
        
        System.out.println(Arrays.toString(amg.getVertices()));
        System.out.println(Arrays.deepToString(amg.getAdjMatrix()));
    }
    
    @Test
    public void testDFS() {
        System.out.println("testDFS");
        /*
        Vertex | A | B | C | D | E
        -------|---|---|---|---|---
        A      | 0 | 1 | 0 | 1 | 0
        B      | 1 | 0 | 1 | 0 | 0
        C      | 0 | 1 | 0 | 0 | 0
        D      | 1 | 0 | 0 | 0 | 1
        E      | 0 | 0 | 0 | 1 | 0
        */
        AdjMatrixGraph amg = new AdjMatrixGraph(5);
        amg.addVertex("A");
        amg.addVertex("B");
        amg.addVertex("C");
        amg.addVertex("D");
        amg.addVertex("E");
        amg.addEdge(0, 1);  //AB
        amg.addEdge(1, 2);  //BC
        amg.addEdge(0, 3);  //AD
        amg.addEdge(3, 4);  //DE

        System.out.print("Visits: ");
        amg.dfs();  // Visits: ABCDE
        System.out.println();
    }
    
    @Test
    public void testBFS() {
        System.out.println("testBFS");
        /*
        Vertex | A | B | C | D | E
        -------|---|---|---|---|---
        A      | 0 | 1 | 0 | 1 | 0
        B      | 1 | 0 | 1 | 0 | 0
        C      | 0 | 1 | 0 | 0 | 0
        D      | 1 | 0 | 0 | 0 | 1
        E      | 0 | 0 | 0 | 1 | 0
        */
        AdjMatrixGraph amg = new AdjMatrixGraph(5);
        amg.addVertex("A");
        amg.addVertex("B");
        amg.addVertex("C");
        amg.addVertex("D");
        amg.addVertex("E");
        amg.addEdge(0, 1);  //AB
        amg.addEdge(1, 2);  //BC
        amg.addEdge(0, 3);  //AD
        amg.addEdge(3, 4);  //DE

        System.out.print("Visits: ");
        amg.bfs();  // Visits: ABDCE
        System.out.println();
    }

}
