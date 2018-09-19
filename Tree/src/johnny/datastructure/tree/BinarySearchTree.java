package johnny.datastructure.tree;

import johnny.datastructure.common.BSTNode;

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
        while( current != null) {
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
        BSTNode parent = null;
        while (true) {
            parent = current;
            if (val < current.val) {
                current = current.left;
                if (current == null){
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
    
    public boolean delete(int val) {
        BSTNode parent = root;
        BSTNode current = root;
        boolean isLeftChild = false;
        
        while (current.val != val){
            parent = current;
            if (current.val > val){
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        
        //if i am here that means we have found the node
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
}
