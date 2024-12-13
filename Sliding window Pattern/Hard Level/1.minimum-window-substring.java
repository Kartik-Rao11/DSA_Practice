import java.util.HashMap;
/**
 * Leet code question link
 * https://leetcode.com/problems/minimum-window-substring/description/
 */

class Solution {
    public String minWindow(String s, String t) {
        int ws = 0;
        int minLen = s.length()+1;
        HashMap<Character, Integer> freq = new HashMap<>();
        int isMatched = 0;
        int windowStart = 0;
        for (int i = 0; i < t.length(); i++) {
            if (freq.containsKey(t.charAt(i))) {
                freq.put(t.charAt(i), freq.get(t.charAt(i)) + 1);
            } else {
                freq.put(t.charAt(i), 1);
            }
        }

        for (int we = 0; we < s.length(); we++) {
            Character c = s.charAt(we);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) - 1);
                if (freq.get(c) == 0) {
                    isMatched++;
                }
            }

            while (isMatched == freq.size()) {
                Character newC = s.charAt(ws);
                if (minLen > we - ws + 1) {
                    minLen = we - ws + 1;
                    windowStart = ws;
                }

                if (freq.containsKey(newC)) {
                    if (freq.get(newC) == 0) {
                        isMatched--;
                    }

                    freq.put(newC, freq.get(newC) + 1);
                }
                ws++;
            }
        }

        if (minLen > s.length()) {
            return "";
        }

        return s.substring(windowStart, windowStart + minLen);

    }
}