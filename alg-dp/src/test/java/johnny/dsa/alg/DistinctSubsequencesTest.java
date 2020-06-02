package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistinctSubsequencesTest {

    @Test
    public void testNumDistinct() {
        System.out.println("testNumDistinct");
        DistinctSubsequences instance = new DistinctSubsequences();
        
        assertEquals(3, instance.numDistinct("rabbbit", "rabbit"));
        assertEquals(1, instance.numDistinct("abcd", ""));
    }

}
