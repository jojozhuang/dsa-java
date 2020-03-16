package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack6Test {

    @Test
    public void testKnapsack() {
        System.out.println("testKnapsack6");
        Knapsack6 instance = new Knapsack6();
        
        assertEquals(6, instance.knapsack(new int[]{1,2,4}, 4));
        assertEquals(5, instance.knapsack(new int[]{1,2}, 4));
    }
}
