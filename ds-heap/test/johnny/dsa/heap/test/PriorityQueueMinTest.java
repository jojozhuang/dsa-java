package johnny.dsa.heap.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.heap.PriorityQueueMin;

public class PriorityQueueMinTest {

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
    public void testPriorityQueueMin() {
        System.out.println("testPriorityQueueMin");
        PriorityQueueMin pq = new PriorityQueueMin(); // it is a min priority queue
        pq.add(18);
        pq.add(26);
        pq.add(35);
        assertEquals(3, pq.size());
        assertEquals(18, pq.peek());
        assertEquals(18, pq.poll());
        assertEquals(26, pq.peek());
        pq.add(36);
        pq.add(30);
        pq.add(10);
        assertEquals(false, pq.isEmpty());
        assertEquals(5, pq.size());
        assertEquals(10, pq.poll());
        assertEquals(26, pq.poll());
        assertEquals(30, pq.poll());
        assertEquals(35, pq.poll());
        assertEquals(36, pq.poll());
        assertEquals(true, pq.isEmpty());
    }
}
