package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterleavingStringTest {

    @Test
    public void testIsInterleave() {
        System.out.println("testIsInterleave");
        InterleavingString instance = new InterleavingString();
        
        assertEquals(true, instance.isInterleave("aabcc", "dbbca","aadbbcbcac"));
        assertEquals(false, instance.isInterleave("", "","1"));
        assertEquals(false, instance.isInterleave("aabcc", "dbbca","aadbbbaccc"));
    }

}
