package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack3Test {

    @Test
    public void testKnapsack31() {
        System.out.println("testKnapsack31");
        Knapsack3 instance = new Knapsack3();

        assertEquals(12, instance.knapsack31(new int[]{1, 1, 2, 2},  new int[]{1, 3, 4, 5}, 4));
        assertEquals(10, instance.knapsack31(new int[]{3, 4, 8, 5},  new int[]{1, 3, 7, 5}, 10));

        assertEquals(15, instance.knapsack31(new int[]{2, 3, 5, 7},  new int[]{1, 5, 2, 4}, 10));
        assertEquals(5, instance.knapsack31(new int[]{1, 2, 3},  new int[]{1, 2, 3}, 5));
    }

    @Test
    public void testKnapsack32() {
        System.out.println("testKnapsack32");
        Knapsack3 instance = new Knapsack3();

        assertEquals(12, instance.knapsack32(new int[]{1, 1, 2, 2},  new int[]{1, 3, 4, 5}, 4));
        assertEquals(10, instance.knapsack32(new int[]{3, 4, 8, 5},  new int[]{1, 3, 7, 5}, 10));

        assertEquals(15, instance.knapsack32(new int[]{2, 3, 5, 7},  new int[]{1, 5, 2, 4}, 10));
        assertEquals(5, instance.knapsack32(new int[]{1, 2, 3},  new int[]{1, 2, 3}, 5));
    }

    @Test
    public void testKnapsack33() {
        System.out.println("testKnapsack33");
        Knapsack3 instance = new Knapsack3();

        assertEquals(12, instance.knapsack33(new int[]{1, 1, 2, 2},  new int[]{1, 3, 4, 5}, 4));
        assertEquals(10, instance.knapsack33(new int[]{3, 4, 8, 5},  new int[]{1, 3, 7, 5}, 10));

        assertEquals(15, instance.knapsack33(new int[]{2, 3, 5, 7},  new int[]{1, 5, 2, 4}, 10));
        assertEquals(5, instance.knapsack33(new int[]{1, 2, 3},  new int[]{1, 2, 3}, 5));
    }
}
