package johnny.dsa.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void reverse() {
        System.out.println("reverseList");
        LinkedList llobj = new LinkedList();

        assertEquals(null, llobj.reverse(null));

        // Input: 1, return: 1
        ListNode head2 = ListNode.createInstance(new int[]{1});
        ListNode expect2 = ListNode.createInstance(new int[]{1});
        assertTrue(ListNode.isSame(expect2, llobj.reverse(head2)));

        // Input: 1 -> 2, return: 2 -> 1
        ListNode head3 = ListNode.createInstance(new int[]{1,2});
        ListNode expect3 = ListNode.createInstance(new int[]{2,1});
        assertTrue(ListNode.isSame(expect3, llobj.reverse(head3)));

        // Input: 1 -> 2 -> 3 -> 4 -> 5, return: 5 -> 4 -> 3 -> 2 -> 1
        ListNode head4 = ListNode.createInstance(new int[]{1,2,3,4,5});
        ListNode expect4 = ListNode.createInstance(new int[]{5,4,3,2,1});
        assertTrue(ListNode.isSame(expect4, llobj.reverse(head4)));
    }

    @Test
    void findMiddle() {
        System.out.println("findMiddle");
        LinkedList llobj = new LinkedList();

        assertEquals(null, llobj.findMiddle(null));

        // Input: 1, return: 1
        ListNode head2 = ListNode.createInstance(new int[]{1});
        assertEquals(head2, llobj.findMiddle(head2));

        // Input: 1 -> 2, return: 1
        ListNode head3 = ListNode.createInstance(new int[]{1,2});
        assertEquals(head3, llobj.findMiddle(head3));

        // Input: 1 -> 2 -> 3 -> 4 -> 5, return: 3
        ListNode head4 = ListNode.createInstance(new int[]{1,2,3,4,5});
        assertEquals(head4.next.next, llobj.findMiddle(head4));

        // Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6, return: 3
        ListNode head5 = ListNode.createInstance(new int[]{1,2,3,4,5,6});
        assertEquals(head5.next.next, llobj.findMiddle(head5));
    }

    @Test
    void hasCycle() {
        System.out.println("hasCycle");
        LinkedList llobj = new LinkedList();

        // Input: 1 -> 2 -> 3
        ListNode head2 = ListNode.createInstance(new int[]{1,2,3});
        assertEquals(false, llobj.hasCycle(head2));

        // Input: 1 -> 2 -> 3, 3 -> head 1
        ListNode head3 = ListNode.createInstance(new int[]{1,2,3});
        head3.next.next.next = head3;
        assertEquals(true, llobj.hasCycle(head3));
    }

    @Test
    void detectCycle() {
        System.out.println("detectCycle");
        LinkedList llobj = new LinkedList();

        //Input: 1 -> 2 -> 3
        ListNode head2 = ListNode.createInstance(new int[]{1,2,3});
        assertEquals(null, llobj.detectCycle(head2));

        //Input: 1 -> 2 -> 3, 3 -> head 1
        ListNode head3 = ListNode.createInstance(new int[]{1,2,3});
        head3.next.next.next = head3;
        assertEquals(head3, llobj.detectCycle(head3));
    }
}