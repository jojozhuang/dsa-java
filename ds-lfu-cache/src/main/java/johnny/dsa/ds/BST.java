package johnny.dsa.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BST {
    class BSTNode {
        public int count;
        public BSTNode left, right, parent;
        public Deque deque;

        public BSTNode(int count, int key) {
            this.count = count;
            this.deque = new Deque();
            this.deque.addFirst(key);
        }
    }
    
    private int capacity;
    private BSTNode root;
    private Map<Integer, Integer> values; // key, value
    private Map<Integer, Integer> counts; // key, count
    private int size;                     // total number of all values
    private int node_size;                // total number of nodes, =< size
    
    public BST(int capacity) {
        this.capacity = capacity;
        this.root = null;
        this.values = new HashMap<>();
        this.counts = new HashMap<>();
        this.size = 0;
        this.node_size = 0;
    }
    /*
     * remove the element which has smallest count and is least recently accessed
     */
    public void removeMin() {
        BSTNode current = root;
        while ( current != null && current.left != null) {
            current = current.left;
        }
        Deque deque =  current.deque;
        counts.remove(deque.last());
        if (deque.size() == 1) {
            // remove the entire node
            current.parent.left = null;
            node_size--;
        } else {
            // remove the last element
            deque.removeLast();
        }
        size--;
    }
    
    public void add(int count, int key, int value) {
        if (size == capacity) {
            removeMin();
        }
        this.size++;
        this.counts.put(key, 0);
        this.values.put(key, value);
        insert(count, key);
    }
    
    private void insert(int count, int key) {
        BSTNode newNode = new BSTNode(count, key);
        if (root == null) {
            this.node_size++;
            root = newNode;
            return;
        }
        BSTNode current = root;
        while (true) {
            if (count < current.count) {
                if (current.left == null) {
                    newNode.parent = current;
                    current.left = newNode;
                    this.node_size++;
                    return;
                }
                current = current.left;
            } else if (count > current.count) {
                if (current.right == null) {
                    newNode.parent = current;
                    current.right = newNode;
                    this.node_size++;
                    return;
                }
                current = current.right;
            } else {
                // if node exists, just add new element to the head
                Deque deque = current.deque;
                deque.addFirst(key);
                return;
            }
        }
    }
    
    public int get(int key) {
        BSTNode current = root;
        int count = counts.get(key);
        int height = 0;
        while (current != null) {
            height++;
            if (current.count == count) {
                break;
            } else if (current.count > count) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        
        // not found
        if (current == null) {
            return Integer.MAX_VALUE;
        }
        
        Deque deque =  current.deque;
        // remove the key
        deque.remove(key);
        // remove node if no element left in the deque
        if (deque.size() == 0) {
            if (current.parent.left != null && current.parent.left == current) {
                delete(current, current.parent, true);
            } else {
                delete(current, current.parent, false);
            }
            node_size--;
        }
        // update count
        count++;
        counts.put(key, count);
        // insert new element to bst
        insert(count, key);
        
        // rebalance
        if (node_size > 2 && height > log2(node_size)) {
            root = rebalanceBST(root);
        }
        // return
        return values.get(key);
    }
    
    private int log2(int n){
        if(n <= 0) throw new IllegalArgumentException();
        return 31 - Integer.numberOfLeadingZeros(n);
    }
    
    public boolean delete(BSTNode current, BSTNode parent, boolean isLeftChild) {
        //Case 1: if node to be deleted has no children(leaf)
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        //Case 2 : if node to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if(isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        }
        else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }
        //Case 3 : if node to be deleted has two children
        else if (current.left != null && current.right != null){
            //now we have found the minimum element in the right sub tree
            BSTNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            }else{
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }
    
    private BSTNode getSuccessor(BSTNode deleleNode) {
        BSTNode successsor =null;
        BSTNode successsorParent =null;
        BSTNode current = deleleNode.right;
        while (current != null){
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
        //      successsorParent
        if (successsor != deleleNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }
    
    public int size() {
        return this.size;
    }
    
    // rebalance bst
    private BSTNode rebalanceBST(BSTNode root) {
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
        if (root.left != null) {
            root.left.parent = root;
        }
        root.right = sortedListToBST(list, mid + 1, end);
        if (root.right != null) {
            root.right.parent = root;
        }
        
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
    
    // for testing
    public int[][] getAll() {
        int[][] res = new int[2][this.size];

        List<BSTNode> list = inorder(this.root);
        int index = 0;
        for (int i = list.size() - 1; i >=0; i--) {
            Deque deque = list.get(i).deque;
            List<Integer> keys = deque.getKeys();
            for (int j = 0; j < keys.size(); j++) {
                res[0][index] = values.get(keys.get(j));
                res[1][index] = list.get(i).count;
                index++;
            }
        }
        return res;
    }

}
