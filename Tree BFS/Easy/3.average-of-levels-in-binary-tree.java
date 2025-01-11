
/**
 * Leetcode question :
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * 
 * Approach:
 * 1. start Level order traversal and after each level save the average.
 */

import java.util.*;;

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
    public List<Integer> averageOfLevels(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                levelSum += currNode.value;
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            result.add(levelSum / levelSize);
        }
        return result;

    }
}