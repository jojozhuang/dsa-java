package johnny.datastructure.queue;

import johnny.datastructure.common.ListNode;

public class LinkedListQueue {
    private ListNode head; // the first node
    private ListNode tail; // the last node

    public LinkedListQueue() {
        head = null;
        tail = null;
    }

    // Add item to the tail of the list
    public void enqueue(int value) {
        if (tail == null) {
            tail = new ListNode(value);
            head = tail;
        } else {
            tail.next = new ListNode(value);
            tail = tail.next;
        }
    }

    // Remove the head from the list and return its value
    public int dequeue() throws Exception {
        if (head == null) {
            throw new Exception();
        }
        int value = head.val;
        head = head.next;
        return value;
    }

    // Get the value of the head
    public int peek() throws Exception {
        if (head == null) {
            throw new Exception();
        }
        return head.val;
    }

    // Return whether the queue is empty
    public boolean isEmpty() {
        return head == null;
    }
}
