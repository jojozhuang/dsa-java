package johnny.datastructure.graph.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.datastructure.graph.AdjListGraph;
import johnny.datastructure.graph.Vertex;

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
    public void testAdjListGraphInteger() {
        System.out.println("testAdjListGraphInteger");
        /*
        A: B->E
        B: A->E->C->D
        C: B->D
        D: B->E->C
        E: D->A->B
        */
        AdjListGraph alg = new AdjListGraph(new String[] {"A","B","C","D","E"});
        alg.addEdge(0, 1);
        alg.addEdge(0, 4);
        alg.addEdge(1, 2);
        alg.addEdge(1, 3);
        alg.addEdge(1, 4);
        alg.addEdge(2, 3);
        alg.addEdge(3, 4);
        
        for (int i = 0; i < alg.getAdjList().length; i++)
        {
            System.out.print("Adjacency list of vertex "+ i + ": head");
            for (Vertex vertex: alg.getAdjList()[i]){
                System.out.print("->"+vertex);
            }
            System.out.println();
        }
        /*
         Adjacency list of vertex 0: head->B->E
         Adjacency list of vertex 1: head->A->C->D->E
         Adjacency list of vertex 2: head->B->D
         Adjacency list of vertex 3: head->B->C->E
         Adjacency list of vertex 4: head->A->B->D
        */
    }
    
    @Test
    public void testDFSAdjList() {
        System.out.println("testDFSAdjList");
        /*
        A: B->E
        B: A->E->C->D
        C: B->D
        D: B->E->C
        E: D->A->B
        */
        AdjListGraph alg = new AdjListGraph(new String[] {"A","B","C","D","E"});
        alg.addEdge(0, 1);
        alg.addEdge(0, 4);
        alg.addEdge(1, 2);
        alg.addEdge(1, 3);
        alg.addEdge(1, 4);
        alg.addEdge(2, 3);
        alg.addEdge(3, 4);

        System.out.print("Visits: ");
        alg.dfs();  // Visits: ABCDE
        System.out.println();
    }
    
    @Test
    public void testBFSAdjList() {
        System.out.println("testBFSAdjList");
        /*
        A: B->E
        B: A->E->C->D
        C: B->D
        D: B->E->C
        E: D->A->B
        */
        AdjListGraph alg = new AdjListGraph(new String[] {"A","B","C","D","E"});
        alg.addEdge(0, 1);
        alg.addEdge(0, 4);
        alg.addEdge(1, 2);
        alg.addEdge(1, 3);
        alg.addEdge(1, 4);
        alg.addEdge(2, 3);
        alg.addEdge(3, 4);

        System.out.print("Visits: ");
        alg.bfs();  // Visits: ABECD
        System.out.println();
    }
}
//https://www.geeksforgeeks.org/graph-and-its-representations/
