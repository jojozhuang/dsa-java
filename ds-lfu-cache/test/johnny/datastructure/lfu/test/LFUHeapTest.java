package johnny.datastructure.lfu.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import johnny.dsa.lfu.LFUHeap;

public class LFUHeapTest {

    @Test
    public void testLFUCache_Heap() {
        System.out.println("testLFUCache_Heap");
        LFUHeap lfu = new LFUHeap(5); //capacity = 5
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
