package johnny.dsa.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {
    // pre-order, traverse with stack
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return res;
    }

    // in-order, traverse with stack
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;
    }

    // post-order, traverse with stack
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left == null) {
                if (node.right != null) {
                    stack.push(node.right);
                    node.right = null;
                } else {
                    res.add(node.val);
                    stack.pop();
                }
            } else {
                if (node.right != null) {
                    stack.push(node.right);
                    node.right = null;
                }
                stack.push(node.left);
                node.left = null;
            }
        }

        return res;
    }
}
