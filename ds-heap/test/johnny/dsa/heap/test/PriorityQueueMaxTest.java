package johnny.dsa.heap.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.heap.PriorityQueueMax;

public class PriorityQueueMaxTest {

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
    public void testPriorityQueueMax() {
        System.out.println("testPriorityQueueMax");
        PriorityQueueMax pq = new PriorityQueueMax(); // it is a max priority queue
        pq.add(18);
        pq.add(26);
        pq.add(35);
        assertEquals(3, pq.size());
        assertEquals(35, pq.peek());
        assertEquals(35, pq.poll());
        assertEquals(26, pq.peek());
        pq.add(36);
        pq.add(30);
        pq.add(10);
        assertEquals(false, pq.isEmpty());
        assertEquals(5, pq.size());
        assertEquals(36, pq.poll());
        assertEquals(30, pq.poll());
        assertEquals(26, pq.poll());
        assertEquals(18, pq.poll());
        assertEquals(10, pq.poll());
        assertEquals(true, pq.isEmpty());
    }
}
