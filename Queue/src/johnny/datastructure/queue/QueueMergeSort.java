package johnny.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMergeSort {
    // Merge Sort
    public Queue<Integer> sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        // initialize queue
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < nums.length; i++) {
            // convert number to number array
            queue.offer(new int[]{nums[i]});
        }

        while (queue.size() > 1) {
            int[] l = queue.poll();
            int[] r = queue.poll();
            int[] merged = merge(l, r);
            queue.offer(merged);
        }
        
        int[] sorted = queue.poll();
        Queue<Integer> finalQueue = new LinkedList<>();
        for (int i : sorted) {
            finalQueue.offer(i);
        }
        
        return finalQueue;
    }
    
    private int[] merge(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return nums2;
        }
        if (nums2 == null || nums2.length == 0) {
            return nums1;
        }
        
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        for (int k = 0; k < nums.length; k++) {
            if (i >= nums1.length) {
                nums[k] = nums2[j];
                j++;
            } else if (j >= nums2.length) {
                nums[k] = nums1[i];
                i++;
            } else if (nums1[i] <= nums2[j]) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
        }
        
        return nums;
    }
}
