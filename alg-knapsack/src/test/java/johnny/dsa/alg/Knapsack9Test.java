package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack9Test {

    @Test
    public void testKnapsack() {
        System.out.println("testKnapsack9");
        Knapsack9 instance = new Knapsack9();
        double delta = 0.00001;
        
        assertEquals(0.440, instance.knapsack(10, new int[]{4,4,5}, new double[]{0.1,0.2,0.3}), delta);
        assertEquals(0.370, instance.knapsack(10, new int[]{4,5,6}, new double[]{0.1,0.2,0.3}), delta);
    }
}
