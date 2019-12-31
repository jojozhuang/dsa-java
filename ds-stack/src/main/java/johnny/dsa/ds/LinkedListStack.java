package johnny.dsa.ds;

public class LinkedListStack {
    private ListNode head; // the head node

    public LinkedListStack() {
        head = null;
    }

    // Add item to the list, let head point to the new node
    public void push(int value) {
        ListNode oldHead = head;
        head = new ListNode(value);
        head.next = oldHead;
    }

    // Remove the head item from the list and return its value
    public int pop() throws Exception {
        if (head == null) {
            throw new Exception();
        }
        int value = head.val;
        head = head.next;
        return value;
    }

    // Get the value of the head item
    public int peek() throws Exception {
        if (head == null) {
            throw new Exception();
        }
        return head.val;
    }

    // Return whether the list is empty
    public boolean isEmpty() {
        return head == null;
    }
}
