import java.util.HashMap;

/**
 * Leetcode Question Link
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int ws = 0;
        int maxLen = Integer.MIN_VALUE;
        int maxRepating = 0;
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int we = 0; we < s.length(); we++) {
            char c = s.charAt(we);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
            maxRepating = Math.max(freq.get(c), maxRepating);

            if ((we - ws + 1) - maxRepating > k) {
                char tmp = s.charAt(ws);
                freq.put(tmp, freq.get(tmp) - 1);
                ws++;
            }

            maxLen = Math.max(maxLen, we - ws + 1);

        }
        return maxLen == Integer.MIN_VALUE ? -1 : maxLen;
    }
}