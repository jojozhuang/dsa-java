package johnny.datastructure.graph.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.datastructure.graph.DirectedGraph;

public class DirectedGraphTest {

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
    public void testTopo() {
        System.out.println("testTopo");
        /*
        Vertex | A | B | C | D | E | F | G | H
        -------|---|---|---|---|---|---|---|---
        A      | 0 | 0 | 0 | 1 | 1 | 0 | 0 | 0 
        B      | 0 | 0 | 0 | 0 | 1 | 0 | 0 | 0 
        C      | 0 | 0 | 0 | 0 | 0 | 1 | 0 | 0 
        D      | 0 | 0 | 0 | 0 | 0 | 0 | 1 | 0 
        E      | 0 | 0 | 0 | 0 | 0 | 0 | 1 | 0 
        F      | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 
        G      | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 
        H      | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 
        */
        DirectedGraph dg = new DirectedGraph(8);
        dg.addVertex("A");
        dg.addVertex("B");
        dg.addVertex("C");
        dg.addVertex("D");
        dg.addVertex("E");
        dg.addVertex("F");
        dg.addVertex("G");
        dg.addVertex("H");
        dg.addEdge(0, 3);  //AD
        dg.addEdge(0, 4);  //AE
        dg.addEdge(1, 4);  //BE
        dg.addEdge(2, 5);  //CF
        dg.addEdge(3, 6);  //DG
        dg.addEdge(4, 6);  //EG
        dg.addEdge(5, 7);  //FH
        dg.addEdge(6, 7);  //GH

        System.out.print("Topologically sorted order: ");
        dg.topo();  //Topologically sorted order: BAEDGCFH
        System.out.println();
    }

}
