package johnny.datastructure.lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * Least Recently Used (LRU) cache
 */
public class LRUDeque {
    private int capacity;
    private HashMap<Integer, Integer> map;
    private Deque<Integer> deque;
    private final int MIN = Integer.MIN_VALUE;
    
    public LRUDeque(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Integer>();
        this.deque = new LinkedList<Integer>(); 
    }
    
    public void add(int value) {
        if (map.containsKey(value)) {
            return;
        }

        if (map.size() == capacity) {
            // remove the least recently used element from map and deque
            map.remove(deque.removeLast());
        }

        // add to map
        map.put(value, value);
        // add to the head of deque
        deque.addFirst(value);
    }
    
    public int get(int value) {
        if (!map.containsKey(value)) {
            return this.MIN;
        }

        // remove current
        deque.remove(value); // performance issue, the time complexity for random access is O(n)
        // move it to head
        deque.addFirst(value);

        return map.get(value);
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
