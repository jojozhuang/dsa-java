package johnny.datastructure.lfu;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUHeap {
    private HashMap<Integer, Integer> values;               // key, value
    private HashMap<Integer, Integer> counts;               // key, count
    private PriorityQueue<Integer> heap;                    // sorted count, ascending
    private HashMap<Integer, LinkedHashSet<Integer>> lists; // count, list->keys

    private int capacity;
    public LFUHeap(int capacity) {
        this.capacity = capacity;
        values = new HashMap<>();
        counts = new HashMap<>();
        heap = new PriorityQueue<>();
        lists = new HashMap<>();
        lists.put(0, new LinkedHashSet<>()); // always keep a minimum, as 0 is the smallest.
        heap.offer(0);
    }
    
    public void add(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (values.containsKey(key)) {
            values.put(key, value);
            get(key); // trigger the reorder
            return;
        } 
        if (values.size() >= capacity) {
            int min = heap.peek();
            int evict = lists.get(min).iterator().next();
            lists.get(min).remove(evict);
            values.remove(evict);
            counts.remove(evict);
            if (lists.get(min).size() == 0) {
                //lists.remove(min);
                heap.poll();
            }
        }
        values.put(key, value);
        counts.put(key, 0);
        lists.get(0).add(key);
    }
    
    public int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }
        int count = counts.get(key);
        counts.put(key, count + 1);
        lists.get(count).remove(key);
        if (lists.get(count).size() == 0) {
            //lists.remove(count);
            heap.remove(count);
        }
        
        if (!lists.containsKey(count+1)) {
            lists.put(count + 1, new LinkedHashSet<>());
            heap.offer(count + 1);
        }
        lists.get(count + 1).add(key);
        return values.get(key);
    }
    
    // methods for testing
    public int[][] getAll() {
        int[][] res = new int[2][values.size()];
        int[][] pairs = sortByValue(counts);
        int i = 0;
        while (i < pairs.length) {
            if (i < pairs.length - 1) {
                if (pairs[i][1] > pairs[i+1][1]) {
                    res[0][i] = pairs[i][0];
                    res[1][i] = counts.get(pairs[i][0]);
                    i++;
                } else {
                    LinkedHashSet<Integer> list = lists.get(pairs[i][1]);
                    int j = list.size() - 1;
                    for (Integer key : list) {
                        res[0][i+j] = values.get(key);
                        res[1][i+j] = counts.get(key);
                        j--;
                    }
                    i += list.size();
                }
            } else {
                res[0][i] = pairs[i][0];
                res[1][i] = counts.get(pairs[i][0]);
                i++;
            }
        }
        
        return res;
    }
    
    private int[][] sortByValue(HashMap<Integer, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<Integer, Integer> > list = 
               new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,  
                               Map.Entry<Integer, Integer> o2) 
            { 
                return (o2.getValue()).compareTo(o1.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        int i = 0;
        int[][] res = new int[list.size()][2];
        for (Map.Entry<Integer, Integer> entry : list) { 
            res[i][0] = entry.getKey();
            res[i][1] = entry.getValue();
            i++;
        } 
        return res; 
    }
}
