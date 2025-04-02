
/**
 * Leetcode question link :
 * https://leetcode.com/problems/online-stock-span/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * For every stock price entered we need to return the span -> the span is the
 * no of days the price of the stock was equal to or less than current price.
 * 
 * Approach:
 * 1. Again we can use a monotonicaly increasing stack keeping track of the
 * price and span.
 * 2. Everytime a stock price is added we check from top of our stack if it is
 * equal or less than current price.
 * if yes -> get the span of stock from the stack poping the peeked elements,
 * add the current price with it's updated span.
 * 3. return the span
 * 
 */
import java.util.*;

class StockSpanner {
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[] { price, span });
        return span;
    }
}