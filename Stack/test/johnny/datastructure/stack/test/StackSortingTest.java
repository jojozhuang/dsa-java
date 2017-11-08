package johnny.datastructure.stack.test;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.datastructure.stack.StackSorting;

public class StackSortingTest {

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
    public void testSort() {
        System.out.println("testSort");

        StackSorting instance = new StackSorting();
        Stack<Integer> stack = null;
        Stack<Integer> result = instance.sort(stack);
        Stack<Integer> expResult = null;
        assertEquals(expResult, result);

        Stack<Integer> stack2 = new Stack<Integer>();
        stack2.push(2);
        stack2.push(4);
        stack2.push(5);
        stack2.push(7);
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(6);
        Stack<Integer> result2 = instance.sort(stack2);
        Stack<Integer> expResult2 = new Stack<Integer>();
        expResult2.push(1);
        expResult2.push(2);
        expResult2.push(2);
        expResult2.push(3);
        expResult2.push(4);
        expResult2.push(5);
        expResult2.push(6);
        expResult2.push(7);
        assertEquals(expResult2, result2);
    }

}
