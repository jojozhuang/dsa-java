package johnny.datastructure.tree.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.datastructure.common.ListUtil;
import johnny.datastructure.common.TreeFactory;
import johnny.datastructure.common.TreeNode;
import johnny.datastructure.tree.BinaryTreeTemplate;

public class BinaryTreeTemplateTest {

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
    public void testPreorderTraversal() {
        System.out.println("testPreorderTraversal");
        BinaryTreeTemplate bttObj = new BinaryTreeTemplate();
        
        TreeNode root = null;
        List<Integer> expResult = new ArrayList<Integer>();
        List<Integer> result = bttObj.preorderTraversal(root);
        assertEquals(expResult, result);

        TreeNode root1 = TreeFactory.createInstance(new String[]{"1"});
        List<Integer> expect1 = ListUtil.buildIntegerList(new Integer[]{1});
        List<Integer> result1 = bttObj.preorderTraversal(root1);
        assertEquals(expect1, result1);

        TreeNode root2 = TreeFactory.createInstance(new String[]{"1","2","3"});
        List<Integer> expect2 = ListUtil.buildIntegerList(new Integer[]{1,2,3});
        List<Integer> result2 = bttObj.preorderTraversal(root2);
        assertEquals(expect2, result2);

        TreeNode root3 = TreeFactory.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> expect3 = ListUtil.buildIntegerList(new Integer[]{1,2,3});
        List<Integer> result3 = bttObj.preorderTraversal(root3);
        assertEquals(expect3, result3);
    }

    @Test
    public void testInorderTraversal() {
        System.out.println("testInorderTraversal");
        BinaryTreeTemplate bttObj = new BinaryTreeTemplate();
        
        TreeNode root = null;
        List<Integer> expResult = new ArrayList<Integer>();
        List<Integer> result = bttObj.inorderTraversal(root);
        assertEquals(expResult, result);

        TreeNode root1 = TreeFactory.createInstance(new String[]{"1"});
        List<Integer> result1 = bttObj.inorderTraversal(root1);
        List<Integer> expect1 = ListUtil.buildIntegerList(new Integer[]{1});
        assertEquals(expect1, result1);

        TreeNode root2 = TreeFactory.createInstance(new String[]{"1","2","3"});
        List<Integer> expect2 = ListUtil.buildIntegerList(new Integer[]{2,1,3});
        List<Integer> result2 = bttObj.inorderTraversal(root2);
        assertEquals(expect2, result2);

        TreeNode root3 = TreeFactory.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> expect3 = ListUtil.buildIntegerList(new Integer[]{1,3,2});
        List<Integer> result3 = bttObj.inorderTraversal(root3);
        assertEquals(expect3, result3);
    }

    @Test
    public void testPostorderTraversal() {
        System.out.println("testPostorderTraversal");
        BinaryTreeTemplate bttObj = new BinaryTreeTemplate();

        TreeNode root = null;
        List<Integer> expResult = new ArrayList<Integer>();
        List<Integer> result = bttObj.postorderTraversal(root);
        assertEquals(expResult, result);

        TreeNode root1 = TreeFactory.createInstance(new String[]{"1"});
        List<Integer> expect1 = ListUtil.buildIntegerList(new Integer[]{1});
        List<Integer> result1 = bttObj.postorderTraversal(root1);
        assertEquals(expect1, result1);

        TreeNode root2 = TreeFactory.createInstance(new String[]{"1","2","3"});
        List<Integer> expect2 = ListUtil.buildIntegerList(new Integer[]{2,3,1});
        List<Integer> result2 = bttObj.postorderTraversal(root2);
        assertEquals(expect2, result2);

        TreeNode root3 = TreeFactory.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> expect3 = ListUtil.buildIntegerList(new Integer[]{3,2,1});
        List<Integer> result3 = bttObj.postorderTraversal(root3);
        assertEquals(expect3, result3);
    }
    
    @Test
    public void testPreorderTraversal2() {
        System.out.println("testPreorderTraversal2");
        BinaryTreeTemplate bttObj = new BinaryTreeTemplate();
        
        TreeNode root = null;
        List<Integer> expResult = new ArrayList<Integer>();
        List<Integer> result = bttObj.preorderTraversal2(root);
        assertEquals(expResult, result);

        TreeNode root1 = TreeFactory.createInstance(new String[]{"1"});
        List<Integer> expect1 = ListUtil.buildIntegerList(new Integer[]{1});
        List<Integer> result1 = bttObj.preorderTraversal2(root1);
        assertEquals(expect1, result1);

        TreeNode root2 = TreeFactory.createInstance(new String[]{"1","2","3"});
        List<Integer> expect2 = ListUtil.buildIntegerList(new Integer[]{1,3,2});
        List<Integer> result2 = bttObj.preorderTraversal2(root2);
        assertEquals(expect2, result2);

        TreeNode root3 = TreeFactory.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> expect3 = ListUtil.buildIntegerList(new Integer[]{1,2,3});
        List<Integer> result3 = bttObj.preorderTraversal2(root3);
        assertEquals(expect3, result3);
    }

    @Test
    public void testInorderTraversal2() {
        System.out.println("testInorderTraversal");
        BinaryTreeTemplate bttObj = new BinaryTreeTemplate();
        
        TreeNode root = null;
        List<Integer> expResult = new ArrayList<Integer>();
        List<Integer> result = bttObj.inorderTraversal2(root);
        assertEquals(expResult, result);

        TreeNode root1 = TreeFactory.createInstance(new String[]{"1"});
        List<Integer> result1 = bttObj.inorderTraversal2(root1);
        List<Integer> expect1 = ListUtil.buildIntegerList(new Integer[]{1});
        assertEquals(expect1, result1);

        TreeNode root2 = TreeFactory.createInstance(new String[]{"1","2","3"});
        List<Integer> expect2 = ListUtil.buildIntegerList(new Integer[]{3,1,2});
        List<Integer> result2 = bttObj.inorderTraversal2(root2);
        assertEquals(expect2, result2);

        TreeNode root3 = TreeFactory.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> expect3 = ListUtil.buildIntegerList(new Integer[]{2,3,1});
        List<Integer> result3 = bttObj.inorderTraversal2(root3);
        assertEquals(expect3, result3);
    }

    @Test
    public void testPostorderTraversal2() {
        System.out.println("testPostorderTraversal2");
        BinaryTreeTemplate bttObj = new BinaryTreeTemplate();

        TreeNode root = null;
        List<Integer> expResult = new ArrayList<Integer>();
        List<Integer> result = bttObj.postorderTraversal2(root);
        assertEquals(expResult, result);

        TreeNode root1 = TreeFactory.createInstance(new String[]{"1"});
        List<Integer> expect1 = ListUtil.buildIntegerList(new Integer[]{1});
        List<Integer> result1 = bttObj.postorderTraversal2(root1);
        assertEquals(expect1, result1);

        TreeNode root2 = TreeFactory.createInstance(new String[]{"1","2","3"});
        List<Integer> expect2 = ListUtil.buildIntegerList(new Integer[]{3,2,1});
        List<Integer> result2 = bttObj.postorderTraversal2(root2);
        assertEquals(expect2, result2);

        TreeNode root3 = TreeFactory.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> expect3 = ListUtil.buildIntegerList(new Integer[]{3,2,1});
        List<Integer> result3 = bttObj.postorderTraversal2(root3);
        assertEquals(expect3, result3);
    }
}