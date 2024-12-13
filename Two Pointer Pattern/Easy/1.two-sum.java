import java.util.HashMap;

/**
 * Leetcode question link
 * https://leetcode.com/problems/minimum-window-substring/description/
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (freq.containsKey(target - curr)) {
                return new int[] { freq.get(target - curr), i };
            }
            freq.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}