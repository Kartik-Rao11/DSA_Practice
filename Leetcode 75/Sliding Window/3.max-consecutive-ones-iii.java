/**
 * Leetcode question Link :
 * https://leetcode.com/problems/max-consecutive-ones-iii/submissions/1471781378/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach (Sliding window):
 * 1. Use two pointer both at start. Start iterating the array from one of the
 * pointer.
 * 2. Keep track of maxConsecutive ones.
 * 3. Once current position of iterating pointer - maxOnes > K. Meaning totalLen
 * - maxOne > k. (we -ws + 1) - maxOnes > K then we need to slide the window
 * from other pointer at the start. Subtracting maxOnes occurences from the
 * window
 * 4. Keep calculating the length of the maxLen
 * 
 * Time Complexity -> O(N)
 * 
 */

class Solution {
    public int longestOnes(int[] nums, int k) {
        int ws = 0;
        int maxOnes = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int we = 0; we < nums.length; we++) {

            if (nums[we] == 1) {
                maxOnes++;
            }

            if ((we - ws + 1 - maxOnes) > k) {
                if (nums[ws] == 1) {
                    maxOnes--;
                }
                ws++;
            }

            maxLen = Math.max(maxLen, we - ws + 1);

        }
        return maxLen == Integer.MIN_VALUE ? -1 : maxLen;
    }
}