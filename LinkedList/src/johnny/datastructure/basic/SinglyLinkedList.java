package johnny.datastructure.basic;

public class SinglyLinkedList {
    // create a singly linked list with the given array
    public static SinglyLinkedNode create(int[] arr) {  
        if (arr == null || arr.length == 0) {
            return null;
        }

        SinglyLinkedNode dummy = new SinglyLinkedNode(0);
        SinglyLinkedNode curr = dummy;
        for (int i = 0; i < arr.length; i++) {
            curr.next = new SinglyLinkedNode(arr[i]);
            curr = curr.next;
        }

        return dummy.next;
    }
}
