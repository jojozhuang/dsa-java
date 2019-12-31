package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackpackTest {

    @Test
    public void testBackPack() {
        System.out.println("testBackPack");
        Backpack instance = new Backpack();
        assertEquals(9, instance.backPack(new int[]{3,4,8,5}, 10));
        assertEquals(12, instance.backPack(new int[]{2,3,5,7}, 12));
    }

    @Test
    public void testBackPack2() {
        System.out.println("testBackPack");
        Backpack instance = new Backpack();

        assertEquals(9, instance.backPack2(new int[]{3,4,8,5}, 10));
        assertEquals(12, instance.backPack2(new int[]{2,3,5,7}, 12));
    }
}
