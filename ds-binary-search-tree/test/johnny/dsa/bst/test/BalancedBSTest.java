package johnny.dsa.bst.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.bst.BalancedBST;
import johnny.dsa.common.BSTNode;

public class BalancedBSTest {

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
        BalancedBST bbst = new BalancedBST();
        
        BSTNode root1 = BSTNode.createInstance(new String[]{"1"});
        BSTNode sorted1 = bbst.rebalanceBST(root1);
        BSTNode expected1 = BSTNode.createInstance(new String[]{"1"});
        assertTrue(BSTNode.isSame(expected1, sorted1));

        String[] array2 = new String[]{"0","#","1","#","#"};
        BSTNode root2 = BSTNode.createInstance(array2);
        BSTNode sorted2 = bbst.rebalanceBST(root2);
        BSTNode expected2 = BSTNode.createInstance(new String[]{"0","#","1","#","#"});
        assertTrue(BSTNode.isSame(expected2, sorted2));

        String[] array3 = new String[]{"0","#","1","#","2","#","3","#","4"};
        BSTNode root3 = BSTNode.createInstance(array3);
        BSTNode sorted3 = bbst.rebalanceBST(root3);
        BSTNode expected3 = BSTNode.createInstance(new String[]{"2","0","3","#","1","#","4"});
        assertTrue(BSTNode.isSame(expected3, sorted3));
    }

}
