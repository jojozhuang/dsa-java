package johnny.datastructure.basic;

public class DoublyLinkedList {
    // create a doubly linked list with the given array
    public static DoublyLinkedNode create(int[] arr) {  
        if (arr == null || arr.length == 0) {
            return null;
        }

        DoublyLinkedNode dummy = new DoublyLinkedNode(0);
        DoublyLinkedNode curr = dummy;
        for (int i = 0; i < arr.length; i++) {
            curr.next = new DoublyLinkedNode(arr[i]);
            curr.next.previous = curr;
            curr = curr.next;
        }

        return dummy.next;
    }
}
