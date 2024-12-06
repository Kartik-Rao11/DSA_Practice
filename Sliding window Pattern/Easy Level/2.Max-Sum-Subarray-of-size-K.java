/**
 * GFG Question Link
 * https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
 */

class Solution {
    public int maximumSumSubarray(int[] arr, int k) {
        // Code here
        int ws = 0;
        int we = 0;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (we = 0; we < arr.length; we++) {
            currSum += arr[we];
            if (we >= k - 1) {
                maxSum = Math.max(maxSum, currSum);
                currSum -= arr[ws];
                ws++;
            }
        }

        return maxSum == Integer.MIN_VALUE ? 0 : maxSum;
    }
}