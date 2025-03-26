import java.util.*;
/**
 * Leetcode question link :
 * https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * 1. Use Hashmap to count the number of frequencies of nums by iterating over
 * them.
 * 2. Use set and add the frequencies of each number in set and if it already
 * contains a freq then it is not unique return false
 * 
 * Time complexity -> O(N)
 * 
 */

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int n : arr)
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        Set<Integer> set = new HashSet<>();

        for (int n : freq.values()) {
            if (!set.add(n)) {
                return false;
            }

            set.add(n);
        }

        return true;
    }
}
