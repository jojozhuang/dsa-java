package johnny.dsa.heap.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.heap.MinHeap;

public class MinHeapTest {

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
    public void testMinHeap() {
        System.out.println("testMinHeap");
        MinHeap heap = new MinHeap(); // it is a min heap
        heap.add(18);
        heap.add(26);
        heap.add(35);
        assertEquals(3, heap.size());
        assertEquals(18, heap.peek());
        assertEquals(18, heap.remove());
        assertEquals(26, heap.peek());
        heap.add(36);
        heap.add(30);
        heap.add(10);
        assertEquals(false, heap.isEmpty());
        assertEquals(5, heap.size());
        assertEquals(10, heap.remove());
        assertEquals(26, heap.remove());
        assertEquals(30, heap.remove());
        assertEquals(35, heap.remove());
        assertEquals(36, heap.remove());
        assertEquals(true, heap.isEmpty());
    }
}
