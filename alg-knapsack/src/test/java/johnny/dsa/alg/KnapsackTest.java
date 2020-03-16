package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsack() {
        System.out.println("testKnapsack");
        Knapsack instance = new Knapsack();
        assertEquals(9, instance.knapsack(new int[]{3,4,8,5}, 10));
        assertEquals(12, instance.knapsack(new int[]{2,3,5,7}, 12));
    }

    @Test
    public void testKnapsack2() {
        System.out.println("testKnapsack2");
        Knapsack instance = new Knapsack();

        assertEquals(9, instance.knapsack2(new int[]{3,4,8,5}, 10));
        assertEquals(12, instance.knapsack2(new int[]{2,3,5,7}, 12));
    }
}
