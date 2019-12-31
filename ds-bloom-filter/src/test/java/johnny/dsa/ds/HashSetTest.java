package johnny.dsa.ds;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class HashSetTest {
    @Test
    public void testHashSet() {
        int capacity = 100000000;
        int count = capacity / 10;
        long start = System.currentTimeMillis();
        Set<Integer> set = new HashSet<>(capacity);
        for (int i = 0; i < count; i++) {
            set.add(i);
        }
        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        assertTrue(set.contains(3));
        assertTrue(set.contains(999999));
        assertFalse(set.contains(10000001));
        assertFalse(set.contains(400230340));

        long end = System.currentTimeMillis();
        System.out.println("Executed Time: " + (end - start));
    }
}
