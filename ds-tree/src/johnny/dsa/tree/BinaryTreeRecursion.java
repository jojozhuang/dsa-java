package johnny.dsa.tree;

import java.util.ArrayList;
import java.util.List;

import johnny.dsa.common.TreeNode;

public class BinaryTreeRecursion {
    // pre-order, recursive
    public List<Integer> preorderRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        preorderHelper(root, res);

        return res;
    }
    
    private void preorderHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        preorderHelper(root.left, res);
        preorderHelper(root.right, res);
    }
    

    // in-order, recursive
    public List<Integer> inorderRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        inorderHelper(root, res);

        return res;
    }
    
    private void inorderHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        inorderHelper(root.left, res);
        res.add(root.val);
        inorderHelper(root.right, res);
    }
    
    // post-order, recursive
    public List<Integer> postorderRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        postorderHelper(root, res);

        return res;
    }
    
    private void postorderHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        postorderHelper(root.left, res);
        postorderHelper(root.right, res);
        res.add(root.val);
    }
}
