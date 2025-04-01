
/**
 * Leetcode question link :
 * https://leetcode.com/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach :
 * 1. Use bfs on tree. This we are processing the elements breadth wise rather
 * going direct into depth.
 * 2. For right view -> In binary tree if root node has two child it's levelSize
 * is = 2 and 2nd node or right node is the right view. Similarly if it has only
 * one node. that will become the right side view, so we can say nodes which are
 * at breadth of the level of a node.
 * 
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                if (i == levelSize - 1) {
                    res.add(currNode.val);
                }
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }

                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
        }

        return res;
    }
}