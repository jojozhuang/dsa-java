package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PairSumTest {

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
