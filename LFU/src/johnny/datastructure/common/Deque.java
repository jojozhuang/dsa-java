package johnny.datastructure.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Deque {
    class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    private Node head; // The most frequently accessed element
    private Node tail; // The least frequently used element
    private HashMap<Integer, Node> map;
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
    public void addFirst(int value) {
        Node node = new Node(value);
        map.put(value, node);
        
        // move new node to head
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        size++;
    }
    
    // O(1)
    public void removeLast() {
        map.remove(tail.prev.value);
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        size--;
    }
    
    // O(1)
    public void remove(int value) {
        Node node = map.get(value);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(value);
        size--;
    }
    
    public int first() {
        if (size > 0) {
            return head.next.value;
        } else {
            return Integer.MAX_VALUE;
        }
    }
    
    public int last() {
        if (size > 0) {
            return tail.prev.value;
        } else {
            return Integer.MIN_VALUE;
        }
    }
    
    public List<Integer> getValues() {
        List<Integer> res = new ArrayList<>();
        Node root = head.next;
        while (root != null) {
            if (root.value != MIN) {
                res.add(root.value);
            }
            root = root.next;
        }
        return res;
    }
    
    public int size() {
        return size;
    }
}
