package johnny.dsa.fenwicktree.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.fenwicktree.FenwickTree;;

public class FenwickTreeTest {

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

    /**
     * Test of updateBIT method, of class FenwickTree.
     */
    @Test
    public void testUpdateBIT() {
        System.out.println("updateBIT");
        int[] BITree = new int[]{2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
        FenwickTree instance = new FenwickTree(BITree);
        assertEquals(2, instance.getSum(0));
        assertEquals(3, instance.getSum(1));
        assertEquals(4, instance.getSum(2));
        assertEquals(7, instance.getSum(3));
        assertEquals(9, instance.getSum(4));
        assertEquals(12, instance.getSum(5));
        assertEquals(16, instance.getSum(6));
        assertEquals(21, instance.getSum(7));
        assertEquals(27, instance.getSum(8));
        assertEquals(34, instance.getSum(9));
        assertEquals(42, instance.getSum(10));
        assertEquals(51, instance.getSum(11));
        assertEquals(7, instance.getSum(0,3));
        assertEquals(9, instance.getSum(0,4));
        assertEquals(5, instance.getSum(3,4));
        assertEquals(2, instance.getSum(4,4));
        assertEquals(9, instance.getSum(11,11));
        instance.updateBIT(1, 2);
        assertEquals(2, instance.getSum(0));
        assertEquals(5, instance.getSum(1));
        assertEquals(6, instance.getSum(2));
        assertEquals(9, instance.getSum(3));
        assertEquals(11, instance.getSum(4));
        assertEquals(23, instance.getSum(7));
    }
}
