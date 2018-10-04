package johnny.dsa.queue.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.queue.CircularArrayQueue;

public class CircularArrayQueueTest {

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
    public void testCircularArrayQueue() throws Exception {
        System.out.println("testCircularArrayQueue");
        CircularArrayQueue queue = new CircularArrayQueue(100);
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
    
    @Test(expected = Exception.class)
    public void testCircularArrayQueueCapacity() throws Exception {
        System.out.println("testCircularArrayQueueCapacity");
        CircularArrayQueue queue = new CircularArrayQueue(5);
        assertEquals(true, queue.isEmpty());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6); // will be skipped
        
        assertEquals(false, queue.isEmpty());
        assertEquals(1, queue.dequeue()); // 2,3,4,5
        assertEquals(2, queue.dequeue()); // 3,4,5
        assertEquals(false, queue.isEmpty());
        assertEquals(3, queue.peek());
        assertEquals(3, queue.peek());
        assertEquals(false, queue.isEmpty());
        queue.enqueue(7); // 3,4,5,7
        queue.enqueue(8); // 3,4,5,7,8
        queue.enqueue(9); // will be skipped
        assertEquals(3, queue.dequeue());
        assertEquals(false, queue.isEmpty());
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(false, queue.isEmpty());
        assertEquals(7, queue.dequeue());
        assertEquals(8, queue.dequeue());
        assertEquals(true, queue.isEmpty());
        queue.dequeue(); // exception
        assertEquals(true, queue.isEmpty());
    }

}
