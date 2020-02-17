package johnny.dsa.serialization;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeSerialization {
    private static final String SEP = ",";
    private static final String NULL = "null";

    // Encodes a tree to a single string in reversed sequence of pre-order
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return NULL;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            sb.append(root.val).append(SEP);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree, pre-order traversal
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.equals(NULL)) {
            return null;
        }
        String[] values = data.split(SEP);
        Queue<Integer> queue = new LinkedList<>();
        for (String val : values) {
            queue.offer(Integer.parseInt(val));
        }
        return helper(queue);
    }

    // some notes:
    //   5
    //  3 6
    // 2   7
    private TreeNode helper(Queue<Integer> queue) { //q: 5,3,2,6,7
        if (queue.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(queue.poll()); // root (5)
        Queue<Integer> samllerQueue = new LinkedList<>();
        while (!queue.isEmpty() && queue.peek() < root.val) {
            samllerQueue.offer(queue.poll());
        }
        //smallerQueue : 3,2   storing elements smaller than 5 (root)
        root.left = helper(samllerQueue);
        //q: 6,7   storing elements bigger than 5 (root)
        root.right = helper(queue);
        return root;
    }
}
