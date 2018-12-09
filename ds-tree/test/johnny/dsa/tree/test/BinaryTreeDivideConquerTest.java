package johnny.dsa.tree.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import johnny.dsa.common.ListUtil;
import johnny.dsa.common.TreeNode;
import johnny.dsa.tree.BinaryTreeRecursion;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeDivideConquerTest {

    @Test
    public void testPreorderRecursion() {
        System.out.println("testPreorderRecursion");
        BinaryTreeRecursion bt = new BinaryTreeRecursion();

        TreeNode root1 = null;
        List<Integer> result1 = bt.preorderRecursion(root1);
        List<Integer> expect1 = new ArrayList<Integer>();
        assertEquals(expect1, result1);

        TreeNode root2 = TreeNode.createInstance(new String[]{"1"});
        List<Integer> result2 = bt.preorderRecursion(root2);
        List<Integer> expect2 = ListUtil.buildList(new Integer[]{1});
        assertEquals(expect2, result2);

        TreeNode root3 = TreeNode.createInstance(new String[]{"1","2","3"});
        List<Integer> result3 = bt.preorderRecursion(root3);
        List<Integer> expect3 = ListUtil.buildList(new Integer[]{1,2,3});
        assertEquals(expect3, result3);

        TreeNode root4 = TreeNode.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> result4 = bt.preorderRecursion(root4);
        List<Integer> expect4 = ListUtil.buildList(new Integer[]{1,2,3});
        assertEquals(expect4, result4);
    }

    @Test
    public void testInorderRecursion() {
        System.out.println("testInorderRecursion");
        BinaryTreeRecursion bt = new BinaryTreeRecursion();

        TreeNode root1 = null;
        List<Integer> result1 = bt.inorderRecursion(root1);
        List<Integer> expect1 = new ArrayList<Integer>();
        assertEquals(expect1, result1);

        TreeNode root2 = TreeNode.createInstance(new String[]{"1"});
        List<Integer> result2 = bt.inorderRecursion(root2);
        List<Integer> expect2 = ListUtil.buildList(new Integer[]{1});
        assertEquals(expect2, result2);

        TreeNode root3 = TreeNode.createInstance(new String[]{"1","2","3"});
        List<Integer> result3 = bt.inorderRecursion(root3);
        List<Integer> expect3 = ListUtil.buildList(new Integer[]{2,1,3});
        assertEquals(expect3, result3);

        TreeNode root4 = TreeNode.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> result4 = bt.inorderRecursion(root4);
        List<Integer> expect4 = ListUtil.buildList(new Integer[]{1,3,2});
        assertEquals(expect4, result4);
    }

    @Test
    public void testPostorderRecursion() {
        System.out.println("testPostorderRecursion");
        BinaryTreeRecursion bt = new BinaryTreeRecursion();

        TreeNode root1 = null;
        List<Integer> result1 = bt.postorderRecursion(root1);
        List<Integer> expect1 = new ArrayList<Integer>();
        assertEquals(expect1, result1);

        TreeNode root2 = TreeNode.createInstance(new String[]{"1"});
        List<Integer> result2 = bt.postorderRecursion(root2);
        List<Integer> expect2 = ListUtil.buildList(new Integer[]{1});
        assertEquals(expect2, result2);

        TreeNode root3 = TreeNode.createInstance(new String[]{"1","2","3"});
        List<Integer> result3 = bt.postorderRecursion(root3);
        List<Integer> expect3 = ListUtil.buildList(new Integer[]{2,3,1});
        assertEquals(expect3, result3);

        TreeNode root4 = TreeNode.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> result4 = bt.postorderRecursion(root4);
        List<Integer> expect4 = ListUtil.buildList(new Integer[]{3,2,1});
        assertEquals(expect4, result4);
    }

}
