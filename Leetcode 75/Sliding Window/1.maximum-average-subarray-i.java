/**
 * Leetcode question link :
 * https://leetcode.com/problems/maximum-average-subarray-i/submissions/1471571828/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach :
 * Use two pointer (we and ws) both from start
 * 1. Start iterating the array from one pointer keep calculating the sum of
 * elements that are being encountered.
 * 2. if we reach or windowSize we calculate the avg compare it with max and
 * save the value.
 * 3. Now we have to the window size from ws (window start) pointer so increment
 * ws to 1 as this has been included in the window also decrease the value of
 * ws[i] from sum to ensure proper calculation for next iteration
 * 
 * Time complexity -> O(n)
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