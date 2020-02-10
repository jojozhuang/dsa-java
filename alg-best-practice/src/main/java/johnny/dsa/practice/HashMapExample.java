package johnny.dsa.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HashMapExample {
    public static void main(String[] args) {
        // create HashSet
        Set<String> setStr = new HashSet<>();
        Set<Integer> setNum = new HashSet<>();

        // initialize HashSet with List
        List<Integer> list = Arrays.asList(1, 2);
        Set<Integer> set = new HashSet<>(list); // set = {1,2}

        // initialize HashSet with array
        Integer[] nums = new Integer[]{1,2,3};
        Set<Integer> set2 = new HashSet<>(Arrays.asList(nums)); // set = {1,2,3}

        // create HashMap, key-value pair
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        // remove duplicated elements in list
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(1); // duplicate element
        Set<Integer> set3 = new HashSet<>(list2); // set = {1,2}
        // convert set to list
        list.clear();
        list.addAll(set); // list = {1,2}

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "Monday");
        treeMap.put(2, "Tuesday");
        treeMap.put(3, "Wednesday");
        treeMap.put(4, "Thursday");
        treeMap.put(5, "Friday");
        String day = treeMap.get(3); // day = "Wednesday"
        Integer lowKey = treeMap.lowerKey(3); // lowKey = 2
        Integer highKey = treeMap.higherKey(3); // lowKey = 4
        Map.Entry<Integer, String> lowEntry = treeMap.lowerEntry(3); // lowEntry = <3, Wednesday>
        Map.Entry<Integer, String> highEntry = treeMap.higherEntry(3); // lowEntry = <4, Thursday>
    }
}
