/**
 * LeetCode Question link : https://leetcode.com/problems/maximum-subarray/
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int maxArea = Integer.MIN_VALUE;
        int currSum = 0;
        for (int num : nums) {
            currSum += num;
            maxArea = Math.max(currSum, maxArea);
            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxArea;
    }
}