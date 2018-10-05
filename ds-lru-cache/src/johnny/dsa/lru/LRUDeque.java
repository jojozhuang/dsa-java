package johnny.dsa.lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * Least Recently Used (LRU) cache
 */
public class LRUDeque {
    private int capacity;
    private HashMap<Integer, Integer> map; // key, value
    private Deque<Integer> deque;          // key
    private final int MIN = Integer.MIN_VALUE;
    
    public LRUDeque(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Integer>();
        this.deque = new LinkedList<Integer>(); 
    }
    
    public void add(int key, int value) {
        if (map.containsKey(key)) {
            return;
        }

        if (map.size() == capacity) {
            // remove the least recently used element from map and deque
            map.remove(deque.removeLast());
        }

        // add to map
        map.put(key, value);
        // add to the head of deque
        deque.addFirst(key);
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return this.MIN;
        }

        // remove current
        deque.remove(key); // equivalent to removeFirstOccurrence(), performance issue, O(n)
        // move it to head
        deque.addFirst(key);

        return map.get(key);
    }

    // methods for testing
    public int[] getAll() {
        int[] res = new int[map.size()];
        int i = 0;
        
        Iterator<Integer> itr = deque.iterator();
        
        while (itr.hasNext()) {
            Integer val = itr.next();
            if (val != Integer.MIN_VALUE) {
                res[i] = val;
                i++;
            }
        }
        
        return res;
    }
}
