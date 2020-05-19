package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void testLongestIncreasingSubsequence() {
        System.out.println("testLongestIncreasingSubsequence");
        LongestIncreasingSubsequence instance = new LongestIncreasingSubsequence();
        
        assertEquals(3, instance.longestIncreasingSubsequence(new int[]{5,4,1,2,3}));
        assertEquals(4, instance.longestIncreasingSubsequence(new int[]{4,2,4,5,3,7}));
        assertEquals(4, instance.longestIncreasingSubsequence(new int[]{10,9,2,5,3,7,101,18}));
    }

    @Test
    public void testLongestIncreasingSubsequence2() {
        System.out.println("testLongestIncreasingSubsequence2");
        LongestIncreasingSubsequence instance = new LongestIncreasingSubsequence();

        assertEquals(3, instance.longestIncreasingSubsequence2(new int[]{5,4,1,2,3}));
        assertEquals(4, instance.longestIncreasingSubsequence2(new int[]{4,2,4,5,3,7}));
        assertEquals(4, instance.longestIncreasingSubsequence2(new int[]{10,9,2,5,3,7,101,18}));
    }

    @Test
    public void testLongestIncreasingSubsequence3() {
        System.out.println("testLongestIncreasingSubsequence3");
        LongestIncreasingSubsequence instance = new LongestIncreasingSubsequence();

        assertEquals(3, instance.longestIncreasingSubsequence3(new int[]{5,4,1,2,3}));
        assertEquals(4, instance.longestIncreasingSubsequence3(new int[]{4,2,4,5,3,7}));
        assertEquals(4, instance.longestIncreasingSubsequence3(new int[]{10,9,2,5,3,7,101,18}));
        // 10,9,2,5,7,3,101,18 -> 2,3,18
        assertEquals(4, instance.longestIncreasingSubsequence3(new int[]{10,9,2,5,7,3,101,18}));
    }

}
