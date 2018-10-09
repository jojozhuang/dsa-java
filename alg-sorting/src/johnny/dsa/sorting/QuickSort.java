package johnny.dsa.sorting;

public class QuickSort {
    public void quickSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        quickHelper(nums, 0, nums.length - 1);
        return;
    }
    
    private void quickHelper(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int pivot = partition(nums, start, end);
        quickHelper(nums, start, pivot - 1);
        quickHelper(nums, pivot + 1, end);
    }
    
    // one way
    private int partition(int[] nums, int start, int end) {
        int pivot = start; // select the first as the pivot
        
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < nums[start]) {
                pivot++;
                int temp = nums[pivot];
                nums[pivot] = nums[i];
                nums[i] = temp;
            }
        }
        
        int temp = nums[pivot];
        nums[pivot] = nums[start];
        nums[start] = temp;
        return pivot;
    }
    
    // two ways
    public int Partition2(int[] nums, int start, int end) {
        int left = start + 1;
        int right = end;
       
        while (left < right) {
            while (left <= right && nums[left] < nums[start]) {
                left++;
            }
            while (left <= right && nums[right] > nums[start]) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        
        int temp = nums[right];
        nums[right] = nums[start];
        nums[start] = temp;
        return right;
    }
}
