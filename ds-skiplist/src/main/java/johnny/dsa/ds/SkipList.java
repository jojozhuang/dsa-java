package johnny.dsa.ds;

import java.util.ArrayList;
import java.util.List;

public class SkipList {
    /*
     * These are starting pointers. They are always from top layer.
     */
    private SkipNode head;
    private SkipNode tail;

    public SkipList() {
        head = new SkipNode(Integer.MIN_VALUE);
        tail = new SkipNode(Integer.MAX_VALUE);

        head.right = tail;
        tail.left = head;
    }

    public SkipNode search(int val) {
        SkipNode curr = head;

        while (curr != null) {
            while (curr.right != null && curr.right.val <= val ) {
                curr = curr.right;
            }

            if (curr.val == val) {
                break;
            }

            curr = curr.down;
        }

        return curr;
    }

    public boolean insert(int data) {
        List<SkipNode> pointersToUpdate = new ArrayList<>();

        SkipNode curr = head;
        while (curr != null) {
            while (curr.right != null && curr.right.val < data ) {
                curr = curr.right;
            }

            pointersToUpdate.add(curr);
            curr = curr.down;
        }

        // insert after this node.
        int level = 0;
        SkipNode newNode = null;

        while (level == 0 || flipCoin()) {
            // now move up.
            if (newNode == null) {
                newNode = new SkipNode(data);
            } else {
                newNode = new SkipNode(newNode);
            }

            SkipNode nodeToUpdate;

            if (pointersToUpdate.size() <= level) {
                createNewLayer();
                nodeToUpdate = this.head;
            } else {
                nodeToUpdate = pointersToUpdate.get(pointersToUpdate.size() - level - 1);
            }

            // insert
            newNode.right = nodeToUpdate.right;
            newNode.left = nodeToUpdate;

            newNode.right.left = newNode;
            nodeToUpdate.right = newNode;

            level++;
        }

        return true;
    }

    public boolean delete(int data) {
        List<SkipNode> pointersToUpdate = new ArrayList<>();

        SkipNode curr = this.head;
        while (curr != null) {
            while (curr.right != null && curr.right.val < data ) {
                curr = curr.right;
            }

            if (curr.right.val == data) {
                pointersToUpdate.add(curr);
            }

            curr = curr.down;
        }

        for (int i = 0; i < pointersToUpdate.size(); i++) {
            SkipNode nodeToUpdate = pointersToUpdate.get(i);
            SkipNode nodeToDelete = nodeToUpdate.right;

            nodeToUpdate.right = nodeToDelete.right;
            nodeToDelete.right.left = nodeToUpdate;

            nodeToDelete.up = null;
            nodeToDelete.down = null;
        }

        return true;
    }

    private void createNewLayer() {
        SkipNode newHead = new SkipNode(Integer.MIN_VALUE);
        SkipNode newTail = new SkipNode(Integer.MAX_VALUE);

        newHead.right = newTail;
        newTail.left = newHead;

        head.up = newHead;
        newHead.down = head;
        head = newHead;

        tail.up = newTail;
        newTail.down = tail;
        tail = newTail;
    }

    private boolean flipCoin() {
        return Math.random() >= 0.5;
    }

    public void print() {
        SkipNode curr = this.head;

        while (curr.down != null) {
            curr = curr.down;
        }

        curr = curr.right;

        while (curr.right != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }

        System.out.println();
    }

    public void printAllLevel() {
        SkipNode curr = this.head;

        while (curr != null) {
            SkipNode firstInLevel = curr;
            firstInLevel = firstInLevel.right;

            while (firstInLevel.right != null) {
                System.out.print(firstInLevel.val + " ");
                firstInLevel = firstInLevel.right;
            }

            curr = curr.down;
            System.out.println();
        }
    }
}
