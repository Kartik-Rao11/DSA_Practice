
/**
 * Leetcode Question link
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 */

class Solution {
    public int[] sortedSqaure(int[] nums) {
        int highestSqaureIndex = nums.length - 1;
        int start = 0;
        int end = nums.length - 1;
        int[] arr = new int[nums.length];
        while (start < end) {
            int startSquare = nums[start] * nums[start];
            int endSquare = nums[end] * nums[end];
            if (startSquare > endSquare) {
                arr[highestSqaureIndex] = startSquare;
                start++;
            } else {
                arr[highestSqaureIndex] = endSquare;
                end--;
            }

            highestSqaureIndex--;
        }

        return arr;
    }
}