/**
 * Leetcode question link :
 * https://leetcode.com/problems/find-peak-element/?envType=study-plan-v2&envId=leetcode-75
 * 
 * We have time contraint of O(logn) which means we cannot directly iterate the
 * array. So binary search is the best option.
 * 
 * We know that in the array if a element[i] < element[i + 1] the peak must lie
 * in the right half of the array or on the side > i + 1 coz for peak element
 * the next element should be decreasing.
 * 
 * similary if a element[i] > element[i+1], this element could be peak or
 * elements to the left.
 * 
 * Time complexity -> O(N)
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
