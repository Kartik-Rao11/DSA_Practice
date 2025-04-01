
/**
 * Leetcode question link :
 * https://leetcode.com/problems/successful-pairs-of-spells-and-potions/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * Intution -> For every spell from spells we need to check if the spell * position >= success. 
 * Since we already know success we can directly find the min value needed to make spell success by success / spell.
 * If we have that min value to make the value success we can apply binary search on potions. 
 * To successfully apply binary search sort the potions array.
 * 
 * For min value we take -> ciel value : the smallest value greater than or equal to input number. 
 * 
 */
import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int target = (int) Math.ceil((double) success / spell);
            int index = binarySearch(target, potions);
            res[i] = m - index;
        }

        return res;
    }

    public int binarySearch(int target, int[] potions) {
        int low = 0, high = potions.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (target <= potions[mid])
                high = mid;
            else
                low = mid + 1;

        }

        return low;
    }
}