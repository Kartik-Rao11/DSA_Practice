import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Leetcode question link
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            if (freq.containsKey(p.charAt(i))) {
                freq.put(p.charAt(i), freq.get(p.charAt(i)) + 1);
            } else {
                freq.put(p.charAt(i), 1);
            }

        }
        int matched = 0;
        int ws = 0;
        List<Integer> result = new ArrayList<>();
        for (int we = 0; we < s.length(); we++) {
            Character c = s.charAt(we);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) - 1);
                if (freq.get(c) == 0) {
                    matched++;
                }
            }

            if (matched == freq.size()) {
                result.add(ws);
            }

            if (we >= p.length()-1) {
                Character newC = s.charAt(ws);
                if (freq.containsKey(newC)) {
                    if (freq.get(newC) == 0) {
                        matched--;
                    }
                    freq.put(newC, freq.get(newC)+1);
                }
                ws++;
            }
        }
        return result;
    }
}