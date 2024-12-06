import java.util.HashMap;

class Solution {
    int longestKsubStr(String s, int k) {
        int maxLen = Integer.MIN_VALUE;
        int ws = 0;
        int we = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        for (we = 0; we < s.length(); we++) {
            char c = s.charAt(we);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }

            while (freq.size() > k) {
                char newC = s.charAt(ws);
                freq.put(newC, freq.get(newC) - 1);
                if (freq.get(newC) == 0) {
                    freq.remove(newC);
                }
                ws++;
            }
            maxLen = Math.max(maxLen, we - ws + 1);

        }

        return maxLen == Integer.MIN_VALUE ? -1 : maxLen;
    }
}