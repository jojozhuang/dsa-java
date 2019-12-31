package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DSUTest {

    @Test
    public void testUnionFind() {
        System.out.println("testUnionFind");
        DSU dju = new DSU(5); // parents = [0,1,2,3,4]
        // set 2 as parent of 0
        dju.union(0, 2); // parents = [2,1,2,3,4]
        // set 2 as parent of 4
        dju.union(4, 2); // parents = [2,1,2,3,2]
        // set 1 as parent of 3
        dju.union(3, 1); // parents = [2,1,2,1,2]
 
        // Group1 = {0,2,4}
        // Group2 = {1,3}
        // Check if 0 and 4 are in the same group.
        if(dju.find(0) == dju.find(4)) {
            System.out.println("Yes");
        }
        assertEquals(dju.find(0), dju.find(4));
        // Check if 0 and 1 are in the same group.
        if(dju.find(0) != dju.find(1)) {
            System.out.println("No");
        }
        assertNotEquals(dju.find(0), dju.find(1));
    }

    @Test
    public void testPathCompression() {
        System.out.println("testPathCompression");

        DSU dsu = new DSU(5); // parents = [0,1,2,3,4]
        dsu.union(0, 1); // parents = [1,1,2,3,4]
        dsu.union(1, 2); // parents = [1,2,2,3,4]
        dsu.union(2, 3); // parents = [1,2,3,3,4]
        // Group1 = {0,1,2,3}
        // Group2 = {4}
        System.out.println(Arrays.toString(dsu.parents));
        assertArrayEquals(new int[] {1,2,3,3,4}, dsu.parents);
    }
}
