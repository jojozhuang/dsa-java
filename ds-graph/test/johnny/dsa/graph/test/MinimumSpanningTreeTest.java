package johnny.dsa.graph.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import johnny.dsa.graph.MinimumSpanningTree;

public class MinimumSpanningTreeTest {

    @Test
    public void testMST() {
        System.out.println("testMST");
        /*
        Vertex | A | B | C | D | E
        -------|---|---|---|---|---
        A      | 0 | 1 | 0 | 1 | 0
        B      | 1 | 0 | 1 | 0 | 0
        C      | 0 | 1 | 0 | 0 | 0
        D      | 1 | 0 | 0 | 0 | 1
        E      | 0 | 0 | 0 | 1 | 0
        */
        MinimumSpanningTree mst = new MinimumSpanningTree(5);
        mst.addVertex("A");
        mst.addVertex("B");
        mst.addVertex("C");
        mst.addVertex("D");
        mst.addVertex("E");
        mst.addEdge(0, 1);  //AB
        mst.addEdge(0, 2);  //AC
        mst.addEdge(0, 3);  //AD
        mst.addEdge(0, 4);  //AE
        mst.addEdge(1, 2);  //BC
        mst.addEdge(1, 3);  //BD
        mst.addEdge(1, 4);  //BE
        mst.addEdge(2, 3);  //CD
        mst.addEdge(2, 4);  //CE
        mst.addEdge(3, 4);  //DE

        System.out.print("Minimum spanning tree: ");
        mst.mst();  // Minimum spanning tree: AB BC CD DE
        System.out.println();
    }

}
