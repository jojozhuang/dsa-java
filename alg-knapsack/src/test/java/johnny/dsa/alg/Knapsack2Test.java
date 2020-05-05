package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack2Test {

    @Test
    public void testKnapsack() {
        System.out.println("testKnapsack21");
        Knapsack2 instance = new Knapsack2();

        assertEquals(9, instance.knapsack(new int[]{1, 1, 2, 2},  new int[]{1, 3, 4, 5}, 4));
    }

    @Test
    public void testKnapsack2() {
        System.out.println("testKnapsack22");
        Knapsack2 instance = new Knapsack2();
        
        assertEquals(9, instance.knapsack2(new int[]{1, 1, 2, 2},  new int[]{1, 3, 4, 5}, 4));
    }
}
