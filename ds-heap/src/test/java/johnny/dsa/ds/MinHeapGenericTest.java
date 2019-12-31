package johnny.dsa.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinHeapGenericTest {

    @Test
    public void testMinHeap() {
        System.out.println("testMinHeap");
        MinHeapGeneric<Integer> heap = new MinHeapGeneric<Integer>(); // it is a min heap
        heap.add(18);
        heap.add(26);
        heap.add(35);
        assertEquals(3, heap.size());
        assertEquals(Integer.valueOf(18), heap.peek());
        assertEquals(Integer.valueOf(18), heap.remove());
        assertEquals(Integer.valueOf(26), heap.peek());
        heap.add(36);
        heap.add(30);
        heap.add(10);
        assertEquals(5, heap.size());
        assertEquals(Integer.valueOf(10), heap.remove());
        assertEquals(Integer.valueOf(26), heap.remove());
        assertEquals(Integer.valueOf(30), heap.remove());
        assertEquals(Integer.valueOf(35), heap.remove());
        assertEquals(Integer.valueOf(36), heap.remove());
    }
    
    public void testMinHeap2() {
        System.out.println("testMinHeap2");
        MinHeapGeneric<String> heap = new MinHeapGeneric<String>(); // it is a min heap
        heap.add("a");
        heap.add("b");
        heap.add("c");
        assertEquals(3, heap.size());
        assertEquals("a", heap.peek());
        assertEquals("a", heap.remove());
        assertEquals("b", heap.peek());
        heap.add("d");
        heap.add("z");
        heap.add("g");
        assertEquals(5, heap.size());
        assertEquals("b", heap.remove());
        assertEquals("c", heap.remove());
        assertEquals("d", heap.remove());
        assertEquals("g", heap.remove());
        assertEquals("z", heap.remove());
    }

}
