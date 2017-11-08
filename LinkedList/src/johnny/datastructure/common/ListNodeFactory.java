package johnny.datastructure.common;

import johnny.datastructure.common.ListNode;

public class ListNodeFactory {
	public static ListNode createInstance(int[] arr) {  
        if (arr == null || arr.length == 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int i = 0; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        
        return dummy.next;
    }
    
    public static ListNode[] createList(int[][] arr) {  
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return null;
        }
        
        ListNode[] res = new ListNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = createInstance(arr[i]);
        }
        
        return res;
    }
    
    public static boolean isSame(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return true;
        }
        if (l1 == null && l2 != null) {
            return false;
        }
        if (l1 != null && l2 == null) {
            return false;
        }
        if (l1.val != l2.val) {
            return false;
        }
        
        return isSame(l1.next, l2.next);
    }
}
