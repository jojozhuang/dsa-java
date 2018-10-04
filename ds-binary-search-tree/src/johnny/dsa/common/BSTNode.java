package johnny.dsa.common;

import java.util.LinkedList;
import java.util.Queue;

public class BSTNode {
    public int val;
    public BSTNode left, right;

    public BSTNode(int value) {
        this.val = value;
    }
    
    public static BSTNode createInstance(String[] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }

        Queue<BSTNode> queue = new LinkedList<>();

        BSTNode root = new BSTNode(Integer.parseInt(arr[0]));
        queue.offer(root);

        int index = 0;
        while (index < arr.length - 1) {
            BSTNode node = queue.poll();
            if (node != null) {
                String str = arr[++index];
                if (!str.equals("#")) {
                    node.left = new BSTNode(Integer.parseInt(str));
                    queue.add(node.left);
                }
                str = arr[++index];
                if (!str.equals("#")) {
                    node.right = new BSTNode(Integer.parseInt(str));
                    queue.add(node.right);
                }
            }
        }

        return root;
    }
    
    public static boolean isSame(BSTNode t1, BSTNode t2) {
        boolean res = isSamePrint(t1, t2);
        if (!res) {
            println("Expect TreeNode:");
            print(t1);
            println("");
            println("Actual TreeNode:");
            print(t2);
        }
        return res;
    }
    
    private static boolean isSamePrint(BSTNode t1, BSTNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null && t2 != null) {
            return false;
        }
        if (t1 != null && t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        
        return isSamePrint(t1.left, t2.left) && isSamePrint(t1.right, t2.right);
    }
    private static void print(BSTNode root) {
        if (root == null) {
            print(",null");
        }
        
        Queue<BSTNode> queue = new LinkedList<BSTNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            //List<Integer> level = new ArrayList<Integer>();
            int size = queue.size(); 
            for (int i = 0; i < size; i++) {
                BSTNode node = queue.poll();
                //level.add(node.val);
                print(node.val+",");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            //res.add(level);
        }
    }
    
    private static void println(String msg) {
        System.out.println(msg);
    }
    private static void print(String msg) {
        System.out.print(msg);
    }
}
