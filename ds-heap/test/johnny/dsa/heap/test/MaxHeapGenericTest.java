package johnny.dsa.heap.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.heap.MaxHeapGeneric;

public class MaxHeapGenericTest {

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
    public void testMaxHeap() {
        System.out.println("testMaxHeap");
        MaxHeapGeneric<Integer> heap = new MaxHeapGeneric<Integer>(); // it is a max heap
        heap.add(18);
        heap.add(26);
        heap.add(35);
        assertEquals(3, heap.size());
        assertEquals(Integer.valueOf(35), heap.peek());
        assertEquals(Integer.valueOf(35), heap.remove());
        assertEquals(Integer.valueOf(26), heap.peek());
        heap.add(36);
        heap.add(30);
        heap.add(10);
        assertEquals(5, heap.size());
        assertEquals(Integer.valueOf(36), heap.remove());
        assertEquals(Integer.valueOf(30), heap.remove());
        assertEquals(Integer.valueOf(26), heap.remove());
        assertEquals(Integer.valueOf(18), heap.remove());
        assertEquals(Integer.valueOf(10), heap.remove());
    }
    
    public void testMaxHeap2() {
        System.out.println("testMaxHeap2");
        MaxHeapGeneric<String> heap = new MaxHeapGeneric<String>(); // it is a max heap
        heap.add("a");
        heap.add("b");
        heap.add("c");
        assertEquals(3, heap.size());
        assertEquals("c", heap.peek());
        assertEquals("c", heap.remove());
        assertEquals("b", heap.peek());
        heap.add("d");
        heap.add("z");
        heap.add("g");
        assertEquals(5, heap.size());
        assertEquals("z", heap.remove());
        assertEquals("g", heap.remove());
        assertEquals("d", heap.remove());
        assertEquals("b", heap.remove());
        assertEquals("a", heap.remove());
    }

}
