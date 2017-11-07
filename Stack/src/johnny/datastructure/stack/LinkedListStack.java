package johnny.datastructure.stack;

import johnny.datastructure.common.ListNode;

public class LinkedListStack {
    private ListNode head; // the first node

    public LinkedListStack() {
        head = null;
    }

    // Add element to the beginning of the list
    public void push(int value) {
        ListNode oldHead = head;
        head = new ListNode(value);
        head.next = oldHead;
    }

    // Remove value from the beginning of the list and return the value
    public int pop() throws Exception {
        if (head == null) {
            throw new Exception();
        }
        int value = head.val;
        head = head.next;
        return value;
    }

    // Get the top element
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
