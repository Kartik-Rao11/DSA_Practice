
/**
 * Leetcode question:
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 * 
 * Approach:
 * 1. Start Level order traversal at every level find the max and after a level
 * save the ans in the array and repeat.
 * 
 */
import java.util.*;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    public List<Integer> maxValueOfLevel(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();

                maxValue = Math.max(maxValue, currNode.value);

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            result.add(maxValue);
        }
        return result;
    }
}