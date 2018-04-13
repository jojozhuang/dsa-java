package johnny.datastructure.graph.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.datastructure.graph.AdjListGraph;
import johnny.datastructure.graph.Node;
import johnny.datastructure.graph.NodeGraph;
import johnny.datastructure.graph.Vertex;

public class NodeGraphTest {

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
    public void testNodeGraph() {
        System.out.println("testNodeGraph");
        /*
        A: B->E
        B: A->C->D->E
        C: B->D
        D: B->C->E
        E: A->B->D
        */
        NodeGraph ng = new NodeGraph(5);
        ng.nodes[0] = new Node("A");
        ng.nodes[1] = new Node("B");
        ng.nodes[2] = new Node("C");
        ng.nodes[3] = new Node("D");
        ng.nodes[4] = new Node("E");
        ng.addNeighbors(0, new Node[] {ng.nodes[1], ng.nodes[4]});
        ng.addNeighbors(1, new Node[] {ng.nodes[0], ng.nodes[2], ng.nodes[3], ng.nodes[4]});
        ng.addNeighbors(2, new Node[] {ng.nodes[1], ng.nodes[3]});
        ng.addNeighbors(3, new Node[] {ng.nodes[1], ng.nodes[2], ng.nodes[4]});
        ng.addNeighbors(4, new Node[] {ng.nodes[0], ng.nodes[1], ng.nodes[3]});
        
        for (int i = 0; i < ng.nodes.length; i++)
        {
            System.out.print("Adjacency list of vertex "+ i + ": head");
            for (Node neighbor: ng.nodes[i].neighbors){
                System.out.print("->"+neighbor.name);
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
    public void testDFS() {
        System.out.println("testDFS");
        /*
        A: B->E
        B: A->C->D->E
        C: B->D
        D: B->C->E
        E: A->B->D
        */
        NodeGraph ng = new NodeGraph(5);
        ng.nodes[0] = new Node("A");
        ng.nodes[1] = new Node("B");
        ng.nodes[2] = new Node("C");
        ng.nodes[3] = new Node("D");
        ng.nodes[4] = new Node("E");
        ng.addNeighbors(0, new Node[] {ng.nodes[1], ng.nodes[4]});
        ng.addNeighbors(1, new Node[] {ng.nodes[0], ng.nodes[2], ng.nodes[3], ng.nodes[4]});
        ng.addNeighbors(2, new Node[] {ng.nodes[1], ng.nodes[3]});
        ng.addNeighbors(3, new Node[] {ng.nodes[1], ng.nodes[2], ng.nodes[4]});
        ng.addNeighbors(4, new Node[] {ng.nodes[0], ng.nodes[1], ng.nodes[3]});

        System.out.print("Visits: ");
        ng.dfs(ng.nodes[0]);  // Visits: ABCDE
        System.out.println();
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
        NodeGraph ng = new NodeGraph(5);
        ng.nodes[0] = new Node("A");
        ng.nodes[1] = new Node("B");
        ng.nodes[2] = new Node("C");
        ng.nodes[3] = new Node("D");
        ng.nodes[4] = new Node("E");
        ng.addNeighbors(0, new Node[] {ng.nodes[1], ng.nodes[4]});
        ng.addNeighbors(1, new Node[] {ng.nodes[0], ng.nodes[2], ng.nodes[3], ng.nodes[4]});
        ng.addNeighbors(2, new Node[] {ng.nodes[1], ng.nodes[3]});
        ng.addNeighbors(3, new Node[] {ng.nodes[1], ng.nodes[2], ng.nodes[4]});
        ng.addNeighbors(4, new Node[] {ng.nodes[0], ng.nodes[1], ng.nodes[3]});

        System.out.print("Visits: ");
        ng.bfs(ng.nodes[0]);  // Visits: ABECD
        System.out.println();
    }

}
