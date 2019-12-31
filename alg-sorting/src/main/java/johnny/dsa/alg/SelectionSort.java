package johnny.dsa.alg;

public class SelectionSort {
    public void selectionSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            
            if (min > i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
    }
}
