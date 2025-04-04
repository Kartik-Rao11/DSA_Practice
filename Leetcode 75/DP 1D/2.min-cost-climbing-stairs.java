/*
 * Leetcode question link :
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * The problem can be solved using dynamic programming. The idea is to keep
 * track of the minimum cost to reach each step, and then use that information
 * to calculate the minimum cost to reach the top of the stairs.
 */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev1 = cost[0];
        int prev2 = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev1 = prev2;
            prev2 = curr;
        }

        return Math.min(prev1, prev2);
    }
}