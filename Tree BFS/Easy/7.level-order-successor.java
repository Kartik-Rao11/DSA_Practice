
/**
 * Given a binary tree and a node, find the level order successor of the given
 * node in the tree. The level order successor is the node that appears right
 * after the given node in the level order traversal
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
    public TreeNode levelOrderSuccessor(TreeNode root, int key) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();

            if (currNode.left != null) {
                queue.add(currNode.left);
            }

            if (currNode.right != null) {
                queue.add(currNode.right);
            }

            if (currNode.value == key)
                break;
        }

        if (queue.size() > 0)
            return queue.poll();

        return null;
    }
}