package johnny.dsa.unionfind.test;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import johnny.dsa.unionfind.DSURank;

public class DSURankTest {

    @Test
    public void testUnionFind() {
        System.out.println("testUnionFind");
        DSURank dsur = new DSURank(5); // parents = [0,1,2,3,4]
        // set 2 as parent of 0
        dsur.union(0, 2); // parents = [2,1,2,3,4]
        // set 2 as parent of 4
        dsur.union(4, 2); // parents = [2,1,2,3,2]
        // set 1 as parent of 3
        dsur.union(3, 1); // parents = [2,1,2,1,2]

        // Group1 = {0,2,4}
        // Group2 = {1,3}
        // Check if 0 and 4 are in the same group.
        if(dsur.find(0) == dsur.find(4)) {
            System.out.println("Yes");
        }
        assertEquals(dsur.find(0), dsur.find(4));
        // Check if 0 and 1 are in the same group.
        if(dsur.find(0) != dsur.find(1)) {
            System.out.println("No");
        }
        assertNotEquals(dsur.find(0), dsur.find(1));
    }

    @Test
    public void testPathCompression() {
        System.out.println("testPathCompression");

        DSURank dsur = new DSURank(5); // parents = [0,1,2,3,4]
        dsur.union(0, 1); // parents = [1,1,2,3,4]
        dsur.union(1, 2); // parents = [1,2,2,3,4]
        dsur.union(2, 3); // parents = [1,2,3,3,4]
        // Group1 = {0,1,2,3}
        // Group2 = {4}
        System.out.println(Arrays.toString(dsur.parents));
        System.out.println(Arrays.toString(dsur.rank));
        assertArrayEquals(new int[] {1,1,1,1,4}, dsur.parents);
        assertArrayEquals(new int[] {0,1,0,0,0}, dsur.rank);
    }
}
