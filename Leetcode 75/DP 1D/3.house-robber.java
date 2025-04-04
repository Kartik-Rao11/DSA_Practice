/**
 * Leetcode question link :
 * https://leetcode.com/problems/house-robber/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * To get to the heart of this problem, let's discuss the intuition behind the
 * solution.
 * 
 * The main idea here is dynamic programming, which involves breaking the
 * problem down into smaller subproblems and building up a solution from the
 * answers to those subproblems.
 * 
 * Now, consider the following choices at each house: either you rob it or you
 * don't. If you decide to rob house i, you cannot rob house i-1, but you are
 * free to rob house i-2 and before. If you decide not to rob house i, your best
 * robbery amount up to house i is the same as if you were standing at house
 * i-1.
 * 
 * Let's define two variables: f and g. We'll use f to track the maximum amount
 * we can rob up to the current house if we don't rob this house, and g to track
 * the maximum amount if we do rob it.
 * 
 * We update f like this: We take the max between the previous f (not robbing
 * the previous house) and g (robbing the previous house) because for the
 * current house, we are not robbing it, so we are free to choose the maximum
 * loot collected from the previous two states.
 * 
 * On the other hand, we update g by adding the current house's money to the
 * previous f, because if we decide to rob this house, we can't rob the previous
 * one, so we add to f (the max money robbed without including the previous
 * house).
 * 
 * Lastly, we have to return the maximum amount we can rob including or
 * excluding the last house, which means we return the max between f and g.
 */

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int prev2 = 0;
        int prev1 = 0;

        for (int n : nums) {
            int curr = Math.max(prev1, n + prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return Math.max(prev2, prev1);
    }
}