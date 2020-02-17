package johnny.dsa.serialization;

/**
 * Scan with pre-order (Recursion)
 *
 * Serialize the following tree to: "1,2,#,#,3,4,5".
 *
 *    1
 *  /  \
 * 2    3
 *     / \
 *    4   5
 *
 */
public class BinaryTreeSerializationRecursion {
    private static final String SEPARATOR = ",";
    private static final String NULL = "#";

    // Encodes a tree to a single string.
    // Sample: 1,2,#,#,3,4,5
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // pre-order
    private void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEPARATOR);
            return;
        }

        sb.append(root.val).append(SEPARATOR);
        helper(root.left, sb);
        helper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] values = data.split(SEPARATOR);
        int[] pos = new int[1];
        TreeNode root = helper(values, pos);

        return root;
    }

    // pre-order + recursion
    private TreeNode helper(String[] arr, int[] pos) {
        if (pos[0] >= arr.length) {
            return null;
        }

        String val = arr[pos[0]];
        if (val.equals(NULL)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        pos[0]++;
        root.left = helper(arr, pos);
        pos[0]++;
        root.right = helper(arr, pos);

        return root;
    }
}
