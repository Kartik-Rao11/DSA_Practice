
/**
 * Leetcode question link :
 * https://leetcode.com/problems/total-cost-to-hire-k-workers/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * since we can choose the number of candidates from the cost array from left
 * and right. And We need to calculate total cost in K rounds.
 * 
 * 1.Use minHeap to store first candidates as left heap and last candidates as
 * right heap.
 * 2. And iterate K times to hire the candidates, according to given conditions,
 * if(leftHeapCost <= rightHeapCost) we choose from leftHeap and add another
 * candidate into leftHeap,
 * else we choose from right heap and add another candidate cost into right
 * heap.
 */
import java.util.*;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int left = 0, right = costs.length - 1;

        while (left < candidates)
            leftHeap.offer(costs[left++]);
        while (right >= costs.length - candidates && right >= left)
            rightHeap.offer(costs[right--]);
        long totalCost = 0;
        for (int i = 0; i < k; i++) {
            if (!leftHeap.isEmpty() && (rightHeap.isEmpty() || leftHeap.peek() <= rightHeap.peek())) {
                totalCost += leftHeap.poll();
                if (left <= right)
                    leftHeap.offer(costs[left++]);
            } else {
                totalCost += rightHeap.poll();
                if (left <= right)
                    rightHeap.offer(costs[right--]);
            }
        }

        return totalCost;

    }
}