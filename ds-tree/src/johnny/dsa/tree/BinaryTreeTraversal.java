package johnny.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import johnny.dsa.common.TreeNode;

public class BinaryTreeTraversal {
    /**
     * @param root, the root node of a tree
     * @return list of the values from the tree nodes in pre-order
     */
    public List<Integer> preorderRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        List<Integer> left = preorderRecursion(root.left);
        List<Integer> right = preorderRecursion(root.right);

        res.add(root.val);
        res.addAll(left);
        res.addAll(right);

        return res;
    }
    

    /**
     * @param root, the root node of a tree
     * @return list of the values from the tree nodes in in-order
     */
    public List<Integer> inorderRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        List<Integer> left = inorderRecursion(root.left);
        List<Integer> right = inorderRecursion(root.right);

        res.addAll(left);
        res.add(root.val);
        res.addAll(right);

        return res;
    }

    /**
     * @param root, the root node of a tree
     * @return list of the values from the tree nodes in post-order
     */
    public List<Integer> postorderRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if(root == null) {
            return res;
        }

        List<Integer> left = postorderRecursion(root.left);
        List<Integer> right = postorderRecursion(root.right);

        res.addAll(left);
        res.addAll(right);
        res.add(root.val);

        return res;
    }

    /**
     * @param root, the root node of a tree
     * @return list of the values from the tree nodes in pre-order
     */
    public List<Integer> preorderIteration(TreeNode root) {
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

    /**
     * @param root, the root node of a tree
     * @return list of the values from the tree nodes in in-order
     */
    public List<Integer> inorderIteration(TreeNode root) {
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

    /**
     * @param root, the root node of a tree
     * @return list of the values from the tree nodes in post-order
     */
    public List<Integer> postorderIteration(TreeNode root) {
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

    /**
     * @param root, the root node of a tree
     * @return list of the values from the tree nodes in level order
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }

        return res;
    }
}
