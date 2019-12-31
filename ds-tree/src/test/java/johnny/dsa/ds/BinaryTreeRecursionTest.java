package johnny.dsa.ds;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeRecursionTest {

    @Test
    public void testPreorderDivideConquer() {
        System.out.println("testPreorderDivideConquer");
        BinaryTreeDivideConquer bt = new BinaryTreeDivideConquer();

        TreeNode root1 = null;
        List<Integer> result1 = bt.preorderDivideConquer(root1);
        List<Integer> expect1 = new ArrayList<Integer>();
        assertEquals(expect1, result1);

        TreeNode root2 = TreeNode.createInstance(new String[]{"1"});
        List<Integer> result2 = bt.preorderDivideConquer(root2);
        List<Integer> expect2 = ListUtil.buildList(new Integer[]{1});
        assertEquals(expect2, result2);

        TreeNode root3 = TreeNode.createInstance(new String[]{"1","2","3"});
        List<Integer> result3 = bt.preorderDivideConquer(root3);
        List<Integer> expect3 = ListUtil.buildList(new Integer[]{1,2,3});
        assertEquals(expect3, result3);

        TreeNode root4 = TreeNode.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> result4 = bt.preorderDivideConquer(root4);
        List<Integer> expect4 = ListUtil.buildList(new Integer[]{1,2,3});
        assertEquals(expect4, result4);
    }

    @Test
    public void testInorderDivideConquer() {
        System.out.println("testInorderDivideConquer");
        BinaryTreeDivideConquer bt = new BinaryTreeDivideConquer();

        TreeNode root1 = null;
        List<Integer> result1 = bt.inorderDivideConquer(root1);
        List<Integer> expect1 = new ArrayList<Integer>();
        assertEquals(expect1, result1);

        TreeNode root2 = TreeNode.createInstance(new String[]{"1"});
        List<Integer> result2 = bt.inorderDivideConquer(root2);
        List<Integer> expect2 = ListUtil.buildList(new Integer[]{1});
        assertEquals(expect2, result2);

        TreeNode root3 = TreeNode.createInstance(new String[]{"1","2","3"});
        List<Integer> result3 = bt.inorderDivideConquer(root3);
        List<Integer> expect3 = ListUtil.buildList(new Integer[]{2,1,3});
        assertEquals(expect3, result3);

        TreeNode root4 = TreeNode.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> result4 = bt.inorderDivideConquer(root4);
        List<Integer> expect4 = ListUtil.buildList(new Integer[]{1,3,2});
        assertEquals(expect4, result4);
    }

    @Test
    public void testPostorderDivideConquer() {
        System.out.println("testPostorderDivideConquer");
        BinaryTreeDivideConquer bt = new BinaryTreeDivideConquer();

        TreeNode root1 = null;
        List<Integer> result1 = bt.postorderDivideConquer(root1);
        List<Integer> expect1 = new ArrayList<Integer>();
        assertEquals(expect1, result1);

        TreeNode root2 = TreeNode.createInstance(new String[]{"1"});
        List<Integer> result2 = bt.postorderDivideConquer(root2);
        List<Integer> expect2 = ListUtil.buildList(new Integer[]{1});
        assertEquals(expect2, result2);

        TreeNode root3 = TreeNode.createInstance(new String[]{"1","2","3"});
        List<Integer> result3 = bt.postorderDivideConquer(root3);
        List<Integer> expect3 = ListUtil.buildList(new Integer[]{2,3,1});
        assertEquals(expect3, result3);

        TreeNode root4 = TreeNode.createInstance(new String[]{"1","#","2","3","#"});
        List<Integer> result4 = bt.postorderDivideConquer(root4);
        List<Integer> expect4 = ListUtil.buildList(new Integer[]{3,2,1});
        assertEquals(expect4, result4);
    }
}
