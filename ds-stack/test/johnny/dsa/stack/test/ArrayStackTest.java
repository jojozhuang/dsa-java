package johnny.dsa.stack.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import johnny.dsa.stack.ArrayStack;

public class ArrayStackTest {

    @Test
    void testArrayStack() throws Exception {
        System.out.println("testArrayStack");
        ArrayStack stack = new ArrayStack(100);

        assertEquals(true, stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // random access
        assertEquals(1, stack.get(0));
        assertEquals(2, stack.get(1));
        assertEquals(3, stack.get(2));
        
        assertEquals(false, stack.isEmpty());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(false, stack.isEmpty());
        assertEquals(1, stack.peek());
        assertEquals(1, stack.peek());
        assertEquals(false, stack.isEmpty());
        stack.push(4);
        assertEquals(4, stack.pop());
        assertEquals(false, stack.isEmpty());
        assertEquals(1, stack.pop());
        assertEquals(true, stack.isEmpty());
    }

}
