import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode question link :
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach :
 * 1. Get the max candies from Array.
 * 2. Iterate over the candies add candies[i] + extraCandies map the result in
 * the resultant array
 * 
 * Time Complexity :
 * O(n) -> Two passes
 */

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }

        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= maxCandies);
        }

        return result;
    }
}