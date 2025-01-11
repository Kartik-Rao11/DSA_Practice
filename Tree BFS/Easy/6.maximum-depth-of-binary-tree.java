
/**
 * Leetcode question :
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * Approach :
 * 1. Start level order traversal incrementing height after every level
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
    public int maxHeightOfTree(TreeNode root) {
        int maxLen = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            maxLen++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }

        return maxLen;

    }
}