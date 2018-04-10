package johnny.datastructure.heap;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
        assertEquals(5, heap.size());
        assertEquals(10, heap.remove());
        assertEquals(26, heap.remove());
        assertEquals(30, heap.remove());
        assertEquals(35, heap.remove());
        assertEquals(36, heap.remove());
    }
    
    public void testMinHeap2() {
        System.out.println("testMinHeap2");
        MinHeap<String> heap = new MinHeap<String>(); // it is a min heap
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
