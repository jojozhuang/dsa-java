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
        // 0 is a friend of 2
        djs.union(0, 2); // parents = [2,1,2,3,4]
        // 4 is a friend of 2
        djs.union(4, 2); // parents = [2,1,2,3,2]
        // 3 is a friend of 1
        djs.union(3, 1); // parents = [2,1,2,1,2]
 
        // G1 = {0,2,4}
        // G2 = {1,3}
        // Check if 4 is a friend of 0
        assertEquals(djs.find(4), djs.find(0));
        // Check if 1 is a friend of 0
        assertNotEquals(djs.find(1), djs.find(0));
    }
}
