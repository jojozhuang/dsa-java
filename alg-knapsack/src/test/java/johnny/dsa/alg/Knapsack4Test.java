package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack4Test {

    @Test
    public void testKnapsack() {
        System.out.println("testKnapsack4");
        Knapsack4 instance = new Knapsack4();
        
        assertEquals(2, instance.knapsack(new int[]{2,3,6,7}, 7));
        assertEquals(3, instance.knapsack(new int[]{2,3,4,5},  7));
    }
}
