import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode question :
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * Approach :
 * 1. Start Level Order Traversal. At each level connected the next of previous
 * node to the current.
 */

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}

class Solution {
    public TreeNode nextRightPointer(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode prev = null;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                if (prev != null) {
                    prev.next = currNode;
                }

                prev = currNode;

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }

                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
        }

        return root;
    }
}