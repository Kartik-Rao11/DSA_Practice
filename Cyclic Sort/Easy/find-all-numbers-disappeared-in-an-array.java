import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode question link :
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * 
 * Approach:
 * 1. Sort the array using cyclic sort.
 * 2. Iterate the array to find nums[i] != i + 1. since the range is from 1 to
 * n, the correct number at any index will be index + 1.
 */

class Solution {

    public Integer[] findAllMissingNumbers(int[] nums) {
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
                res.add(k + 1);
            }
        }

        return res.toArray(new Integer[0]);
    }
}