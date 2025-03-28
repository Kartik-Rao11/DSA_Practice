import java.util.*;

/**
 * Leetcode question link :
 * https://leetcode.com/problems/dota2-senate/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach :
 * We can observe it is a round based decision making. Senator from R or D
 * whoever first get's to ban or announce victory will move to next round (if
 * they ban). If they are alone or have majority that group will win.
 * 
 * With this we can observe pattern that first person coming to challenge will
 * either ban and move to next rounds or move out of the game.
 * This is similar to queue pattern which follow first in first out rule.
 * 
 * 1. Make two queue one for Radiant and one for Dire add their respective index
 * the queue.
 * 2. Iterate through the queue until one of them is empty.
 * 3. Start popping from both queues and Senate with lower index will ban the
 * other senate with greater index and will move to the next round.
 * The senate with smaller index will be added in the queue again with updated
 * index i + total senate
 * So that senate can be available again in next round.
 * 4. The queue with remaining elements will be the winning one.
 * 
 * Time complexity -> ?
 */

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rStack = new LinkedList<>();
        Queue<Integer> dStack = new LinkedList<>();
        int n = senate.length();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rStack.offer(i);
            } else {
                dStack.offer(i);
            }
        }

        while (!rStack.isEmpty() && !dStack.isEmpty()) {
            int rTurn = rStack.poll();
            int dTurn = dStack.poll();

            if (rTurn < dTurn) {
                rStack.offer(rTurn + n);
            } else {
                dStack.offer(dTurn + n);
            }
        }

        return rStack.isEmpty() ? "Dire" : "Radiant";
    }
}