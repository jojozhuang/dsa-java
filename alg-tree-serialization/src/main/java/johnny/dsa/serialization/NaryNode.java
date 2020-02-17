package johnny.dsa.serialization;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryNode {
    public int val;
    public List<NaryNode> children;

    public NaryNode() {
    }

    public NaryNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    public NaryNode(int val, List<NaryNode> children) {
        this.val = val;
        this.children = children;
    }

    // str = "1,2,2,0,3,0"
    public static NaryNode createInstance(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        String[] arr = str.split(",");
        return createInstance(arr);

    }

    // arr = new String[] {"1","2","2","0","3","0"}
    public static NaryNode createInstance(String[] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }

        Queue<String> queue = new LinkedList<>();
        for (String val: arr) {
            queue.offer(val);
        }
        return helper(queue);
    }

    private static NaryNode helper(Queue<String> queue){
        NaryNode root = new NaryNode();
        root.val = Integer.parseInt(queue.poll());
        int size = Integer.parseInt(queue.poll());
        root.children = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            root.children.add(helper(queue));
        }
        return root;
    }

    public static boolean isSame(NaryNode n1, NaryNode n2) {
        boolean res = isSamePrint(n1, n2);
        if (!res) {
            println("Expect NaryNode:");
            print(n1);
            println("");
            println("Actual NaryNode:");
            print(n2);
        }
        return res;
    }

    private static boolean isSamePrint(NaryNode n1, NaryNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null && n2 != null) {
            return false;
        }
        if (n1 != null && n2 == null) {
            return false;
        }
        if (n1.val != n2.val) {
            return false;
        }
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            boolean res = isSamePrint(n1.children.get(i), n2.children.get(i));
            if (!res) {
                return false;
            }
        }

        return true;
    }

    private static void print(NaryNode root) {
        if (root == null) {
            print("");
        }

        print(root.val + "," + root.children.size() + ",");
        for (NaryNode nn : root.children) {
            print(nn);
        }
    }

    private static void println(String msg) {
        System.out.println(msg);
    }
    private static void print(String msg) {
        System.out.print(msg);
    }
}
