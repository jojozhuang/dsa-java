package johnny.datastructure.cache;

import java.util.HashMap;

import johnny.datastructure.common.Node;

/*
 * Least Recently Used (LRU) cache
 */
public class LRU {
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head; // The latest accessed element
    private Node tail; // The least recently used element
    private final int MIN = Integer.MIN_VALUE;
    
    public LRU(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        this.head = new Node(this.MIN);
        this.tail = new Node(this.MIN);
        head.next = tail;
        tail.prev = head;
    }
    
    public void add(int value) {
        if (map.containsKey(value)) {
            return;
        }

        if (map.size() == capacity) {
            map.remove(tail.prev.value);
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
        }

        Node newNode = new Node(value);
        map.put(value, newNode);
        
        // move new node to head
        moveToHead(newNode);
    }
    
    public int get(int value) {
        if (!map.containsKey(value)) {
            return this.MIN;
        }

        // remove current
        Node current = map.get(value);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current node to head
        moveToHead(current);

        return map.get(value).value;
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
            if (curr.value != Integer.MIN_VALUE) {
                res[i] = curr.value;
                i++;
            }
            curr = curr.next;
        }
        
        return res;
    }
}
