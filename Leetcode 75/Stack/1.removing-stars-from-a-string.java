import java.util.*;

/**
 * Leetcode Question Link :
 * https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * We can have two approaches one using stack and other using stringbuilder
 * inbuild function both the approach follows the concept of LIFO (Last in first
 * Out) any time we encounter * we pop the last char added in the stack or
 * remove last char appended to string as as the element before should be
 * removed.
 * If using stack after complete iteration we need to pop the characters and
 * append it to string and afer that reverse that string for correct answer
 * 
 */

class Solution {
    public String removeStars(String s) {

        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                str.deleteCharAt(str.length() - 1);
            } else {
                str.append(c);
            }
        }

        return str.toString();
    }

    public String removeStringUsingStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*' && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }

        return str.reverse().toString();
    }
}