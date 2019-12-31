package johnny.dsa.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {

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
        queue.enqueue(5);
        assertEquals(false, queue.isEmpty());
        assertEquals(5, queue.dequeue());
    }
    
    @Test
    public void testArrayQueueCapacity() throws Exception {
        System.out.println("testArrayQueueCapacity");
        ArrayQueue queue = new ArrayQueue(5);
        assertEquals(true, queue.isEmpty());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6); // will be skipped
        
        assertEquals(false, queue.isEmpty());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(false, queue.isEmpty());
        assertEquals(3, queue.peek());
        assertEquals(3, queue.peek());
        assertEquals(false, queue.isEmpty());
        queue.enqueue(7); // will be skipped, even though the array has space actually.
        queue.enqueue(8); // will be skipped, even though the array has space actually.
        assertEquals(3, queue.dequeue());
        assertEquals(false, queue.isEmpty());
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(true, queue.isEmpty());
        Assertions.assertThrows(Exception.class, () -> {
            queue.dequeue(); // exception
        });

        assertEquals(true, queue.isEmpty());
    }

}
