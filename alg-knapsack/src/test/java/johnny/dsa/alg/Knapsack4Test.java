package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack4Test {

    @Test
    public void testKnapsack41() {
        System.out.println("testKnapsack41");
        Knapsack4 instance = new Knapsack4();

        assertEquals(2, instance.knapsack41(new int[]{2,3,6,7}, 7));
        assertEquals(3, instance.knapsack41(new int[]{2,3,4,5},  7));
    }

    @Test
    public void testKnapsack42() {
        System.out.println("testKnapsack42");
        Knapsack4 instance = new Knapsack4();

        assertEquals(2, instance.knapsack42(new int[]{2,3,6,7}, 7));
        assertEquals(3, instance.knapsack42(new int[]{2,3,4,5},  7));
    }

    @Test
    public void testKnapsack43() {
        System.out.println("testKnapsack43");
        Knapsack4 instance = new Knapsack4();

        assertEquals(2, instance.knapsack43(new int[]{2,3,6,7}, 7));
        assertEquals(3, instance.knapsack43(new int[]{2,3,4,5},  7));
    }
}
