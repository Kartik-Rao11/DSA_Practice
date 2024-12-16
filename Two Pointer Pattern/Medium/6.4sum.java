import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode question link
 * https://leetcode.com/problems/4sum/description/
 */
class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    long sum = (long) nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[start], nums[end])));
                        start++;
                        end--;
                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }

                }
            }

        }

        return result;
    }
}