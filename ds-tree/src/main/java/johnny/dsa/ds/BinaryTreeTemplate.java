package johnny.dsa.ds;

import java.util.*;

/*
 * We have a tree, there are totally 6 traversal ways.
 *    1
 *  /   \
 * 2     3
 */
public class BinaryTreeTemplate {
    /**
     * 1->2->3
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null) {
            if(curr != null) {
                stack.push(curr);
                res.add(curr.val);  // Add before going to children
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                curr = node.right;
            }
        }
        return res;
    }

    /**
     * 2->1->3
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                res.add(node.val);  // Add after all left children
                curr = node.right;
            }
        }
        return res;
    }
    
    /**
     * 2->3->1
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null) {
            if(curr != null) {
                stack.push(curr);
                res.addFirst(curr.val);     // Reverse the process of preorder
                curr = curr.right;          // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                curr = node.left;           // Reverse the process of preorder
            }
        }
        return res;
    }
    
    /**
     * 1->3->2
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null) {
            if(curr != null) {
                stack.push(curr);
                res.add(curr.val);  // Add before going to children
                curr = curr.right;
            } else {
                TreeNode node = stack.pop();
                curr = node.left;
            }
        }
        return res;
    }

    /**
     * 3->1->2
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.right;
            } else {
                TreeNode node = stack.pop();
                res.add(node.val);  // Add after all left children
                curr = node.left;
            }
        }
        return res;
    }
    
    /**
     * 3->2->1
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null) {
            if(curr != null) {
                stack.push(curr);
                res.addFirst(curr.val);     // Reverse the process of preorder
                curr = curr.left;          // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                curr = node.right;           // Reverse the process of preorder
            }
        }
        return res;
    }

}
