package johnny.dsa.heap.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import johnny.dsa.heap.MaxHeap;

public class MaxHeapTest {

    @Test
    public void testMaxHeap() {
        System.out.println("testMaxHeap");
        MaxHeap heap = new MaxHeap(); // it is a max heap
        heap.add(18);
        heap.add(26);
        heap.add(35);
        assertEquals(3, heap.size());
        assertEquals(35, heap.peek());
        assertEquals(35, heap.remove());
        assertEquals(26, heap.peek());
        heap.add(36);
        heap.add(30);
        heap.add(10);
        assertEquals(false, heap.isEmpty());
        assertEquals(5, heap.size());
        assertEquals(36, heap.remove());
        assertEquals(30, heap.remove());
        assertEquals(26, heap.remove());
        assertEquals(18, heap.remove());
        assertEquals(10, heap.remove());
        assertEquals(true, heap.isEmpty());
    }
}
