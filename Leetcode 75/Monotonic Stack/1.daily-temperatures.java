/**
 * Leetcode question link :
 * https://leetcode.com/problems/daily-temperatures/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * No of days we have to wait to get a warmer temprature. We can use increasing
 * monotonic stack.
 * This will keep track of increasing tempratures and anytime we encounter a
 * temprature which is greater than top of our stack means we found a hotter
 * day.
 * Now calculate how many days you waited until there is a hotter day.
 * 
 * 1. Intialize a stack.
 * 2. Iterate over the temprature array one by one
 * 3. A while loop to calculate the no. of days you waited that runs only if
 * stack is not empty and stack.peek element is < currentTemprature (hotter day
 * is here)
 * pop the last cold index calcualte the no. of days = stack.pop - currentIndex
 * 4. And push the currentTemp to stack to find next hotter day.
 * 
 * Time complexity -> O(N) every element is processed once and stack operation
 * take O(1)
 * overall time complexity -> O(N)
 * 
 */
import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }

            stack.push(i);

        }

        return res;

    }
}