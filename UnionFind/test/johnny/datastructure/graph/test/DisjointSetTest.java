package johnny.datastructure.graph.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.datastructure.graph.DisjointSet;

public class DisjointSetTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

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
