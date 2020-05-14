package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack2Test {

    @Test
    public void testKnapsack21() {
        System.out.println("testKnapsack21");
        Knapsack2 instance = new Knapsack2();

        assertEquals(9, instance.knapsack21(new int[]{1, 1, 2, 2},  new int[]{1, 3, 4, 5}, 4));
        assertEquals(8, instance.knapsack21(new int[]{3, 4, 8, 5},  new int[]{1, 3, 7, 5}, 10));
    }

    @Test
    public void testKnapsack22() {
        System.out.println("testKnapsack22");
        Knapsack2 instance = new Knapsack2();

        assertEquals(9, instance.knapsack22(new int[]{1, 1, 2, 2},  new int[]{1, 3, 4, 5}, 4));
        assertEquals(8, instance.knapsack22(new int[]{3, 4, 8, 5},  new int[]{1, 3, 7, 5}, 10));
    }

    @Test
    public void testKnapsack23() {
        System.out.println("testKnapsack23");
        Knapsack2 instance = new Knapsack2();

        assertEquals(9, instance.knapsack23(new int[]{1, 1, 2, 2},  new int[]{1, 3, 4, 5}, 4));
        assertEquals(8, instance.knapsack23(new int[]{3, 4, 8, 5},  new int[]{1, 3, 7, 5}, 10));
    }
}
