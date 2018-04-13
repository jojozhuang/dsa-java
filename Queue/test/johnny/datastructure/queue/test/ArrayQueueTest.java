package johnny.datastructure.queue.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.datastructure.queue.ArrayQueue;

public class ArrayQueueTest {

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
    public void testArrayQueue() throws Exception {
        System.out.println("testArrayQueue");
        ArrayQueue queue = new ArrayQueue(100);
        assertEquals(true, queue.isEmpty());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        assertEquals(false, queue.isEmpty());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(false, queue.isEmpty());
        assertEquals(3, queue.peek());
        assertEquals(3, queue.peek());
        assertEquals(false, queue.isEmpty());
        queue.enqueue(4);
        assertEquals(3, queue.dequeue());
        assertEquals(false, queue.isEmpty());
        assertEquals(4, queue.dequeue());
        assertEquals(true, queue.isEmpty());
    }

}
