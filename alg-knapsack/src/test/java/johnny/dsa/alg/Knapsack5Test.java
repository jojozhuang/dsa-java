package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack5Test {

    @Test
    public void testKnapsack51() {
        System.out.println("testKnapsack51");
        Knapsack5 instance = new Knapsack5();

        assertEquals(1, instance.knapsack51(new int[]{2,3,6,7}, 7));
        assertEquals(2, instance.knapsack51(new int[]{1,2,3,3,7}, 7));
    }

    @Test
    public void testKnapsack52() {
        System.out.println("testKnapsack52");
        Knapsack5 instance = new Knapsack5();

        assertEquals(1, instance.knapsack52(new int[]{2,3,6,7}, 7));
        assertEquals(2, instance.knapsack52(new int[]{1,2,3,3,7}, 7));
    }

    @Test
    public void testKnapsack53() {
        System.out.println("testKnapsack53");
        Knapsack5 instance = new Knapsack5();

        assertEquals(1, instance.knapsack53(new int[]{2,3,6,7}, 7));
        assertEquals(2, instance.knapsack53(new int[]{1,2,3,3,7}, 7));
    }
}
