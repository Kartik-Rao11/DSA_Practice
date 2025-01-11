
/**
 * Leetcode question :
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 
 * Approach :
 * 1. Start the level order traversal and once you hit a leaf node without any
 * child return the length it is the shortest length
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
    public int minimumDepthOfTree(TreeNode root) {
        int minimumLen = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);

        while (!queue.isEmpty()) {
            minimumLen++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left == null && currNode.right == null) {
                    return minimumLen;
                }

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }

        return -1;

    }
}
