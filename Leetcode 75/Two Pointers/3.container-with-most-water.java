/**
 * Leetcode question link:
 * https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach (Two pointer):
 * We need to calcualte the maxArea formed between two lines.
 * 1. Set one pointer to 0th of array and one pointer to array.length-1
 * 2. Calculate the breadth (distance bw two lines) and height must be the
 * minimum of two as if we choose bigger heights water will overflow.
 * 3. After iteration we will move the smaller heights as larger heights will
 * have potential to have max area.
 * 
 * Time complexity -> O(N)
 * 
 */

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (left < right) {

            int breadth = right - left;
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(h * breadth, maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;

    }
}