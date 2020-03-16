package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack7Test {

    @Test
    public void testKnapsack() {
        System.out.println("testKnapsack7");
        Knapsack7 instance = new Knapsack7();
        
        assertEquals(640, instance.knapsack(8, new int[]{3,2}, new int[]{300, 160},new int[]{1,6}));
        assertEquals(400, instance.knapsack(8, new int[]{2,4}, new int[]{100, 100},new int[]{4,2}));
    }
}
