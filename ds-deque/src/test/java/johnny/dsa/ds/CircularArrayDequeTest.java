package johnny.dsa.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircularArrayDequeTest {

    @Test
    public void testCircularArrayDeque() throws Exception {
        System.out.println("testCircularArrayDeque");
        CircularArrayDeque deque = new CircularArrayDeque(100);
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
    public void testCircularArrayDeque2() throws Exception {
        System.out.println("testCircularArrayDeque2");
        CircularArrayDeque deque = new CircularArrayDeque(8);
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
    
    @Test
    public void testCircularArrayDequeCapacity() throws Exception {
        System.out.println("testCircularArrayDequeCapacity");
        CircularArrayDeque deque = new CircularArrayDeque(5);
        assertEquals(true, deque.isEmpty());
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6); // will be skipped
        
        assertEquals(false, deque.isEmpty());
        assertEquals(1, deque.removeFirst()); // 2,3,4,5
        assertEquals(2, deque.removeFirst()); // 3,4,5
        assertEquals(false, deque.isEmpty());
        assertEquals(3, deque.peekFirst());
        assertEquals(3, deque.peekFirst());
        assertEquals(5, deque.peekLast());
        assertEquals(false, deque.isEmpty());
        deque.addLast(7); // 3,4,5,7
        deque.addLast(8); // 3,4,5,7,8
        deque.addLast(9); // will be skipped
        assertEquals(3, deque.removeFirst());
        assertEquals(false, deque.isEmpty());
        assertEquals(4, deque.removeFirst());
        assertEquals(5, deque.removeFirst());
        assertEquals(false, deque.isEmpty());
        assertEquals(8, deque.removeLast());
        assertEquals(7, deque.removeLast());
        assertEquals(true, deque.isEmpty());
        Assertions.assertThrows(Exception.class, () -> {
            deque.removeFirst(); // exception
        });
        Assertions.assertThrows(Exception.class, () -> {
            deque.removeLast(); // exception
        });
        assertEquals(true, deque.isEmpty());
    }

}
