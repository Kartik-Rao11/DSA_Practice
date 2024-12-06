import java.util.HashMap;

/**
 * GFG Question
 * https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
 */
class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int ws = 0;
        int we = 0;
        int longLen = Integer.MIN_VALUE;
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
            //for exact we calculate the size when it is exactly equal to K
            if (freq.size() == k) {
                longLen = Math.max(longLen, we - ws + 1);
            }

        }
        return longLen == Integer.MIN_VALUE ? -1 : longLen;
    }
}