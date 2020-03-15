package johnny.dsa.ds;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopologicalSortingTest {

    /**
     * Test of topSort method, of class TopologicalSorting.
     */
    @Test
    public void testTopSort() {
        System.out.println("topSort");
        TopologicalSorting instance = new TopologicalSorting();
        assertEquals(null, instance.topSort(null));

        DirectedGraphNode node10 = new DirectedGraphNode(0);
        DirectedGraphNode node11 = new DirectedGraphNode(1);
        DirectedGraphNode node12 = new DirectedGraphNode(2);
        DirectedGraphNode node13 = new DirectedGraphNode(3);
        DirectedGraphNode node14 = new DirectedGraphNode(4);
        DirectedGraphNode node15 = new DirectedGraphNode(5);
        node10.neighbors.add(node11);
        node10.neighbors.add(node12);
        node10.neighbors.add(node13);
        node11.neighbors.add(node14);
        node12.neighbors.add(node14);
        node12.neighbors.add(node15);
        node13.neighbors.add(node14);
        node13.neighbors.add(node15);

        List<DirectedGraphNode> graph2 = new ArrayList<>();
        graph2.add(node10);
        graph2.add(node11);
        graph2.add(node12);
        graph2.add(node13);
        graph2.add(node14);
        graph2.add(node15);
        List<DirectedGraphNode> result2 = instance.topSort(graph2);
        List<DirectedGraphNode> expect2 = new ArrayList<>();
        expect2.add(node10);
        expect2.add(node11);
        expect2.add(node12);
        expect2.add(node13);
        expect2.add(node14);
        expect2.add(node15);
        assertEquals(expect2, result2);
    }

}
