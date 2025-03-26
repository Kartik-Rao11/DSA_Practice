/**
 * Leetcode question link :
 * https://leetcode.com/problems/find-pivot-index/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * 1. Calculate the totalSum of the array
 * 2. Now we need to euqal the leftSum = rightSum at i.
 * 3. Iterate over the array again and check
 * leftSum (initially 0) = totalSum -left -nums[i]
 * return i (Pivot index)
 * 
 * Time complexity -> O(N) 2 Passes
 * 
 */

class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0, leftSum = 0;
        for (int n : nums) {
            totalSum += n;
        }

        for (int i = 0; i < nums.length; i++) {

            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}