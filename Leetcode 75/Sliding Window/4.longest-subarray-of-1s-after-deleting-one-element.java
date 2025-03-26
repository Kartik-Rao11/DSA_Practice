/**
 * Leetcode Question Link :
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach (Sliding window):
 * 1. Use two pointers both at start. Keep Iterating from one of them.
 * 2. Keep track count of zeroes since we cannot have more than 1 zero as this
 * will be the one to be deleted to make the longest subarray.
 * 3. Use another while loop if zeroCount > 1 and reduce the count by sliding
 * the window from start of the array.
 * 4. Calculate the max length
 * 
 * Time Complexity -> O(N)
 * 
 */

class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int maxLen = 0;
        int zeroCount = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0)
                zeroCount++;

            while (zeroCount > 1) {
                if (nums[left] == 0)
                    zeroCount--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}