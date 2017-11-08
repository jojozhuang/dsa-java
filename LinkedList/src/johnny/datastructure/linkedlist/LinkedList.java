package johnny.datastructure.linkedlist;

import johnny.datastructure.common.ListNode;

public class LinkedList {
    /**
     * @param head of the original linked list
     * @return reversed linked list
     * 
     * Sample
     * Input:  7->3->12->8->4->9
     * Output: 9->4->8->12->3->7
     * 
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * @param head of the original linked list
     * @return middle node of the linked list
     * 
     * Sample
     * Input:  7->3->12->8->4
     * Output: 12
     * Input:  7->3->12->8->4->9
     * Output: 12
     * 
     */
    public ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        // define fast and slow pointers
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // two steps for each pace
            slow = slow.next;      // one step for each pace
        }

        return slow;
    }

    /**
     * @param head of the original linked list
     * @return middle node of the linked list
     * 
     * Sample
     * Input:  7->3->12->8->4->9
     * Output: false
     * Input:  7->3->12->8->4->9->12
     * Output: true (12->8->4->9->12 is the loop)
     * 
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = new ListNode(0);
        fast.next = head;
        ListNode slow = new ListNode(1);
        slow.next = head;

        while (fast != null) {
            if (fast.next == null) {
                return false;
            } else {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) { // Compare object, not its value. Nodes with same value may exist.
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * @param head of the original linked list
     * @return middle node of the linked list
     * 
     * Sample
     * Input:  7->3->12->8->4->9->12
     * Output: 12
     * Input:  7->3->12->8->4
     * Output: null
     * 
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }

        return null;
    }
}

