package johnny.dsa.sqrtdecomposition.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.sqrtdecomposition.RangeSearchSum;;

public class RangeSearchSumTest {

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
    public void testPerfectSquare() {
        System.out.println("testPerfectSquare");
        RangeSearchSum sd = new RangeSearchSum(new int[] {3,2,1,5,6,10,3,9,8});
        // {3,2,1,5,6,10,3,9,8}, length = 9
        assertEquals(5, sd.query(0, 1));
        assertEquals(6, sd.query(0, 2));
        assertEquals(21, sd.query(3, 5));
        assertEquals(20, sd.query(6, 8));
        assertEquals(33, sd.query(3, 7));
        assertEquals(34, sd.query(2, 7));
        sd.update(2, 7); // {3,2,7,5,6,10,3,9,8}
        assertEquals(12, sd.query(0, 2));
        assertEquals(40, sd.query(2, 7));
        assertEquals(12, sd.query(6, 7));
        assertEquals(17, sd.query(7, 8));
        sd.update(7, 12); // {3,2,7,5,6,10,3,12,8}
        assertEquals(15, sd.query(6, 7));
        assertEquals(20, sd.query(7, 8));
        assertEquals(56, sd.query(0, 8));
    }
    
    @Test
    public void testNonPerfectSquare() {
        System.out.println("testNonSqrtDecomposition");
        RangeSearchSum sd = new RangeSearchSum(new int[] {3,2,1,5,6,10,3,9,8,4,2});
        //{3,2,1,5,6,10,3,9,8,4,2,0,0,0,0,0}, length = 16
        assertEquals(5, sd.query(0, 1));
        assertEquals(6, sd.query(0, 2));
        assertEquals(21, sd.query(3, 5));
        assertEquals(20, sd.query(6, 8));
        assertEquals(34, sd.query(2, 7));
        assertEquals(33, sd.query(3, 7));
        assertEquals(6, sd.query(9, 10));
        assertEquals(34, sd.query(2, 7));
        sd.update(2, 7); // {3,2,7,5,6,10,3,9,8,4,2}
        assertEquals(12, sd.query(0, 2));
        assertEquals(54, sd.query(2, 10));
        assertEquals(59, sd.query(0, 10));
    }
}
