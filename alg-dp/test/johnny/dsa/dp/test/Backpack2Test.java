package johnny.dsa.dp.test;

import johnny.dsa.dp.Backpack2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Backpack2Test {

    @Test
    public void testBackPack() {
        System.out.println("testBackPack");
        Backpack2 instance = new Backpack2();
        
        assertEquals(9, instance.backPack(new int[]{1, 1, 2, 2},  new int[]{1, 3, 4, 5}, 4));
    }
}
