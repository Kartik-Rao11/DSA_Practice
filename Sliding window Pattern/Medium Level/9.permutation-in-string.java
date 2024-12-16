import java.util.HashMap;

/**
 * Leetcode question link
 * https://leetcode.com/problems/permutation-in-string/description/
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character, Integer> freq = new HashMap<>();
        int ws = 0;
        int isMatched = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (freq.containsKey(s1.charAt(i))) {
                freq.put(s1.charAt(i), freq.get(s1.charAt(i)) + 1);
            } else {
                freq.put(s1.charAt(i), 1);
            }
        }

        for (int we = 0; we < s2.length(); we++) {
            Character c = s2.charAt(we);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) - 1);
                if (freq.get(c) == 0) {
                    isMatched++;
                }
            }

            if (isMatched == freq.size()) {
                return true;
            }

            if (we >= s1.length() - 1) {
                Character newC = s2.charAt(ws);
                if (freq.containsKey(newC)) {
                    if (freq.get(newC) == 0) {
                        isMatched--;
                    }
                    freq.put(newC, freq.get(newC) + 1);
                }
                ws++;

            }
        }

        return false;

    }
}