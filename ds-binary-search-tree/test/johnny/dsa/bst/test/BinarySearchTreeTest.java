package johnny.dsa.bst.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.bst.BinarySearchTree;
import johnny.dsa.common.BSTNode;

public class BinarySearchTreeTest {

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
    public void testBinarySearchTree() {
        System.out.println("testBinarySearchTree");

        BSTNode root1 = BSTNode.createInstance(new String[]{"1"});
        BinarySearchTree bst = new BinarySearchTree(root1);
        assertEquals(true, bst.search(1));
        assertEquals(false, bst.search(2));

        String[] array = new String[]{"8","3","12","1","6","9","18","#","#","4","7","#","11","#","#"};
        BSTNode root2 = BSTNode.createInstance(array);
        BSTNode expect_Insert5 = BSTNode.createInstance(new String[]{"8","3","12","1","6","9","18","#","#","4","7","#","11","#","#","#","5","#","#","#","#"});
        BSTNode expect_Delete4 = BSTNode.createInstance(new String[]{"8","3","12","1","6","9","18","#","#","#","7","#","11","#","#"});
        BSTNode expect_Delete9 = BSTNode.createInstance(new String[]{"8","3","12","1","6","11","18","#","#","4","7","#","#","#","#"});
        BSTNode expect_Delete3 = BSTNode.createInstance(new String[]{"8","4","12","1","6","9","18","#","#","#","7","#","11","#","#"});
        // search
        BinarySearchTree bst2 = new BinarySearchTree(root2);
        assertEquals(true, bst2.search(1));
        assertEquals(false, bst2.search(5));
        assertEquals(true, bst2.search(7));
        assertEquals(true, bst2.search(11));
        assertEquals(false, bst2.search(13));
        assertEquals(true, bst2.search(18));
        assertEquals(false, bst2.search(20));
        // insert
        bst2.insert(5);
        assertEquals(true, bst2.search(5));
        assertTrue(BSTNode.isSame(expect_Insert5, bst2.getRoot()));
        
        // delete 4
        BSTNode root3 = BSTNode.createInstance(array);
        BinarySearchTree bst3 = new BinarySearchTree(root3);
        bst3.delete(4);
        assertEquals(false, bst3.search(4));
        assertTrue(BSTNode.isSame(expect_Delete4, bst3.getRoot()));
        
        // delete 9
        BSTNode root4 = BSTNode.createInstance(array);
        BinarySearchTree bst4 = new BinarySearchTree(root4);
        bst4.delete(9);
        assertEquals(false, bst4.search(9));
        assertTrue(BSTNode.isSame(expect_Delete9, bst4.getRoot()));
        
        // delete 3
        BSTNode root5 = BSTNode.createInstance(array);
        BinarySearchTree bst5 = new BinarySearchTree(root5);
        bst5.delete(3);
        assertEquals(false, bst5.search(3));
        assertTrue(BSTNode.isSame(expect_Delete3, bst5.getRoot()));
    }

}
