package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack8Test {

    @Test
    public void testKnapsack() {
        System.out.println("testKnapsack8");
        Knapsack8 instance = new Knapsack8();
        
        assertEquals(4, instance.knapsack(5, new int[]{1,4}, new int[]{2, 1}));
        assertEquals(8, instance.knapsack(10, new int[]{1,2,4}, new int[]{2,1,1}));
    }
}
