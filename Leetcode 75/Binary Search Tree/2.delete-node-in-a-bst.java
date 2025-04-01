/**
 * Leetcode question link :
 * https://leetcode.com/problems/delete-node-in-a-bst/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * 1. Search the node using the bst property make a reference of the parent node
 * and the node that is to be deleted.
 * 2. After finding the node there are 3 cases:
 * a) Deleting node has no child -> simply delete the node
 * b) Deleting node has only child (either left or right) just append the next
 * of deleting node to parent's left or right node.
 * c) Deleting node has both the right and left child. We need to find the
 * inorder successor of that deleting node.
 * Inorder successor is the leftmost element in the right subtree as it will
 * have value greater than deleting node.
 * Go to right subtree of the deleting node and find the left most node keeping
 * track of the leftNode as well it's parent.
 * Once we have leftNode assign it's value to the node that is to be deleted.
 * And replace the leftNode parent with left's Node right from the successor or
 * leftNode was removed.
 * 
 */

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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null, curr = root;

        while (curr != null && curr.val != key) {
            parent = curr;
            if (key < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if (curr == null)
            return root;

        if (curr.left == null || curr.right == null) {
            TreeNode child = curr.left != null ? curr.left : curr.right;
            if (parent == null)
                return child;
            if (parent.left == curr)
                parent.left = child;
            else
                parent.right = child;
        } else {
            TreeNode successorParent = curr;
            TreeNode successor = curr.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            curr.val = successor.val;
            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }

        }

        return root;
    }
}