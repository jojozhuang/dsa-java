package johnny.dsa.sorting;

public class ShellSort {
    public void shellSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        } 
        
        for (int gap = nums.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < nums.length; i++) {
                int temp = nums[i];
                int j;
                for (j = i; j >= gap && nums[j - gap] > temp; j = j - gap) {
                    nums[j] = nums[j - gap];
                }
                nums[j] = temp;
            }
        }
    }
}
