package johnny.dsa.bloomfilter.test;

import johnny.dsa.bloomfilter.BloomFilter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {
    @Test
    public void testBloomFilter() {
        int capacity = 100000000;
        int count = capacity / 10;
        long start = System.currentTimeMillis();
        BloomFilter bloomFilter = new BloomFilter(capacity);
        for (int i = 0; i < count; i++) {
            bloomFilter.add(i + "");
        }
        assertTrue(bloomFilter.contains(1 + ""));
        assertTrue(bloomFilter.contains(2 + ""));
        assertTrue(bloomFilter.contains(3 + ""));
        assertTrue(bloomFilter.contains(999999 + ""));
        assertFalse(bloomFilter.contains(10000001 + ""));
        assertFalse(bloomFilter.contains(400230340 + ""));

        long end = System.currentTimeMillis();
        System.out.println("Executed Time: " + (end - start));

    }
}