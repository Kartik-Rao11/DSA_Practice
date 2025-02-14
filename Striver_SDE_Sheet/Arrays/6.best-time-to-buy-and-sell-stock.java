/**
 * Leetcode Question Link :
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }

            int currProfit = price - minPrice;
            maxProfit = Math.max(currProfit, maxProfit);

        }

        return maxProfit;
    }
}