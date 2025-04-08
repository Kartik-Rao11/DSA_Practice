/**
 * Leetcode question link:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * This problem is a variation of the "Best Time to Buy and Sell Stock" where we
 * have to pay a transaction fee whenever we make a sale.
 * 
 * To maximize profit:
 * 
 * We have two states:
 * 
 * Holding a stock (we have bought one but not sold yet).
 * 
 * Not holding a stock (we have either sold or haven't bought one).
 * 
 * Decisions at each day (i):
 * 
 * If we hold the stock, we can:
 * 
 * Sell it at prices[i] (gain profit but pay fee).
 * 
 * Do nothing (keep holding).
 * 
 * If we don’t hold a stock, we can:
 * 
 * Buy at prices[i] (reduce profit).
 * 
 * Do nothing (stay in the same state).
 * 
 * 
 * We use Dynamic Programming (DP) with State Optimization:
 * 
 * hold: Maximum profit if we hold a stock at day i.
 * 
 * notHold: Maximum profit if we don’t hold a stock at day i.
 * 
 * At each day:
 * 
 * If we hold a stock (hold[i]), then:
 * 
 * Either we keep holding: hold[i] = hold[i-1]
 * 
 * Or we buy a stock today: hold[i] = notHold[i-1] - prices[i]
 * 
 * Take the maximum of both.
 * 
 * If we do not hold a stock (notHold[i]), then:
 * 
 * Either we do nothing: notHold[i] = notHold[i-1]
 * 
 * Or we sell a stock today (and pay the fee): notHold[i] = hold[i-1] +
 * prices[i] - fee
 * 
 * Take the maximum of both.
 * 
 * Time complexity -> O(N)
 * Space complexity -> O(1)
 * 
 */

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int hold = -prices[0];
        int notHold = 0;

        for (int i = 1; i < n; i++) {
            hold = Math.max(hold, notHold - prices[i]);
            notHold = Math.max(notHold, hold + prices[i] - fee);
        }

        return notHold;
    }
}