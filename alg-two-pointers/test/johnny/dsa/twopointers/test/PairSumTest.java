package johnny.dsa.twopointers.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.twopointers.PairSum;;

public class PairSumTest {

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
    public void testIsPairSumNaive() {
        System.out.println("testIsPairSumNaive");
        PairSum instance = new PairSum();

        assertEquals(true, instance.isPairSumNaive(new int[] {-1,0,3,5,9,12}, 9));
        assertEquals(false, instance.isPairSumNaive(new int[] {-1,0,3,5,9,12}, 7));
        assertEquals(true, instance.isPairSumNaive(new int[] {-1,0,3,5,9,12}, 8));
        assertEquals(false, instance.isPairSumNaive(new int[] {-1,0,3,5,9,12}, 100));
        assertEquals(true, instance.isPairSumNaive(new int[] {1,5,8,10,10,10,13,16,27}, 26));
        assertEquals(false, instance.isPairSumNaive(new int[] {1,5,8,10,10,10,13,16,27}, 7));
    }

    @Test
    public void testIsPairSum() {
        System.out.println("testIsPairSum");
        PairSum instance = new PairSum();

        assertEquals(true, instance.isPairSum(new int[] {-1,0,3,5,9,12}, 9));
        assertEquals(false, instance.isPairSum(new int[] {-1,0,3,5,9,12}, 7));
        assertEquals(true, instance.isPairSum(new int[] {-1,0,3,5,9,12}, 8));
        assertEquals(false, instance.isPairSum(new int[] {-1,0,3,5,9,12}, 100));
        assertEquals(true, instance.isPairSum(new int[] {1,5,8,10,10,10,13,16,27}, 26));
        assertEquals(false, instance.isPairSum(new int[] {1,5,8,10,10,10,13,16,27}, 7));
    }
}
