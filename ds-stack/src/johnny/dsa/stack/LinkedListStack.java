package johnny.dsa.stack;

import johnny.dsa.common.ListNode;

public class LinkedListStack {
    private ListNode head; // the first node

    public LinkedListStack() {
        head = null;
    }

    // Add item to the head of the list
    public void push(int value) {
        ListNode oldHead = head;
        head = new ListNode(value);
        head.next = oldHead;
    }

    // Remove the first item from the list and return its value
    public int pop() throws Exception {
        if (head == null) {
            throw new Exception();
        }
        int value = head.val;
        head = head.next;
        return value;
    }

    // Get the value of the first item
    public int peek() throws Exception {
        if (head == null) {
            throw new Exception();
        }
        return head.val;
    }

    // Return whether the stack is empty
    public boolean isEmpty() {
        return head == null;
    }
}
