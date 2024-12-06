/**
 * LeetCode Question
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ws = 0;
        int we = 0;
        int minLen = Integer.MAX_VALUE;
        int currSum = 0;
        for (we = 0; we < nums.length; we++) {
            currSum += nums[we];
            while (currSum >= target) {
                minLen = Math.min(minLen, we - ws + 1);
                currSum -= nums[ws];
                ws++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}