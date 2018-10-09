package johnny.dsa.sorting;

public class BubbleSort {
    public void bubbleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
       
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }
}
