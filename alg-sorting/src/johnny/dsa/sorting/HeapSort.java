package johnny.dsa.sorting;

public class HeapSort {
    public void heapSort(int nums[]) {
        if (nums == null || nums.length < 2) {
            return;
        }
 
        // Build heap (rearrange array)
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }
 
        // One by one extract an element from heap
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
 
            heapify(nums, i, 0);
        }
    }
 
    private void heapify(int nums[], int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left child
        int r = 2*i + 2;  // right child
 
        if (l < n && nums[l] > nums[largest]) {
            largest = l;
        }
 
        if (r < n && nums[r] > nums[largest]) {
            largest = r;
        }
 
        // If largest is not root
        if (largest != i) {
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(nums, n, largest);
        }
    }
}
