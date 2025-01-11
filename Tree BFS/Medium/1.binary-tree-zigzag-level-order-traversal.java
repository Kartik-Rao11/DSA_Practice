
/**
 * Leetcode question link :
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 */
import java.util.*;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }
}

class Solution {

    public List<List<Integer>> zigzagOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> currLevel = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();

                if (leftToRight) {
                    currLevel.add(currNode.value);
                } else {
                    currLevel.addFirst(currNode.value);
                }

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            result.add(currLevel);
            leftToRight = !leftToRight;
        }
        return result;
    }
}