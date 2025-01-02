
/**
 * Leetcode Question link: https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and 
 * each integer appears at most twice, return an array of all the integers that appears twice.
 * Approach:
 * 1. Sort the number using cyclic sort
 * 2. Find the numbers which are not a correct index and push them in the array
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAllDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k + 1) {
                res.add(nums[k]);
            }
        }

        return res;
    }
}