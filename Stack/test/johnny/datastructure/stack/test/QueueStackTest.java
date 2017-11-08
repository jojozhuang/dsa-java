package johnny.datastructure.stack.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.datastructure.stack.QueueStack;

public class QueueStackTest {

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
