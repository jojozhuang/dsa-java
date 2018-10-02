package johnny.datastructure.lru;

import java.util.HashMap;

import johnny.datastructure.common.Node;

/*
 * Least Recently Used (LRU) cache
 */
public class LRU {
    private int capacity;
    private HashMap<Integer, Node> map; // key, node
    private Node head;                  // The latest accessed element
    private Node tail;                  // The least recently used element
    private final int MAX = Integer.MAX_VALUE;
    private final int MIN = Integer.MIN_VALUE;
    
    public LRU(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        this.head = new Node(this.MAX, this.MAX);
        this.tail = new Node(this.MIN, this.MIN);
        head.next = tail;
        tail.prev = head;
    }
    
    public void add(int key, int value) {
        if (map.containsKey(key)) {
            return;
        }

        if (map.size() == capacity) {
            map.remove(tail.prev.value);
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        
        // move new node to head
        moveToHead(newNode);
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return this.MIN;
        }

        // remove current
        Node current = map.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current node to head
        moveToHead(current);

        return map.get(key).value;
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
