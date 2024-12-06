/**
 * Leet Code Question link
 * https://leetcode.com/problems/maximum-average-subarray-i/description/
 */

class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int ws = 0;
        int we = 0;
        double maxSum = Integer.MIN_VALUE;
        double currSum = 0;
        for (we = 0; we < nums.length; we++) {
            currSum += nums[we];

            if (we >= k - 1) {
                maxSum = Math.max(maxSum, (currSum / k));
                currSum -= nums[ws];
                ws++;
            }
        }
        return maxSum;
    }
}