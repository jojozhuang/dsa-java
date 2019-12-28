package johnny.dsa.deque;

import johnny.dsa.common.ListNode;

public class LinkedListDeque {
    private ListNode head; // the first node
    private ListNode tail; // the last node

    public LinkedListDeque() {
        head = null;
        tail = null;
    }

    // Add item to the head of the list
    public void addFirst(int value) {
        if (head == null) {
            head = new ListNode(value);
            tail = head;
        } else {
            head.prev = new ListNode(value);
            head.prev.next = head;
            head = head.prev;
        }
    }
    
    // Remove the head from the list and return its value
    public int removeFirst() throws Exception {
        if (head == null) {
            throw new Exception();
        }
        int value = head.val;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        return value;
    }
    
    // Get the value of the head
    public int peekFirst() throws Exception {
        if (head == null) {
            throw new Exception();
        }
        return head.val;
    }
    
    // Add item to the tail of the list
    public void addLast(int value) {
        if (tail == null) {
            tail = new ListNode(value);
            head = tail;
        } else {
            tail.next = new ListNode(value);
            tail.next.prev = tail;
            tail = tail.next;
        }
    }

    // Remove the tail from the list and return its value
    public int removeLast() throws Exception {
        if (tail == null) {
            throw new Exception();
        }
        int value = tail.val;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        return value;
    }

    // Get the value of the tail
    public int peekLast() throws Exception {
        if (tail == null) {
            throw new Exception();
        }
        return tail.val;
    }

    // Return whether the deque is empty
    public boolean isEmpty() {
        return head == null || tail == null;
    }
}
