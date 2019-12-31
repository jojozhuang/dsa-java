package johnny.dsa.alg;

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
 
    /*
     * n is the size of heap, i is the index of node in array
     */
    private void heapify(int nums[], int n, int i) {
        int largest = i;     // Initialize largest as root
        int left = 2*i + 1;  // left child
        int right = 2*i + 2; // right child
 
        // If left child is larger than root 
        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }
 
        // If right child is larger than largest so far 
        if (right < n && nums[right] > nums[largest]) {
            largest = right;
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
