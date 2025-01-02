/**
 * LeetCode Question Link : https://leetcode.com/problems/missing-number/
 * 
 * Approach:
 * 1. Sort the numbers using cyclic sort.
 * 2. Again iterate the array to find the missing number. Missing number will be
 * the one where nums[i] != i (index itself)
 */
class Solution {

    public int findMissingNumber(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            int j = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k) {
                return k;
            }
        }

        return -1;
    }
}