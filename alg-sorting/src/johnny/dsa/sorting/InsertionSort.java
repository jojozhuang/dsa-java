package johnny.dsa.sorting;

public class InsertionSort {
    public void insertionSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        } 
        
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > key) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = key;
        }
    }
}
