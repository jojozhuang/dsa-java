package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack5Test {

    @Test
    public void testKnapsack() {
        System.out.println("testKnapsack5");
        Knapsack5 instance = new Knapsack5();
        
        assertEquals(2, instance.knapsack(new int[]{1,2,3,3,7}, 7));
    }
}
