package johnny.dsa.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // create empty array
        int[] nums = new int[]{};
        String[] strs = new String[]{};

        // create array with length = 3
        int[] nums2 = new int[3];
        String[] strs2 = new String[3];

        // create char array from string
        String s = "hello";
        char[] chs = s.toCharArray(); // chs = {'h','e','l','l','o'};

        // create list
        List<Integer> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        // create list with array
        Integer[] nums3 = new Integer[]{1,2,3};
        List<Integer> list = Arrays.asList(nums3); // list = {1,2,3}

        // loop
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
        }
        // or
        for (int num : nums) {

        }

        // Sort array
        int[] nums4 = {3, 7, 6, 5, 9, 2};
        Arrays.sort(nums4);  // nums4 = {2,3,5,6,7,9};

        // Sort collection
        List<String> list3 = new ArrayList<>();
        list3.add("orange");
        list3.add("apple");
        list3.add("banana");
        Collections.sort(list3); // list3 = {"apple", "banana", "orange"}

        // Binary search
        int index1 = Arrays.binarySearch(new char[]{'c','d','e','f','g'}, 'f');  // index1 = 3;
        int index2 = Arrays.binarySearch(new int[]{10,15,20,22,35}, 20);         // index2 = 2;
        int index3 = Collections.binarySearch(Arrays.asList(new Integer[] {10,15,20,22,35}), 15); // index3 = 1;

        // Binary search on array
        int[] array = {10,15,20,22,35};
        int index21 = Arrays.binarySearch(array,20); // index21 = 2
        int index22 = Arrays.binarySearch(array,8);  // index22 = -1, (-insertion point) - 1
        int index23 = Arrays.binarySearch(array,40); // index23 = -6, (-insertion point) - 1

        // Binary search on collection
        List list4 = new ArrayList<>(Arrays.asList(new Integer[]{10,15,20,22,35}));
        int index31 = Collections.binarySearch(list4,20); // index31 = 2
        int index32 = Collections.binarySearch(list4,8);  // index32 = -1, (-insertion point) - 1
        int index33 = Collections.binarySearch(list4,40); // index33 = -6, (-insertion point) - 1

        // print Array
        int[] nums5 = {1,3,5,7};
        System.out.println(Arrays.toString(nums5)); // print [1,3,5,7]
    }
}
