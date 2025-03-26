/**
 * Leetcode question link :
 * https://leetcode.com/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * 1. Iterate through array calculating the maxAltitutde for each point.
 * Starting from 0 to n.
 */

class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0, currAlt = 0;
        for (int g : gain) {
            currAlt += g;
            maxAltitude = Math.max(maxAltitude, currAlt);
        }
        return maxAltitude;
    }
}