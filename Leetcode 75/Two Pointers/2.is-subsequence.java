/**
 * Leetcode Question Link :
 * https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach
 * 1. Initialize two pointer (i,j) to iterate over the two strings s and t.
 * 2. For every character in t if there is a match in String s will be increment
 * s string pointer.
 * 3. Loop runs until one of the strings has been completely processed.
 * 4. Check if s pointer is equal to s.length then it is subsequence return true
 * else false
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (j < t.length() && i < s.length()) {
            if (t.charAt(j) == s.charAt(i)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}