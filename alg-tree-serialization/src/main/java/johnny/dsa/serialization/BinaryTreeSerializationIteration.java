package johnny.dsa.serialization;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Scan with pre-order (Iteration)
 *
 * Serialize the following tree to: "1,2,#,#,3,4,5".
 *
 *    1
 *  /  \
 * 2    3
 *     / \
 *    4   5
 *
 * Limitation: Value can't be Integer.MAX_VALUE.
 */
public class BinaryTreeSerializationIteration {
    private static final String SEPARATOR = ",";
    private static final String NULL = "#";

    // Encodes a tree to a single string.
    // Sample: 1,2,#,#,3,4,5
    // Iteration with explicit stack.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val == Integer.MAX_VALUE) {
                sb.append(NULL).append(SEPARATOR);
            } else {
                sb.append(node.val).append(SEPARATOR);
                if (node.right == null) {
                    // use Integer.MAX_VALUE for null
                    stack.push(new TreeNode(Integer.MAX_VALUE));
                } else {
                    stack.push(node.right);
                }
                if (node.left == null) {
                    // use Integer.MAX_VALUE for null
                    stack.push(new TreeNode(Integer.MAX_VALUE));
                } else {
                    stack.push(node.left);
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    // Recursion + Queue.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] values = data.split(SEPARATOR);
        Queue<String> queue = new LinkedList<>();
        for (String s : values) {
            queue.offer(s);
        }
        TreeNode root = helper(queue);

        return root;
    }

    // pre-order
    private TreeNode helper(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }

        String val = queue.poll();
        if (val.equals(NULL)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = helper(queue);
        root.right = helper(queue);

        return root;
    }
}
