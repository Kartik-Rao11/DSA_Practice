import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode Question Link
 * https://leetcode.com/problems/3sum/description/
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            searchPair(nums, -nums[i], i + 1, nums.length - 1);
        }

        return result;
    }

    public void searchPair(int[] nums, int target, int start, int end) {
        while (start < end) {
            int currSum = nums[start] + nums[end];
            if (currSum == target) {
                result.add(new ArrayList<>(Arrays.asList(-target, nums[start], nums[end])));

                while (start < end && nums[start] == nums[start + 1]) {
                    start++;
                }

                while (start < end && nums[end] == nums[end - 1]) {
                    end--;
                }
            }

            if (currSum < target) {
                start++;
            } else {
                end--;
            }
        }
    }
}