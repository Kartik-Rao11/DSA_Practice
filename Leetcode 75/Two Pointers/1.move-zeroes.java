/**
 * Leetcode Question Link:
 * https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach :
 * 1. Keep One pointer left = 0. This will be the pointer to keep track of zero
 * elements.
 * 2. Iterate through the array using another pointer right and every time we
 * encounter a non zero elements swap them if the left pointer.
 * 
 * Time complexity -> O(n)
 * 
 */

class Solution {
    public void moveZeroes(int[] nums) {

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                if (left != right) {
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                }

                left++;
            }
        }
    }
}