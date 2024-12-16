import java.util.Arrays;

/** Leetcode Question Link
 * https://leetcode.com/problems/3sum-smaller/description/
 */

class Solution {

    public int threeSumCloser(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            count += serachPair(nums, target - nums[i], i + 1, nums.length - 1);
        }
        return count;
    }

    public int serachPair(int[] nums, int target, int start, int end) {
        int count = 0;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < target) {
                count += end - start;
                start++;
            } else {
                end--;
            }
        }

        return count;
    }
}
