package johnny.dsa.graph.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.common.Vertex;
import johnny.dsa.graph.AdjListGraph;

public class AdjListGraphTest {

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
    public void testAdjListGraph() {
        System.out.println("testAdjListGraph");
        /*
        A: B->E
        B: A->C->D->E
        C: B->D
        D: B->C->E
        E: A->B->D
        */
        AdjListGraph alg = createListGraph();
        // print [A, B, C, D, E]
        System.out.print("Vertices: ");
        System.out.println(Arrays.toString(alg.getVertices()));
        /*
        // print
        Adjacency list of vertex 0: head->B->E
        Adjacency list of vertex 1: head->A->C->D->E
        Adjacency list of vertex 2: head->B->D
        Adjacency list of vertex 3: head->B->C->E
        Adjacency list of vertex 4: head->A->B->D
        */
        for (int i = 0; i < alg.getVertexList().length; i++)
        {
            System.out.print("Adjacency list of vertex "+ i + ": head");
            for (Vertex vertex: alg.getVertexList()[i]){
                System.out.print("->"+vertex);
            }
            System.out.println();
        }
    }
    
    @Test
    public void testDFS() {
        System.out.println("testDFS");
        /*
        A: B->E
        B: A->C->D->E
        C: B->D
        D: B->C->E
        E: A->B->D
        */
        AdjListGraph alg = createListGraph();
        String[] result = alg.dfs();
        // print Visits: [A, B, C, D, E]
        System.out.print("Visits: ");
        System.out.println(Arrays.toString(result));
        assertArrayEquals(new String[] {"A","B","C","D","E"}, result);
    }
    
    @Test
    public void testBFS() {
        System.out.println("testBFS");
        /*
        A: B->E
        B: A->C->D->E
        C: B->D
        D: B->C->E
        E: A->B->D
        */
        AdjListGraph alg = createListGraph();
        String[] result = alg.bfs();
        // print Visits: [A, B, E, C, D]
        System.out.print("Visits: ");
        System.out.println(Arrays.toString(result));
        assertArrayEquals(new String[] {"A","B","E","C","D"}, result);
    }
    
    private AdjListGraph createListGraph() {
        AdjListGraph alg = new AdjListGraph(5);
        alg.addVertex("A");
        alg.addVertex("B");
        alg.addVertex("C");
        alg.addVertex("D");
        alg.addVertex("E");
        alg.addEdge(0, 1);  //AB
        alg.addEdge(0, 4);  //AE
        alg.addEdge(1, 2);  //BC
        alg.addEdge(1, 3);  //BD
        alg.addEdge(1, 4);  //BE
        alg.addEdge(2, 3);  //CD
        alg.addEdge(3, 4);  //DE
        return alg;
    }
}