package johnny.dsa.mapreduce;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import johnny.dsa.common.Document;
import johnny.dsa.common.OutputCollector;


/**
 * Top K Frequent Words (Map Reduce)
 * 
 * Find top k frequent words with map reduce framework.
 * 
 * The mapper's key is the document id, value is the content of the document, 
 * words in a document are split by spaces.
 * 
 * For reducer, the output should be at most k key-value pairs, which are the 
 * top k words and their frequencies in this reducer. The judge will take care 
 * about how to merge different reducers' results to get the global top k 
 * frequent words, so you don't need to care about that part.
 * 
 * The k is given in the constructor of TopK class.
 * 
 * Example
 * Given document A =
 * lintcode is the best online judge
 * I love lintcode
 * 
 * and document B =
 * lintcode is an online judge for coding interview
 * you can test your code online at lintcode
 * 
 * The top 2 words and their frequencies should be
 * 
 * lintcode, 4
 * online, 3
 * 
 * @author Johnny
 */
public class TopKFrequentWords {
    //HashMap<String, Integer> map = new HashMap<String, Integer>();
    public static class Map {
        public void map(String aa, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            String content = value.content.trim();
            String[] words = content.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (!words[i].isEmpty()) {
                    output.collect(words[i], 1);
                }
            }
        }
    }

    public static class Reduce {
        LinkedHashMap<String, Integer> countMap = new LinkedHashMap<String, Integer>();
        int top = 0;

        public void setup(int k) {
            // initialize your data structure here
            top = k;
        }   

        public void reduce(String key, Iterator<Integer> values) {
            // Write your code here
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next();
            }
            countMap.put(key, sum);
        }

        public void cleanup(OutputCollector<String, Integer> output) {
            HashMap<String, Integer> sortedMap = sortByComparator(countMap);
            int i = 0;
            for (String key : sortedMap.keySet()) {
                if (i >= top) {
                    break;
                }
                output.collect(key, sortedMap.get(key));
                i++;
            }
            /*int cnt = 0;
            top = Math.min(top, countMap.size());
            Integer[] counts = countMap.values().toArray(new Integer[0]);
            Arrays.sort(counts);
            
            for (int i = counts.length - 1; i >= 0; i--) {                
                for (String key : countMap.keySet()) {
                    if (countMap.get(key) == counts[i]) {
                        output.collect(key, counts[i]);
                        cnt++;
                        if (cnt >= top) {
                            return;
                        }
                    }
                }
            }*/
        }
        
        private HashMap<String, Integer> sortByComparator(HashMap<String, Integer> unsortMap)
        {

            List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

            // Sorting the list based on values
            Collections.sort(list, new Comparator<Entry<String, Integer>>()
            {
                public int compare(Entry<String, Integer> o1,
                        Entry<String, Integer> o2)
                {
                    int val1 = o1.getValue();
                    int val2 = o2.getValue();
                    String key1 = o1.getKey();
                    String key2 = o2.getKey();
                    if (val1 == val2) {
                        return key1.compareTo(key2);
                    } else {
                        return val2 - val1;
                    }
                }
            });

            // Maintaining insertion order with the help of LinkedList
            HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
            for (Entry<String, Integer> entry : list)
            {
                sortedMap.put(entry.getKey(), entry.getValue());
            }

            return sortedMap;
        }
    }
}
