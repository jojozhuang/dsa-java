package johnny.dsa.tree.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.common.ListUtil;
import johnny.dsa.common.TreeNode;
import johnny.dsa.tree.BinaryTreeLevelOrder;

public class BinaryTreeLevelOrderTest {

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
    public void testLevelOrder() {
        System.out.println("testLevelOrder");
        BinaryTreeLevelOrder bt = new BinaryTreeLevelOrder();

        TreeNode root1 = null;
        List<List<Integer>> result1 = bt.levelOrder(root1);
        List<List<Integer>> expect1 = new ArrayList<List<Integer>>();
        assertEquals(expect1, result1);
        
        TreeNode root2 = new TreeNode(1);
        List<List<Integer>> result2 = bt.levelOrder(root2);
        List<List<Integer>> expect2 = ListUtil.buildList2(new Integer[][] {{1}});
        assertEquals(expect2, result2);

        TreeNode root3 = TreeNode.createInstance(new String[] {"1","2","#"});
        List<List<Integer>> result3 = bt.levelOrder(root3);
        List<List<Integer>> expect3 = ListUtil.buildList2(new Integer[][] {{1},{2}});
        assertEquals(expect3, result3);

        TreeNode root4 = TreeNode.createInstance(new String[] {"1","2","3"});
        List<List<Integer>> result4 = bt.levelOrder(root4);
        List<List<Integer>> expect4 = ListUtil.buildList2(new Integer[][] {{1},{2,3}});
        assertEquals(expect4, result4);

        TreeNode root5 = TreeNode.createInstance(new String[] {"1","#","3","#","5"});
        List<List<Integer>> result5 = bt.levelOrder(root5);
        List<List<Integer>> expect5 = ListUtil.buildList2(new Integer[][] {{1},{3},{5}});
        assertEquals(expect5, result5);

        TreeNode root6 = TreeNode.createInstance(new String[] {"3","9","20","#","#","15","7"});
        List<List<Integer>> result6 = bt.levelOrder(root6);
        List<List<Integer>> expect6 = ListUtil.buildList2(new Integer[][] {{3},{9,20},{15,7}});
        assertEquals(expect6, result6);
    }

}
