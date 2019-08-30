package johnny.dsa.monotonicqueue;

public class FirstSmallerNaive {
    // input:  [ 5, 3,  1, 2, 4]
    // output: [-1,-1, -1, 1, 2]
    // O(n^2)
    public int[] firstSmallerLeft(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = -1;
            int curr = nums[i];
            for (int j = i - 1; j >=0; j--) { // scan from head
                if (nums[j] < curr) {
                    ans[i] = nums[j];
                    break;
                }
            }
        }

        return ans;
    }

    // input:  [5, 3,  1,  2,  4]
    // output: [3, 1, -1, -1, -1]
    // O(n^2)
    public int[] firstSmallerRight(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = -1;
            int curr = nums[i];
            for (int j = i + 1; j < nums.length; j++) { // scan from tail
                if (nums[j] < curr) {
                    ans[i] = nums[j];
                    break;
                }
            }
        }

        return ans;
    }
}
