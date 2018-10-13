package johnny.dsa.tree;

import java.util.ArrayList;
import java.util.List;

import johnny.dsa.common.TreeNode;

public class BinaryTreeDivideConquer {
    // pre-order, Divide Conquer
    public List<Integer> preorderDivideConquer(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        // divide
        List<Integer> left = preorderDivideConquer(root.left);
        List<Integer> right = preorderDivideConquer(root.right);

        // conquer
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);

        return res;
    }
    
    // in-order, Divide Conquer
    public List<Integer> inorderDivideConquer(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        // divide
        List<Integer> left = inorderDivideConquer(root.left);
        List<Integer> right = inorderDivideConquer(root.right);

        // conquer
        res.addAll(left);
        res.add(root.val);
        res.addAll(right);

        return res;
    }

    // post-order, Divide Conquer
    public List<Integer> postorderDivideConquer(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if(root == null) {
            return res;
        }

        // divide
        List<Integer> left = postorderDivideConquer(root.left);
        List<Integer> right = postorderDivideConquer(root.right);

        // conquer
        res.addAll(left);
        res.addAll(right);
        res.add(root.val);

        return res;
    }
}
