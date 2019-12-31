package johnny.dsa.alg;

import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        mergeHelper(nums, 0, nums.length - 1);
        return;
    }

    private void mergeHelper(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int mid = start + (end - start) / 2;
        mergeHelper(nums, start, mid);
        mergeHelper(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }
    
    private void merge(int[] nums, int start, int mid, int end) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        
        int left = start;
        int right = mid + 1;
        for (int k = start; k <= end; k++) {
            if (left > mid) { // no item at left
                nums[k] = copy[right];
                right++;
            }
            else if(right > end) { // no item at right
                nums[k] = copy[left];
                left++;
            }
            else if (copy[left] <= copy[right]) {
                nums[k] = copy[left];
                left++;
            }
            else{
                nums[k] = copy[right];
                right++;
            }
        }
    }
    
    // less space
    public void merge2(int[] nums, int start, int mid, int end) {
        int[] copy = Arrays.copyOfRange(nums, start, end + 1);
        
        int left = start;
        int right = mid + 1;
        for (int i = start; i <= end; i++) {
            if (left > mid) { // no item at left
                nums[i] = copy[right - start];
                right++;
            }
            else if(right > end) { // no item at right
                nums[i] = copy[left - start];
                left++;
            }
            else if (copy[left - start] <= copy[right - start]) {
                nums[i] = copy[left - start];
                left++;
            }
            else{
                nums[i] = copy[right - start];
                right++;
            }
        }
    }
    
    public void merge3(int[] nums, int start, int mid, int end) {
        int[] mergeArr = new int[nums.length];
        for (int i = start; i <= end; i++) {
            mergeArr[i] = nums[i];
        }
        
        int i = start;
        int j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            if (mergeArr[i] <= mergeArr[j]) {
                nums[k] = mergeArr[i];
                i++;
            } else {
                nums[k] = mergeArr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            nums[k] = mergeArr[i];
            k++;
            i++;
        }
        
        while (j <= end) {
            nums[k] = mergeArr[j];
            k++;
            j++;
        }
    }
}
