
/**
 * Leetcode question Link :
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/submissions/1504796223/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * 1. Use bfs -> since we need level wise calculation.
 * 2. For every level get the sum of nodes -> maxSumAtLevel.
 * 3. After a level has proccessed check if curr maxSumAtLevel > maxSumAtLevel
 * seen so far then upate the level.
 * Time complexity -> O(N)
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxLevel = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int currLevel = 0;
        while (!queue.isEmpty()) {
            currLevel++;
            int levelSize = queue.size();
            int maxValueAtLevel = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                maxValueAtLevel += currNode.val;
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }

                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }

            if (maxValue < maxValueAtLevel) {
                maxValue = maxValueAtLevel;
                maxLevel = currLevel;
            }

        }

        return maxLevel;
    }
}