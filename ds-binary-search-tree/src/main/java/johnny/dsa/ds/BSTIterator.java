package johnny.dsa.ds;

import java.util.Stack;

public class BSTIterator {
    private Stack<BSTNode> stack = new Stack<BSTNode>();
    private BSTNode curr;
    public BSTIterator(BSTNode root) {
        curr = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (curr != null || !stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        
        curr = stack.pop();
        int res = curr.val;
        curr = curr.right;
        return res;
    }
}
