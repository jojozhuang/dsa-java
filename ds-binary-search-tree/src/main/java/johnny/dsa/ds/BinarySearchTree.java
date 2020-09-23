package johnny.dsa.ds;

public class BinarySearchTree {
    private BSTNode root;
    
    public BinarySearchTree(BSTNode root) {
        this.root = root;
    }
    
    public BSTNode getRoot() {
        return this.root;
    }
    
    public boolean search(int val) {
        BSTNode current = root;
        while ( current != null) {
            if (current.val == val) {
                return true;
            } else if (current.val > val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }
    
    public void insert(int val) {
        BSTNode newNode = new BSTNode(val);
        if (root == null) {
            root = newNode;
            return;
        }
        BSTNode current = root;
        while (true) {
            if (val < current.val) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }
        }
    }

    public boolean delete(int val) {
        deleteNode(root, val);
        return true;
    }

    // delete the node with the given key and return the root of the tree after deletion
    private BSTNode deleteNode(BSTNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // find min in right sub tree
            BSTNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private BSTNode findMin(BSTNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
