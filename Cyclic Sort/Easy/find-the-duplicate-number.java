/**
 * Leetcode question link :
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * Approach:
 * 1. Using the cyclic sort we can keep find the duplicate. Any time we swap the
 * same number that number is the duplicate.
 * 
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            if (nums[i] != i + 1) {
                int j = nums[i] - 1;
                if (nums[i] != nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }

        return -1;
    }
}