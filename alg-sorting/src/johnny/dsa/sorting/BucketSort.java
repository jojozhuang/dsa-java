package johnny.dsa.sorting;

public class BucketSort {
    public void bucketSort(int[] nums, int maxVal) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int [] bucket = new int[maxVal+1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }

        int outPos=0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                nums[outPos++] = i;
            }
        }
    }
    //http://www.geeksforgeeks.org/bucket-sort-2/
    //http://www.javacodex.com/Sorting/Bucket-Sort
}
