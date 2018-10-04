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
import johnny.dsa.tree.BinaryTreeTraversal;

public class BinaryTreeTraversalTest {

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
    public void testPreorderRecursion() {
        System.out.println("testPreorderRecursion");
        TreeNode root = null;
        BinaryTreeTraversal bttObj = new BinaryTreeTraversal();
        List<Integer> expResult = new ArrayList<Integer>();
        List<Integer> result = bttObj.preorderRecursion(root);
        assertEquals(expResult, result);

        TreeNode root1 = TreeNode.createInstance(new String[]{"1"});
        List<Integer> expect1 = ListUtil.buildIntegerList(new Integer[]{1});
        List<Integer> result1 = bttObj.preorderRecursion(root1);
        assertEquals(expect1, result1);

        TreeNode root2 = TreeNode.createInstance(new String[]{"1","2","3"});
        List<Integer> expect2 = ListUtil.buildIntegerList(new Integer[]{1,2,3});
        List<Integer> result2 = bttObj.preorderRecursion(root2);
        assertEquals(expect2, result2);

        TreeNode root3 = TreeNode.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> expect3 = ListUtil.buildIntegerList(new Integer[]{1,2,3});
        List<Integer> result3 = bttObj.preorderRecursion(root3);
        assertEquals(expect3, result3);
    }

    @Test
    public void testInorderRecursion() {
        System.out.println("testInorderRecursion");
        TreeNode root = null;
        BinaryTreeTraversal bttObj = new BinaryTreeTraversal();
        List<Integer> expResult = new ArrayList<Integer>();
        List<Integer> result = bttObj.inorderRecursion(root);
        assertEquals(expResult, result);

        TreeNode root1 = TreeNode.createInstance(new String[]{"1"});
        List<Integer> result1 = bttObj.inorderRecursion(root1);
        List<Integer> expect1 = ListUtil.buildIntegerList(new Integer[]{1});
        assertEquals(expect1, result1);

        TreeNode root2 = TreeNode.createInstance(new String[]{"1","2","3"});
        List<Integer> expect2 = ListUtil.buildIntegerList(new Integer[]{2,1,3});
        List<Integer> result2 = bttObj.inorderRecursion(root2);
        assertEquals(expect2, result2);

        TreeNode root3 = TreeNode.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> expect3 = ListUtil.buildIntegerList(new Integer[]{1,3,2});
        List<Integer> result3 = bttObj.inorderRecursion(root3);
        assertEquals(expect3, result3);
    }

    @Test
    public void testPostorderRecursion() {
        System.out.println("testPostorderRecursion");
        TreeNode root = null;
        BinaryTreeTraversal bttObj = new BinaryTreeTraversal();
        List<Integer> expResult = new ArrayList<Integer>();
        List<Integer> result = bttObj.postorderRecursion(root);
        assertEquals(expResult, result);

        TreeNode root1 = TreeNode.createInstance(new String[]{"1"});
        List<Integer> expect1 = ListUtil.buildIntegerList(new Integer[]{1});
        List<Integer> result1 = bttObj.postorderRecursion(root1);
        assertEquals(expect1, result1);

        TreeNode root2 = TreeNode.createInstance(new String[]{"1","2","3"});
        List<Integer> expect2 = ListUtil.buildIntegerList(new Integer[]{2,3,1});
        List<Integer> result2 = bttObj.postorderRecursion(root2);
        assertEquals(expect2, result2);

        TreeNode root3 = TreeNode.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> expect3 = ListUtil.buildIntegerList(new Integer[]{3,2,1});
        List<Integer> result3 = bttObj.postorderRecursion(root3);
        assertEquals(expect3, result3);
    }

    @Test
    public void testPreorderIteration() {
        System.out.println("testPreorderIteration");
        TreeNode root = null;
        BinaryTreeTraversal bttObj = new BinaryTreeTraversal();
        List<Integer> expResult = new ArrayList<Integer>();
        List<Integer> result = bttObj.preorderIteration(root);
        assertEquals(expResult, result);

        TreeNode root1 = TreeNode.createInstance(new String[]{"1"});
        List<Integer> expect1 = ListUtil.buildIntegerList(new Integer[]{1});
        List<Integer> result1 = bttObj.preorderIteration(root1);
        assertEquals(expect1, result1);

        TreeNode root2 = TreeNode.createInstance(new String[]{"1","2","3"});
        List<Integer> expect2 = ListUtil.buildIntegerList(new Integer[]{1,2,3});
        List<Integer> result2 = bttObj.preorderIteration(root2);
        assertEquals(expect2, result2);

        TreeNode root3 = TreeNode.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> expect3 = ListUtil.buildIntegerList(new Integer[]{1,2,3});
        List<Integer> result3 = bttObj.preorderIteration(root3);
        assertEquals(expect3, result3);

    }

    @Test
    public void testInorderIteration() {
        System.out.println("testInorderIteration");
        TreeNode root = null;
        BinaryTreeTraversal bttObj = new BinaryTreeTraversal();
        List<Integer> expResult = new ArrayList<Integer>();
        List<Integer> result = bttObj.inorderIteration(root);
        assertEquals(expResult, result);

        TreeNode root1 = TreeNode.createInstance(new String[]{"1"});
        List<Integer> result1 = bttObj.inorderIteration(root1);
        List<Integer> expect1 = ListUtil.buildIntegerList(new Integer[]{1});
        assertEquals(expect1, result1);

        TreeNode root2 = TreeNode.createInstance(new String[]{"1","2","3"});
        List<Integer> expect2 = ListUtil.buildIntegerList(new Integer[]{2,1,3});
        List<Integer> result2 = bttObj.inorderIteration(root2);
        assertEquals(expect2, result2);

        TreeNode root3 = TreeNode.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> expect3 = ListUtil.buildIntegerList(new Integer[]{1,3,2});
        List<Integer> result3 = bttObj.inorderIteration(root3);
        assertEquals(expect3, result3);
    }

    @Test
    public void testPostorderIteration() {
        System.out.println("testPostorderIteration");
        TreeNode root = null;
        BinaryTreeTraversal bttObj = new BinaryTreeTraversal();
        List<Integer> expResult = new ArrayList<Integer>();
        List<Integer> result = bttObj.postorderIteration(root);
        assertEquals(expResult, result);

        TreeNode root1 = TreeNode.createInstance(new String[]{"1"});
        List<Integer> expect1 = ListUtil.buildIntegerList(new Integer[]{1});
        List<Integer> result1 = bttObj.postorderIteration(root1);
        assertEquals(expect1, result1);

        TreeNode root2 = TreeNode.createInstance(new String[]{"1","2","3"});
        List<Integer> expect2 = ListUtil.buildIntegerList(new Integer[]{2,3,1});
        List<Integer> result2 = bttObj.postorderIteration(root2);
        assertEquals(expect2, result2);

        TreeNode root3 = TreeNode.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> expect3 = ListUtil.buildIntegerList(new Integer[]{3,2,1});
        List<Integer> result3 = bttObj.postorderIteration(root3);
        assertEquals(expect3, result3);
    }

    @Test
    public void testLevelOrder() {
        System.out.println("testLevelOrder");
        TreeNode root = null;
        BinaryTreeTraversal bttObj = new BinaryTreeTraversal();
        List<List<Integer>> expResult = new ArrayList<List<Integer>>();
        List<List<Integer>> result = bttObj.levelOrder(root);
        assertEquals(expResult, result);
        
        TreeNode p2 = new TreeNode(1);
        List<List<Integer>> ret2 = ListUtil.buildIntegerList2(new Integer[][] {{1}});
        assertEquals(ret2, bttObj.levelOrder(p2));

        TreeNode p3 = TreeNode.createInstance(new String[] {"1","2","#"});
        List<List<Integer>> ret3 = ListUtil.buildIntegerList2(new Integer[][] {{1},{2}});
        assertEquals(ret3, bttObj.levelOrder(p3));

        TreeNode p4 = TreeNode.createInstance(new String[] {"1","2","3"});
        List<List<Integer>> ret4 = ListUtil.buildIntegerList2(new Integer[][] {{1},{2,3}});
        assertEquals(ret4, bttObj.levelOrder(p4));

        TreeNode p5 = TreeNode.createInstance(new String[] {"1","#","3","#","5"});
        List<List<Integer>> ret5 = ListUtil.buildIntegerList2(new Integer[][] {{1},{3},{5}});
        assertEquals(ret5, bttObj.levelOrder(p5));

        TreeNode p6 = TreeNode.createInstance(new String[] {"3","9","20","#","#","15","7"});
        List<List<Integer>> ret6 = ListUtil.buildIntegerList2(new Integer[][] {{3},{9,20},{15,7}});
        assertEquals(ret6, bttObj.levelOrder(p6));
    }

}
