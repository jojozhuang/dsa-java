package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonSubsequenceTest {

    @Test
    public void testLongestCommonSubsequence() {
        System.out.println("testLongestCommonSubsequence");
        LongestCommonSubsequence instance = new LongestCommonSubsequence();
        
        assertEquals(1, instance.longestCommonSubsequence("ABCD", "EDCA"));
        assertEquals(2, instance.longestCommonSubsequence("ABCD", "EACB"));
    }

}
