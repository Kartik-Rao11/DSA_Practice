/**
 * Leet code question link :
 * https://leetcode.com/problems/first-missing-positive/description/
 * 
 * Given an unsorted integer array nums. Return the smallest positive integer
 * that is not present in nums.
 * 
 * You must implement an algorithm that runs in O(n) time and uses O(1)
 * auxiliary space.
 * 
 * Approach:
 * 1. since the range of array is not from 1 to n. It means array 0 <= nums[i]
 * >= n.
 * 2. To use cyclic sort (putting the number on the correct index) we can ignore
 * the number < 0 i.e negative and numbers that are greater than n (length of
 * the array)
 * 3. Sort the array using cyclic sort by applying the constraints in step 2.
 * 4. Iterate the array and find the number missing from it's index and return.
 * 5. If in the range (1 to n) all the numbers are present that means first
 * missing postive integer woulbe n+1
 */

class Solution {
    public int firstPositiveNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k + 1) {
                return k + 1;
            }
        }

        return nums.length + 1;

    }
}
