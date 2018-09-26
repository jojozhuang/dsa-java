package johnny.datastructure.graph.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.datastructure.common.Node;
import johnny.datastructure.graph.NodeGraph;

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
        NodeGraph ng = createNodeGraph();
        // print [A, B, C, D, E]
        System.out.print("Nodes: ");
        System.out.println(Arrays.toString(ng.nodes));
        /*
        // print
        Node list of vertex 0: head->B->E
        Node list of vertex 1: head->A->C->D->E
        Node list of vertex 2: head->B->D
        Node list of vertex 3: head->B->C->E
        Node list of vertex 4: head->A->B->D
        */
        
        for (int i = 0; i < ng.nodes.length; i++)
        {
            System.out.print("Node list of vertex "+ i + ": head");
            for (Node neighbor: ng.nodes[i].neighbors){
                System.out.print("->"+neighbor.name);
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
        NodeGraph ng = createNodeGraph();
        String[] result = ng.dfs(ng.nodes[0]);
        // print Visits: [A, B, C, D, E]
        System.out.print("Visits: ");
        System.out.println(Arrays.toString(result));
        assertArrayEquals(new String[] {"A","B","C","D","E"}, result);
    }
    
    @Test
    public void testDFS_Recursion() {
        System.out.println("testDFS_Recursion");
        /*
        A: B->E
        B: A->C->D->E
        C: B->D
        D: B->C->E
        E: A->B->D
        */
        NodeGraph ng = createNodeGraph();
        List<String> result = new ArrayList<String>();
        ng.dfs2(ng.nodes[0], result);
        // print Visits: [A, B, C, D, E]
        System.out.print("Visits: ");
        System.out.println(result);
       // assertArrayEquals(new String[] {"A","B","C","D","E"}, result);
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
        NodeGraph ng = createNodeGraph();
        String[] result = ng.bfs(ng.nodes[0]);
        // print Visits: [A, B, E, C, D]
        System.out.print("Visits: ");
        System.out.println(Arrays.toString(result));
        assertArrayEquals(new String[] {"A","B","E","C","D"}, result);
    }
    
    private NodeGraph createNodeGraph() {
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
        return ng;
    }

}
