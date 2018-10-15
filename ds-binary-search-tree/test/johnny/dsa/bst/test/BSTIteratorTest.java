package johnny.dsa.bst.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.bst.BSTIterator;
import johnny.dsa.common.BSTNode;

public class BSTIteratorTest {

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
    public void testTreeIterator() {
        System.out.println("treeIterator");
        
        BSTNode root1 = new BSTNode(1);
        BSTIterator iterator1 = new BSTIterator(root1);
        assertEquals(1, iterator1.next());

        BSTNode root2 = BSTNode.createInstance(new String[] {"1","#","2","#","3"});
        BSTIterator iterator2 = new BSTIterator(root2);
        assertEquals(true, iterator2.hasNext());
        assertEquals(1, iterator2.next());
        assertEquals(2, iterator2.next());
        assertEquals(true, iterator2.hasNext());
        assertEquals(3, iterator2.next());
        assertEquals(false, iterator2.hasNext());

        BSTNode root3 = BSTNode.createInstance(new String[] {"4","2","#","1","3"});
        BSTIterator iterator3 = new BSTIterator(root3);
        assertEquals(1, iterator3.next());
        assertEquals(2, iterator3.next());
        assertEquals(3, iterator3.next());
        assertEquals(true, iterator3.hasNext());
        assertEquals(4, iterator3.next());
        assertEquals(false, iterator3.hasNext());
    }

}
