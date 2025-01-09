/*
 * Given a binary tree, connect each node with its level order successor. The
 * last node of each level should point to the first node of the next level.
 * 
 */

import java.util.*;;

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
    public TreeNode connectAllNodes(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode previous = null;
        TreeNode currNode = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            currNode = queue.poll();
            if (previous != null) {
                previous.next = currNode;
            }

            previous = currNode;
            if (currNode.left != null) {
                queue.add(currNode.left);
            }

            if (currNode.right != null) {
                queue.add(currNode.right);
            }
        }

        return root;
    }
}