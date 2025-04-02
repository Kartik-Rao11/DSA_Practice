
/**
 * Leetcode question link :
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach :
 * 1. Use minHeap as priority queue of size k. Since minHeap poll() the smallest
 * element from list.
 * 2. Iterate over the elements adding them to minHeap. If minHeap size exceeds
 * the size k pop the smallest element.
 * 3. At the end of iteration minHeap will have final K largest elements. As we
 * keeping popping the smallest element after size k.
 * 4. Return the Kth largest by poping from the minHeap. minHeap's smallest
 * element is the kth largest element.
 * 
 */
import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.poll();
    }
}