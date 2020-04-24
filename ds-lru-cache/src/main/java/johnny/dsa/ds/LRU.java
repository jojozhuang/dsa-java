package johnny.dsa.ds;

import java.util.HashMap;

/*
 * Least Recently Used (LRU) cache
 */
public class LRU {
    private int capacity;
    private HashMap<Integer, Node> map; // key, node
    private Node head;                  // The latest accessed element
    private Node tail;                  // The least recently used element

    public LRU(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public void put(int key, int val) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = val;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToHead(node);
            return;
        }

        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
        }

        Node node = new Node(key, val);
        map.put(key, node);
        
        // move new node to head
        moveToHead(node);
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        // remove current
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        // move current node to head
        moveToHead(node);

        return node.val;
    }

    private void moveToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }
    
    // methods for testing
    public int[] getAll() {
        int[] res = new int[map.size()];
        int i = 0;
        
        Node curr = this.head.next;
        
        while(curr.next != null) {
            if (curr.val != Integer.MIN_VALUE) {
                res[i] = curr.val;
                i++;
            }
            curr = curr.next;
        }
        
        return res;
    }
}
