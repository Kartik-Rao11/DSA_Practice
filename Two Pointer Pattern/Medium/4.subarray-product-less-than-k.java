
/**
 * Leetcode question link
 * https://leetcode.com/problems/subarray-product-less-than-k/description/
 */

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int count = 0;
        int start = 0;
        int prod = 1;
        for (int end = 0; end < nums.length; end++) {
            prod *= nums[end];
            while (prod >= k && start < nums.length) {
                prod /= nums[start];
                start++;
            }
            count += end - start + 1;
        }

        return count <= 0 ? 0 : count;

    }
}