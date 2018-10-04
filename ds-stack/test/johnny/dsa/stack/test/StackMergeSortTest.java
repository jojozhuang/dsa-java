package johnny.dsa.stack.test;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.stack.StackMergeSort;

public class StackMergeSortTest {

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
    public void testStackMergeSort() {
        System.out.println("testStackMergeSort");

        StackMergeSort instance = new StackMergeSort();
        Stack<Integer> result1 = instance.sort(null);
        Stack<Integer> expect1 = null;
        assertEquals(expect1, result1);

        Stack<Integer> result2 = instance.sort(new int[] {7,2});
        Stack<Integer> expect2 = new Stack<Integer>();
        int[] nums2 = new int[] {2,7};
        for (int i : nums2) {
            expect2.push(i);
        }
        assertEquals(expect2, result2);

        Stack<Integer> result3 = instance.sort(new int[] {5,1,4});
        Stack<Integer> expect3 = new Stack<Integer>();
        int[] nums3 = new int[] {1,4,5};
        for (int i : nums3) {
            expect3.push(i);
        }
        assertEquals(expect3, result3);
        
        Stack<Integer> result4 = instance.sort(new int[] {2,4,5,7,1,2,3,6});
        Stack<Integer> expect4 = new Stack<Integer>();
        int[] nums4 = new int[] {1,2,2,3,4,5,6,7};
        for (int i : nums4) {
            expect4.push(i);
        }
        assertEquals(expect4, result4);
        
        Stack<Integer> result5 = instance.sort(new int[] {2,4,5,7,1,2,3,6,9});
        Stack<Integer> expect5 = new Stack<Integer>();
        int[] nums5 = new int[] {1,2,2,3,4,5,6,7,9};
        for (int i : nums5) {
            expect5.push(i);
        }
        assertEquals(expect5, result5);
    }
}
