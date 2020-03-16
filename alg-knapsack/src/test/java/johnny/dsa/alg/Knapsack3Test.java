package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack3Test {

    @Test
    public void testKnapsack() {
        System.out.println("testKnapsack3");
        Knapsack3 instance = new Knapsack3();
        
        assertEquals(15, instance.knapsack(new int[]{2, 3, 5, 7},  new int[]{1, 5, 2, 4}, 10));
        assertEquals(5, instance.knapsack(new int[]{1, 2, 3},  new int[]{1, 2, 3}, 5));
    }
}
