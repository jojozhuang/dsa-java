package johnny.dsa.queue.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import johnny.dsa.queue.LinkedListQueue;

public class LinkedListQueueTest {

    @Test
    public void testLinkedListQueue() throws Exception {
        System.out.println("testLinkedListQueue");
        LinkedListQueue queue = new LinkedListQueue();
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

}
