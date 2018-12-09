package johnny.dsa.unionfind.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import johnny.dsa.unionfind.DisjointSet;

public class DisjointSetTest {

    @Test
    public void testUnionFind() {
        System.out.println("testUnionFind");
        DisjointSet djs = new DisjointSet(5); // parents = [0,1,2,3,4]
        // set 2 as parent of 0
        djs.union(0, 2); // parents = [2,1,2,3,4]
        // set 2 as parent of 4
        djs.union(4, 2); // parents = [2,1,2,3,2]
        // set 1 as parent of 3
        djs.union(3, 1); // parents = [2,1,2,1,2]
 
        // Subset1 = {0,2,4}
        // Subset2 = {1,3}
        // Check if 0 and 4 are in the same subset.
        if(djs.find(0) == djs.find(4)) {
            System.out.println("Yes");
        }
        assertEquals(djs.find(0), djs.find(4));
        // Check if 0 and 1 are in the same subset.
        if(djs.find(0) != djs.find(1)) {
            System.out.println("No");
        }
        assertNotEquals(djs.find(0), djs.find(1));
    }
}
