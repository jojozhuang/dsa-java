package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack1Test {

    @Test
    public void testKnapsack() {
        System.out.println("testKnapsack11");
        Knapsack1 instance = new Knapsack1();
        assertEquals(9, instance.knapsack(new int[]{3,4,8,5}, 10));
        assertEquals(12, instance.knapsack(new int[]{2,3,5,7}, 12));
    }

    @Test
    public void testKnapsack2() {
        System.out.println("testKnapsack12");
        Knapsack1 instance = new Knapsack1();

        assertEquals(9, instance.knapsack2(new int[]{3,4,8,5}, 10));
        assertEquals(12, instance.knapsack2(new int[]{2,3,5,7}, 12));
    }

    @Test
    public void testKnapsack3() {
        System.out.println("testKnapsack13");
        Knapsack1 instance = new Knapsack1();

        assertEquals(9, instance.knapsack3(new int[]{3,4,8,5}, 10));
        assertEquals(12, instance.knapsack3(new int[]{2,3,5,7}, 12));
    }

    @Test
    public void testKnapsack4() {
        System.out.println("testKnapsack14");
        Knapsack1 instance = new Knapsack1();

        assertEquals(9, instance.knapsack4(new int[]{3,4,8,5}, 10));
        assertEquals(12, instance.knapsack4(new int[]{2,3,5,7}, 12));
    }
}
