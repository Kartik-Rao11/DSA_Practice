/**
 * Leetcode question link :
 * https://leetcode.com/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach :
 * 1. Iterate over the array calculating the first, second and third largest any
 * time we hit the third largest. return true else false
 * 
 * Time Complexity -> O(n)
 */

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;

    }
}