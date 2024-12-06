import java.util.HashMap;

/**
 * Leet Code question link
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ws = 0;
        int we = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        for (we = 0; we < s.length(); we++) {
            char c = s.charAt(we);
            if (freq.containsKey(c)) {
                ws = Math.max(ws, freq.get(c) + 1);
            }
            freq.put(c, we);
            maxLen = Math.max(maxLen, we - ws + 1);
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}