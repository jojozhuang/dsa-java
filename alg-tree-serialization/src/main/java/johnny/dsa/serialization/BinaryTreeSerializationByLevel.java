package johnny.dsa.serialization;

import java.util.LinkedList;
import java.util.Queue;

// queue by level
public class BinaryTreeSerializationByLevel {
    private static final String SEPARATOR = ",";
    private static final String NULL = "#";
    // Encodes a tree to a single string.
    // Sample: 1,2,3,#,#,4,5
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(SEPARATOR);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    sb.append(node.left.val).append(SEPARATOR);
                } else {
                    sb.append(NULL).append(SEPARATOR);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    sb.append(node.right.val).append(SEPARATOR);
                } else {
                    sb.append(NULL).append(SEPARATOR);
                }

            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] values = data.split(SEPARATOR);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);

        for (int i = 1; i < values.length; i = i + 2) {
            TreeNode node = queue.poll();
            if (!values[i].equals(NULL)) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.left);
            }
            if (!values[i + 1].equals(NULL)) {
                node.right = new TreeNode(Integer.parseInt(values[i + 1]));
                queue.offer(node.right);
            }
        }

        return root;
    }
}
