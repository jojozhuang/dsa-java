package johnny.dsa.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueStackTest {

    @Test
    public void testQueueStack() throws Exception {
        System.out.println("testQueueStack");
        QueueStack stack = new QueueStack();

        assertEquals(true, stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);

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
