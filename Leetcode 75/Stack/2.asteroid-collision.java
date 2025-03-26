import java.util.*;
/**
 * Leetcode question link:
 * https://leetcode.com/problems/asteroid-collision/description/?envType=study-plan-v4&envId=leetcode-75
 * 
 * Approach:
 * We need to achieve behaviour where a asteroid is collided with last added
 * element and if it wins it should next after it. This LIFO behaviour which can
 * be achieved by stack.
 * 
 * 1.Iterate for each asteroid mark it as alive.
 * 2. Check stack -> for stack processing currentAsteriod should be -ve that is
 * in opposite direction and top of stack should be greater than 0.
 * In Stack check if -ve of current asteriod is greater than asteriod if yes pop
 * it and go for another iteration stack to check if this currentAster will
 * destory other asteriod or not.
 * if (currAst == Top) pop the top element make current aster alive = false
 * break the while loop
 * if (currAst < top) mark the currAster as alive = false break the while loop
 * 
 * check if the element is alive then add it to the stack
 * 
 */

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currString = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(num);
                stringStack.push(currString);
                num = 0;
                currString = new StringBuilder();
            } else if (c == ']') {
                int repeatCount = countStack.pop();
                StringBuilder decodedString = stringStack.pop();

                for (int i = 0; i < repeatCount; i++) {
                    decodedString.append(currString);
                }

                currString = decodedString;
            } else {
                currString.append(c);
            }
        }

        return currString.toString();
    }
}