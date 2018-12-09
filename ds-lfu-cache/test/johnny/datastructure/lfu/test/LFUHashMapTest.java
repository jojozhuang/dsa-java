package johnny.datastructure.lfu.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import johnny.dsa.lfu.LFUHashMap;

public class LFUHashMapTest {

    @Test
    public void testLRUCache() {
        System.out.println("testLRUCache");
        LFUHashMap lfu = new LFUHashMap(2);

        lfu.add(1, 1);
        lfu.add(2, 2);
        assertEquals(1, lfu.get(1));       // returns 1
        lfu.add(3, 3);                     // evicts key 2
        assertEquals(-1, lfu.get(2));      // returns -1 (not found)
        assertEquals(3, lfu.get(3));       // returns 3.
        lfu.add(4, 4);                     // evicts key 1.
        assertEquals(-1,lfu.get(1));       // returns -1 (not found)
        assertEquals(3,lfu.get(3));        // returns 3
        assertEquals(4,lfu.get(4));        // returns 4
    }
    
    @Test
    public void testLFUCache() {
        System.out.println("testLFUCache");
        LFUHashMap lfu = new LFUHashMap(5); //capacity = 5
        lfu.add(1,1);
        assertArrayEquals(new int[][]{{1},{0}}, lfu.getAll());
        lfu.add(2,2);
        assertArrayEquals(new int[][]{{2,1},{0,0}}, lfu.getAll());
        lfu.add(3,3);
        assertArrayEquals(new int[][]{{3,2,1},{0,0,0}}, lfu.getAll());
        assertEquals(1, lfu.get(1));
        assertArrayEquals(new int[][]{{1,3,2},{1,0,0}}, lfu.getAll());
        assertEquals(3, lfu.get(3));
        assertArrayEquals(new int[][]{{3,1,2},{1,1,0}}, lfu.getAll());
        assertEquals(3, lfu.get(3));
        assertArrayEquals(new int[][]{{3,1,2},{2,1,0}}, lfu.getAll());
        lfu.add(4,4);
        assertArrayEquals(new int[][]{{3,1,4,2},{2,1,0,0}}, lfu.getAll());
        lfu.add(5,5);
        assertArrayEquals(new int[][]{{3,1,5,4,2},{2,1,0,0,0}}, lfu.getAll());
        lfu.add(6,6);
        assertArrayEquals(new int[][]{{3,1,6,5,4},{2,1,0,0,0}}, lfu.getAll());
        assertEquals(4, lfu.get(4));
        assertArrayEquals(new int[][]{{3,4,1,6,5},{2,1,1,0,0}}, lfu.getAll());
        lfu.add(7,7);
        assertArrayEquals(new int[][]{{3,4,1,7,6},{2,1,1,0,0}}, lfu.getAll());
        assertEquals(7, lfu.get(7));
        assertArrayEquals(new int[][]{{3,7,4,1,6},{2,1,1,1,0}}, lfu.getAll());
        assertEquals(6, lfu.get(6));
        assertArrayEquals(new int[][]{{3,6,7,4,1},{2,1,1,1,1}}, lfu.getAll());
        assertEquals(6, lfu.get(6));
        assertArrayEquals(new int[][]{{6,3,7,4,1},{2,2,1,1,1}}, lfu.getAll());
        assertEquals(6, lfu.get(6));
        assertArrayEquals(new int[][]{{6,3,7,4,1},{3,2,1,1,1}}, lfu.getAll());
        lfu.add(8,8);
        assertArrayEquals(new int[][]{{6,3,7,4,8},{3,2,1,1,0}}, lfu.getAll());
    }
}
