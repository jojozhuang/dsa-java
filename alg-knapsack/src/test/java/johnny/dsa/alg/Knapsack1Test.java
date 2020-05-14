package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack1Test {

    @Test
    public void testKnapsack11() {
        System.out.println("testKnapsack11");
        Knapsack1 instance = new Knapsack1();
        assertEquals(9, instance.knapsack11(new int[]{3,4,8,5}, 10));
        assertEquals(12, instance.knapsack11(new int[]{2,3,5,7}, 12));
    }

    @Test
    public void testKnapsack12() {
        System.out.println("testKnapsack12");
        Knapsack1 instance = new Knapsack1();

        assertEquals(9, instance.knapsack12(new int[]{3,4,8,5}, 10));
        assertEquals(12, instance.knapsack12(new int[]{2,3,5,7}, 12));
    }

    @Test
    public void testKnapsack13() {
        System.out.println("testKnapsack13");
        Knapsack1 instance = new Knapsack1();

        assertEquals(9, instance.knapsack13(new int[]{3,4,8,5}, 10));
        assertEquals(12, instance.knapsack13(new int[]{2,3,5,7}, 12));
    }

    @Test
    public void testKnapsack15() {
        System.out.println("testKnapsack15");
        Knapsack1 instance = new Knapsack1();

        assertEquals(9, instance.knapsack15(new int[]{3,4,8,5}, 10));
        assertEquals(12, instance.knapsack15(new int[]{2,3,5,7}, 12));
    }

    @Test
    public void testKnapsack16() {
        System.out.println("testKnapsack16");
        Knapsack1 instance = new Knapsack1();

        assertEquals(9, instance.knapsack16(new int[]{3,4,8,5}, 10));
        assertEquals(12, instance.knapsack16(new int[]{2,3,5,7}, 12));
    }
}
