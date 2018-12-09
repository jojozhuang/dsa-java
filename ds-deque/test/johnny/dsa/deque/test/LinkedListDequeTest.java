package johnny.dsa.deque.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import johnny.dsa.deque.LinkedListDeque;

public class LinkedListDequeTest {

    @Test
    public void testLinkedListDeque() throws Exception {
        System.out.println("testLinkedListDeque");
        LinkedListDeque deque = new LinkedListDeque();
        assertEquals(true, deque.isEmpty());
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        
        assertEquals(false, deque.isEmpty());
        assertEquals(1, deque.removeFirst());
        assertEquals(3, deque.removeLast());
        assertEquals(false, deque.isEmpty());
        assertEquals(2, deque.peekFirst());
        assertEquals(2, deque.peekLast());
        assertEquals(false, deque.isEmpty());
        deque.addFirst(4);
        assertEquals(4, deque.peekFirst());
        assertEquals(2, deque.peekLast());
        assertEquals(2, deque.removeLast());
        assertEquals(false, deque.isEmpty());
        assertEquals(4, deque.removeLast());
        assertEquals(true, deque.isEmpty());
    }
    
    @Test
    public void testLinkedListDeque2() throws Exception {
        System.out.println("testLinkedListDeque2");
        LinkedListDeque deque = new LinkedListDeque();
        assertEquals(true, deque.isEmpty());
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3); // [2,1,3]
        
        assertEquals(false, deque.isEmpty());
        assertEquals(2, deque.removeFirst());
        assertEquals(3, deque.removeLast());
        assertEquals(false, deque.isEmpty());
        assertEquals(1, deque.peekFirst());
        assertEquals(1, deque.peekLast());
        assertEquals(false, deque.isEmpty());
        deque.addFirst(4); //[4,1]
        assertEquals(4, deque.peekFirst());
        assertEquals(1, deque.peekLast());
        assertEquals(1, deque.removeLast()); //[4]
        assertEquals(false, deque.isEmpty());
        assertEquals(4, deque.removeLast());
        assertEquals(true, deque.isEmpty());
    }

}
