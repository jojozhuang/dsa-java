package johnny.dsa.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Deque {
    class Node {
        public int key;
        public Node prev;
        public Node next;

        public Node(int key) {
            this.key = key;
            this.prev = null;
            this.next = null;
        }
    }
    
    private Node head;                  // The most frequently accessed element
    private Node tail;                  // The least frequently used element
    private HashMap<Integer, Node> map; // key, node
    private int size;
    private final int MAX = Integer.MAX_VALUE;
    private final int MIN = Integer.MIN_VALUE;
    
    public Deque() {
        head = new Node(this.MAX);
        tail = new Node(this.MIN);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer, Node>();
        size = 0;
    }
    
    // O(1)
    public void addFirst(int key) {
        Node node = new Node(key);
        map.put(key, node);
        
        // move new node to head
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        size++;
    }
    
    // O(1)
    public void removeLast() {
        map.remove(tail.prev.key);
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        size--;
    }
    
    // O(1)
    public void remove(int key) {
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(key);
        size--;
    }
    
    public int first() {
        if (size > 0) {
            return head.next.key;
        } else {
            return Integer.MAX_VALUE;
        }
    }
    
    public int last() {
        if (size > 0) {
            return tail.prev.key;
        } else {
            return Integer.MIN_VALUE;
        }
    }
    
    public List<Integer> getKeys() {
        List<Integer> res = new ArrayList<>();
        Node root = head.next;
        while (root != null) {
            if (root.key != MIN) {
                res.add(root.key);
            }
            root = root.next;
        }
        return res;
    }
    
    public int size() {
        return size;
    }
}
