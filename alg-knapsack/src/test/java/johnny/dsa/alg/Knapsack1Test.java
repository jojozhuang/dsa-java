package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack1Test {

    @Test
    public void testKnapsack11() {
        System.out.println("testKnapsack11");
        Knapsack1 instance = new Knapsack1();
        assertEquals(9, instance.knapsack(new int[]{3,4,8,5}, 10));
        assertEquals(12, instance.knapsack(new int[]{2,3,5,7}, 12));
    }

    @Test
    public void testKnapsack12() {
        System.out.println("testKnapsack12");
        Knapsack1 instance = new Knapsack1();

        assertEquals(9, instance.knapsack12(new int[]{3,4,8,5}, 10));
        assertEquals(12, instance.knapsack12(new int[]{2,3,5,7}, 12));
    }

    @Test
    public void testKnapsack21() {
        System.out.println("testKnapsack13");
        Knapsack1 instance = new Knapsack1();

        assertEquals(9, instance.knapsack2(new int[]{3,4,8,5}, 10));
        assertEquals(12, instance.knapsack2(new int[]{2,3,5,7}, 12));
    }

    @Test
    public void testKnapsack24() {
        System.out.println("testKnapsack14");
        Knapsack1 instance = new Knapsack1();

        assertEquals(9, instance.knapsack24(new int[]{3,4,8,5}, 10));
        assertEquals(12, instance.knapsack24(new int[]{2,3,5,7}, 12));
    }
}
