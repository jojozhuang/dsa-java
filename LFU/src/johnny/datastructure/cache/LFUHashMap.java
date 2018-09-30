package johnny.datastructure.cache;

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

public class LFUHashMap {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int cap;
    int min = -1;
    public LFUHashMap(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(0, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        counts.put(key, count+1);
        lists.get(count).remove(key);
        if(count==min && lists.get(count).size()==0)
            min++;
        if(!lists.containsKey(count+1))
            lists.put(count+1, new LinkedHashSet<>());
        lists.get(count+1).add(key);
        return vals.get(key);
    }
    
    public void put(int key, int value) {
        if(cap<=0)
            return;
        if(vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        } 
        if(vals.size() >= cap) {
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
            counts.remove(evit);
        }
        vals.put(key, value);
        counts.put(key, 0);
        min = 0;
        lists.get(0).add(key);
    }
    
    // methods for testing
    public int[] getAll() {
        int[] res = new int[counts.size()];
        int[][] pairs = sortByValue(counts);
        int i = 0;
        while (i < pairs.length) {
            if (i < pairs.length - 1) {
                if (pairs[i][1] > pairs[i+1][1]) {
                    res[i] = pairs[i][0];
                    i++;
                } else {
                    LinkedHashSet<Integer> list = lists.get(pairs[i][1]);
                    int j = list.size() - 1;
                    for (Integer key : list) {
                        res[i+j] = vals.get(key);
                        j--;
                    }
                    i += list.size();
                }
            } else {
                res[i] = pairs[i][0];
                i++;
            }
        }
        
        return res;
        /*
        int i = 0;
        Iterator itr = counts.entrySet().iterator();
        
        while (itr.hasNext()) {
            Entry pair = (Entry)itr.next();
            pairs[i][0] = (int)pair.getKey();
            pairs[i][1] = (int)pair.getValue();
            i++;
        }
        
        Integer[] keys = new Integer[pairs.length];
        Integer[] counts = new Integer[pairs.length];
        for (i = 0; i < pairs.length; i++) {
            keys[i] = pairs[i][0];
            counts[i] = pairs[i][1];
        }
        
        Arrays.sort(values, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return counts[i2] - counts[i1];
            }
        });
        
        int[] res = new int[values.length];
        for (i = 0; i < values.length; i++) {
            res[i] = values[i];
        }
        return res;
        */
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
