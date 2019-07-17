package johnny.dsa.bloomfilter.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {
    @Test
    public void testHashMap() {
        long start = System.currentTimeMillis();
        Set<Integer> set = new HashSet<>(100);
        for (int i = 0; i < 10000000; i++) {
            set.add(i);
        }
        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        assertTrue(set.contains(3));

        long end = System.currentTimeMillis();
        System.out.println("Executed Time: " + (end - start));

    }
}
