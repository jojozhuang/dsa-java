package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack10Test {

    @Test
    public void testKnapsack() {
        System.out.println("testKnapsack10");
        Knapsack10 instance = new Knapsack10();

        assertEquals(0, instance.knapsack(900));
        assertEquals(0, instance.knapsack(800));
    }
}
