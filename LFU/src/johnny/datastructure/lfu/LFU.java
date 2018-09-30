package johnny.datastructure.lfu;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import johnny.datastructure.common.Node;

public class LFU {
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head; // The most frequently accessed element
    private Node tail; // The least frequently used element
    private final int MAX = Integer.MAX_VALUE;
    private final int MIN = Integer.MIN_VALUE;
    
    public LFU(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        this.head = new Node(this.MAX, this.MAX);
        this.tail = new Node(this.MIN, this.MIN);
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

        Node newNode = new Node(value, 0);
        map.put(value, newNode);
        
        // move new node to proper position
        move(newNode);
    }
    
    public int get(int value) {
        if (!map.containsKey(value)) {
            return this.MIN;
        }

        // remove current
        Node current = map.get(value);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        current.count++; // increment before move

        // move current node to proper position
        move(current);

        return map.get(value).value;
    }

    private void move(Node node) {
        Node curr = head;
        while (curr != null) {
            if (curr.count > node.count) {
                curr = curr.next;
            } else {
                node.prev = curr.prev;
                node.next = curr;
                node.next.prev = node;
                node.prev.next = node;
                break;
            }
        }
    }
    
    // methods for testing
    public int[][] getAll() {
        int[][] res = new int[2][map.size()];
        int i = 0;
        
        Node curr = this.head.next;
        
        while(curr.next != null) {
            if (curr.value != Integer.MIN_VALUE) {
                res[0][i] = curr.value;
                res[1][i] = curr.count;
                i++;
            }
            curr = curr.next;
        }
        
        return res;
    }
}
