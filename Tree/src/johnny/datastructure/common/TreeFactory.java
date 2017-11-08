package johnny.datastructure.common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeFactory {
    //TreeNode root = TreeFactory.createInstance(new String[]{"1","#","3"});
    public static TreeNode createInstance(String[] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }

        Queue<TreeNode> queueNode = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queueNode.offer(root);

        int index = 0;
        while (index < arr.length - 1) {
            TreeNode node = queueNode.poll();
            if (node != null) {
                String str = arr[++index];
                if (!str.equals("#")) {
                    node.left = new TreeNode(Integer.parseInt(str));
                    queueNode.add(node.left);
                }
                str = arr[++index];
                if (!str.equals("#")) {
                    node.right = new TreeNode(Integer.parseInt(str));
                    queueNode.add(node.right);
                }             
            }
        }

        return root;
    }
}
