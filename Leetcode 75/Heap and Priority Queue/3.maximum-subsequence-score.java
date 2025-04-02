
/**
 * Leetcode question link :
 * https://leetcode.com/problems/maximum-subsequence-score/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * To maximize the score, we intuitively want to select the k indices that would
 * result in the largest possible sum from nums1 while also ensuring that the
 * minimum value selected from nums2 is as high as possible, because it
 * multiplies the entire sum.
 * 
 * If we were just trying to maximize the sum of selected values from nums1, we
 * would simply choose the k highest values. However, the challenge here is that
 * we also need to consider nums2, as its minimum value among the chosen indices
 * will act as a multiplier for our sum from nums1.
 * 
 * This leads to the strategy of pairing the elements from nums1 and nums2 and
 * sorting these pairs in descending order based on the values from nums2,
 * because we are interested in larger values of nums2 due to its role as a
 * multiplier. Now, since our final score involves a sum from nums1 and a
 * minimum from nums2, we wish to select the top k indices with respect to the
 * product of sums and minimums.
 * 
 * After pairing and sorting them on the basis of nums2. Iterate over them
 * calculating the sum.
 * if it goes above k remove it from the heap and subtract from the sum.
 * 
 * if minHeap == k -> calculate the maxScore by multiplying num2 with sum.
 * num2 will be the smallest from the selected index due to sorting.
 * 
 */
import java.util.*;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] { nums2[i], nums1[i] };
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        long maxScore = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            int num2 = pairs[i][0];
            int num1 = pairs[i][1];

            sum += num1;
            minHeap.offer(num1);

            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * num2);
            }
        }

        return maxScore;

    }
}