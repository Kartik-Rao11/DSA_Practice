import java.util.HashMap;

/**
 * Leet Code question link
 * https://leetcode.com/problems/fruit-into-baskets/description/
 */
class Solution {
    public int totalFruit(int[] fruits) {
        int ws = 0;
        int we = 0;
        int maxFruits = Integer.MIN_VALUE;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (we = 0; we < fruits.length; we++) {
            int fruit = fruits[we];
            if (freq.containsKey(fruit)) {
                freq.put(fruit, freq.get(fruit) + 1);
            } else {
                freq.put(fruit, 1);
            }

            while (freq.size() > 2) {
                int newFruit = fruits[ws];
                freq.put(newFruit, freq.get(newFruit) - 1);
                if (freq.get(newFruit) <= 0) {
                    freq.remove(newFruit);
                }
                ws++;
            }
            maxFruits = Math.max(maxFruits, we - ws + 1);
        }
        return maxFruits == Integer.MIN_VALUE ? -1 : maxFruits;
    }
}