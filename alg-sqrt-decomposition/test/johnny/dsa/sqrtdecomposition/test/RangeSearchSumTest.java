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
        RangeSearchSum sd = new RangeSearchSum(new int[] {3,5,1,5,6,10,4,2,8});
        // {3,5,1,5,6,10,4,2,8}, length = 9
        assertEquals(8, sd.query(0, 1));
        assertEquals(9, sd.query(0, 2));
        assertEquals(21, sd.query(3, 5));
        assertEquals(14, sd.query(6, 8));
        assertEquals(27, sd.query(3, 7));
        assertEquals(28, sd.query(2, 7));
        assertEquals(44, sd.query(0, 8));
        sd.update(2, 7); // {3,5,7,5,6,10,4,2,8}
        assertEquals(15, sd.query(0, 2));
        assertEquals(34, sd.query(2, 7));
        assertEquals(6, sd.query(6, 7));
        assertEquals(10, sd.query(7, 8));
        sd.update(7, 12); // {3,5,7,5,6,10,4,12,8}
        assertEquals(16, sd.query(6, 7));
        assertEquals(20, sd.query(7, 8));
        assertEquals(60, sd.query(0, 8));
    }
    
    @Test
    public void testNonPerfectSquare() {
        System.out.println("testNonSqrtDecomposition");
        RangeSearchSum sd = new RangeSearchSum(new int[] {3,5,1,5,6,10,4,2,8,9,7});
        //{3,5,1,5,6,10,4,2,8,9,7,0,0,0,0,0}, length = 16
        assertEquals(8, sd.query(0, 1));
        assertEquals(9, sd.query(0, 2));
        assertEquals(21, sd.query(3, 5));
        assertEquals(14, sd.query(6, 8));
        assertEquals(27, sd.query(3, 7));
        assertEquals(28, sd.query(2, 7));
        assertEquals(16, sd.query(9, 10));
        sd.update(2, 7); // {3,5,7,5,6,10,4,2,8,9,7,0,0,0,0,0}
        assertEquals(15, sd.query(0, 2));
        assertEquals(58, sd.query(2, 10));
        assertEquals(66, sd.query(0, 10));
    }
}
