package johnny.dsa.serialization;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialize N-ary tree in pre-order. Each node is represented by (value, size).
 *
 * Serialize the following tree to: "1,3,3,2,5,0,6,0,2,0,4,0".
 *
 *      1
 *    / | \
 *   3  2  4
 *  / \
 * 5   6
 *
 */
public class NaryTreeSerialization {
    private static final String SEPARATOR = ",";
    // Encodes a n-ary tree to a single string.
    // Sample: 1,3,3,2,5,0,6,0,2,0,4,0
    public String serialize(NaryNode root){
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    private void helper(NaryNode node, StringBuilder sb){
        if (node == null) {
            return;
        }
        sb.append(node.val + SEPARATOR + node.children.size() + SEPARATOR);
        for (NaryNode nn : node.children) {
            helper(nn, sb);
        }
    }

    public NaryNode deserialize(String data){
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] values = data.split(SEPARATOR);
        Queue<String> queue = new LinkedList<>();
        for (String val: values) {
            queue.offer(val);
        }
        return helper(queue);
    }

    private NaryNode helper(Queue<String> queue){
        NaryNode root = new NaryNode();
        root.val = Integer.parseInt(queue.poll());
        int size = Integer.parseInt(queue.poll());
        root.children = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            root.children.add(helper(queue));
        }
        return root;
    }
}
