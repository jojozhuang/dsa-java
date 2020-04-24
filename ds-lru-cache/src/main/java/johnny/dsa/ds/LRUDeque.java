package johnny.dsa.ds;

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

    public LRUDeque(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.deque = new LinkedList<>();
    }
    
    public void put(int key, int val) {
        if (map.containsKey(key)) {
            map.put(key, val);
            // remove current
            deque.remove(key); // equivalent to removeFirstOccurrence(), performance issue, O(n)
            // move it to head
            deque.addFirst(key);
            return;
        }

        if (map.size() == capacity) {
            // remove the least recently used element from map and deque
            map.remove(deque.removeLast());
        }

        // add to map
        map.put(key, val);
        // add to the head of deque
        deque.addFirst(key);
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
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
