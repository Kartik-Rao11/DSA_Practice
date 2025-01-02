/**
 * Leet code question link :
 * https://leetcode.com/problems/rotate-list/description/
 * Given the head of a Singly LinkedList and a number K, rotate the LinkedList
 * to the right by K nodes.
 * Approach:
 * 1. Since we need to rotate from right by k nodes.Connect the last node of
 * linked list to the current list as after rotation tail will be different.
 * 2. Now we need to iterate the list till we reach just before the nodes that
 * we want to rotate.
 * 3. now we know node just next will be the head and current node will be the
 * tail.
 * 
 * Dry run for better understanding!!
 */

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public Node rotateList(Node head, int k) {
        if (head == null || k <= 0)
            return head;
        int listLen = 1;
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            listLen++;
        }
        lastNode.next = head;
        // no need to do rotation more than the length of the list
        k %= listLen;
        int skipNodes = listLen - k;
        Node lastRotatedNode = head;
        for (int i = 0; i < skipNodes - 1; i++) {
            lastRotatedNode = lastRotatedNode.next;
        }

        head = lastRotatedNode.next;
        lastRotatedNode.next = null;
        return head;

    }
}