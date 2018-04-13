package johnny.datastructure.graph.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.datastructure.graph.AdjListGraphInteger;

public class AdjListGraphIntegerTest {

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
    public void test() {
        System.out.println("testAdjMatrixGraph");
        /*
        0: 1->4
        1: 0->4->2->3
        2: 1->3
        3: 1->4->2
        4: 3->0->1
        */
        AdjListGraphInteger alg = new AdjListGraphInteger(5);
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
            for (Integer vertex: alg.getAdjList()[i]){
                System.out.print("->"+vertex);
            }
            System.out.println();
        }
        /*
         Adjacency list of vertex 0: head->1->4
         Adjacency list of vertex 1: head->0->2->3->4
         Adjacency list of vertex 2: head->1->3
         Adjacency list of vertex 3: head->1->2->4
         Adjacency list of vertex 4: head->0->1->3
        */

    }

}
