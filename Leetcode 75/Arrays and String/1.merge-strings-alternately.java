/**
 * Leetcode question link :
 * https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * 1. Use string builder for result. Place the pointer at 0 index of both and
 * appends to result by incrementing.
 * 2. If any of letters are still left from any of the words append that to
 * resultant string
 * 
 * Time complexity -> O(n + m)
 */

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            result.append(word1.charAt(i++));
            result.append(word2.charAt(j++));
        }

        if (word1.length() < word2.length()) {
            result.append(word2.substring(j));
        } else {
            result.append(word1.substring(i));
        }

        return result.toString();
    }
}