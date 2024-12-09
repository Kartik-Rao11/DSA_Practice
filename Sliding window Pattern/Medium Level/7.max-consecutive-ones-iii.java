
/**
 * Leetcode question link
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
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