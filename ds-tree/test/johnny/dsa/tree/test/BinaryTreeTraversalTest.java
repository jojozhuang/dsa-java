package johnny.dsa.tree.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import johnny.dsa.common.ListUtil;
import johnny.dsa.common.TreeNode;
import johnny.dsa.tree.BinaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversalTest {

    @Test
    public void testPreorderTraversal() {
        System.out.println("testPreorderTraversal");
        BinaryTreeTraversal bt = new BinaryTreeTraversal();

        TreeNode root1 = null;
        List<Integer> result1 = bt.preorderTraversal(root1);
        List<Integer> expect1 = new ArrayList<Integer>();
        assertEquals(expect1, result1);

        TreeNode root2 = TreeNode.createInstance(new String[]{"1"});
        List<Integer> result2 = bt.preorderTraversal(root2);
        List<Integer> expect2 = ListUtil.buildList(new Integer[]{1});
        assertEquals(expect2, result2);

        TreeNode root3 = TreeNode.createInstance(new String[]{"1","2","3"});
        List<Integer> result3 = bt.preorderTraversal(root3);
        List<Integer> expect3 = ListUtil.buildList(new Integer[]{1,2,3});
        assertEquals(expect3, result3);

        TreeNode root4 = TreeNode.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> result4 = bt.preorderTraversal(root4);
        List<Integer> expect4 = ListUtil.buildList(new Integer[]{1,2,3});
        assertEquals(expect4, result4);
    }

    @Test
    public void testInorderTraversal() {
        System.out.println("testInorderTraversal");
        BinaryTreeTraversal bt = new BinaryTreeTraversal();

        TreeNode root1 = null;
        List<Integer> result1 = bt.inorderTraversal(root1);
        List<Integer> expect1 = new ArrayList<Integer>();
        assertEquals(expect1, result1);

        TreeNode root2 = TreeNode.createInstance(new String[]{"1"});
        List<Integer> result2 = bt.inorderTraversal(root2);
        List<Integer> expect2 = ListUtil.buildList(new Integer[]{1});
        assertEquals(expect2, result2);

        TreeNode root3 = TreeNode.createInstance(new String[]{"1","2","3"});
        List<Integer> result3 = bt.inorderTraversal(root3);
        List<Integer> expect3 = ListUtil.buildList(new Integer[]{2,1,3});
        assertEquals(expect3, result3);

        TreeNode root4 = TreeNode.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> result4 = bt.inorderTraversal(root4);
        List<Integer> expect4 = ListUtil.buildList(new Integer[]{1,3,2});
        assertEquals(expect4, result4);
    }

    @Test
    public void testPostorderTraversal() {
        System.out.println("testPostorderTraversal");
        BinaryTreeTraversal bt = new BinaryTreeTraversal();

        TreeNode root1 = null;
        List<Integer> result1 = bt.postorderTraversal(root1);
        List<Integer> expect1 = new ArrayList<Integer>();
        assertEquals(expect1, result1);

        TreeNode root2 = TreeNode.createInstance(new String[]{"1"});
        List<Integer> result2 = bt.postorderTraversal(root2);
        List<Integer> expect2 = ListUtil.buildList(new Integer[]{1});
        assertEquals(expect2, result2);

        TreeNode root3 = TreeNode.createInstance(new String[]{"1","2","3"});
        List<Integer> result3 = bt.postorderTraversal(root3);
        List<Integer> expect3 = ListUtil.buildList(new Integer[]{2,3,1});
        assertEquals(expect3, result3);

        TreeNode root4 = TreeNode.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> result4 = bt.postorderTraversal(root4);
        List<Integer> expect4 = ListUtil.buildList(new Integer[]{3,2,1});
        assertEquals(expect4, result4);
    }


}
