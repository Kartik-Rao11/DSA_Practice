
/**
 * Leetcode question :
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 * 
 * Approach:
 * 1. Same as the level order of a tree. while pushing the values in the
 * resultant array we need to make sure it's added in the front. so we have
 * reversed level order
 */

import java.util.*;

class TreeNode {
    int value;
    TreeNode right;
    TreeNode left;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    public List<List<Integer>> reverseLevelOrder(TreeNode root) {
        // return type of result is LinkedList<List<Integer>> and of our function is
        // List<List<Integer>> it is allowed due to polymorphism in java as LinkedList
        // implements the interface List and LinkedList is subtype of List and hence can
        // be returned
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.value);
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            // for reverse order
            result.addFirst(currLevel);
        }
        return result;
    }
}