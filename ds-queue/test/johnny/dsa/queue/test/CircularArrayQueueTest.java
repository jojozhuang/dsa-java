package johnny.dsa.queue.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import johnny.dsa.queue.CircularArrayQueue;

public class CircularArrayQueueTest {

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
        queue.enqueue(5);
        assertEquals(false, queue.isEmpty());
        assertEquals(5, queue.dequeue());
    }
    
    @Test
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
        Assertions.assertThrows(Exception.class, () -> {
            queue.dequeue(); // exception
        });
        assertEquals(true, queue.isEmpty());
    }

}
