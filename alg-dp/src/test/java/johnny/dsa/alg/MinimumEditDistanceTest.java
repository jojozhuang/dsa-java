package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumEditDistanceTest {

    @Test
    public void testMinDistance() {
        System.out.println("testMinDistance");
        MinimumEditDistance instance = new MinimumEditDistance();
        
        assertEquals(3, instance.minDistance("horse", "ros"));
        assertEquals(5, instance.minDistance("intention", "execution"));
        //assertEquals(2, instance.minDistance("johnny", "john"));
    }

}
