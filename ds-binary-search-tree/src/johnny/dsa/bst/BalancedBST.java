package johnny.dsa.bst;

import java.util.ArrayList;
import java.util.List;

import johnny.dsa.common.BSTNode;

public class BalancedBST {
    public BSTNode rebalanceBST(BSTNode root) {
        List<BSTNode> list = inorder(root);
        if (list == null || list.size() == 0) {
            return null;
        }
        
        return sortedListToBST(list, 0, list.size() - 1);
    }

    // build bst with give node list.
    private BSTNode sortedListToBST(List<BSTNode> list, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = start + (end - start) / 2;
        BSTNode root = list.get(mid);
        
        root.left = sortedListToBST(list, start, mid - 1);
        root.right = sortedListToBST(list, mid + 1, end);
        return root;
    }
    
    // get the sorted node list of bst tree
    public List<BSTNode> inorder(BSTNode root) {
        List<BSTNode> res = new ArrayList<BSTNode>();

        if (root == null) {
            return res;
        }

        List<BSTNode> left = inorder(root.left);
        List<BSTNode> right = inorder(root.right);

        res.addAll(left);
        res.add(root);
        res.addAll(right);

        return res;
    }
}
