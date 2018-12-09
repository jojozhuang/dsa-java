package johnny.dsa.hashmap.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import johnny.dsa.hashmap.HashMapInt;

public class HashMapIntTest {

    @Test
    public void testHashMapInt() {
        System.out.println("testHashMapInt");
        final HashMapInt map = new HashMapInt();
        assertEquals(true, map.isEmpty());
        map.add(0, 0);
        map.add(1, 100);
        map.add(2, 200);
        map.add(5, 500);
        assertEquals(false, map.isEmpty());
        assertEquals(4, map.size());
        assertEquals(100, map.get(1));
        assertEquals(500, map.get(5));
        assertEquals(Integer.MIN_VALUE, map.get(9));
        map.remove(2);
        assertEquals(Integer.MIN_VALUE, map.get(2));
        
        map.add(2, 200);
        map.add(3, 300);
        map.add(4, 400);
        map.add(6, 600); // rehashing, 7 out of 10, size doubled
        map.add(7, 700); 
        map.add(8, 800);
        map.add(9, 900);
        map.add(10, 1000);
        map.add(11, 1100);
        map.add(110, 110);
        map.add(111, 111); // rehashing, 14 out of 20, size doubled
        assertEquals(14, map.size());
        assertEquals(1000, map.get(10));
        assertEquals(1100, map.get(11));
        assertEquals(110, map.get(110));
        assertEquals(111, map.get(111));
    }
}
