/**
 * Leet code question :
 * https://leetcode.com/problems/reverse-linked-list/description/
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 * Approach:
 * 1. For inplace we will be needing previous, current and next pointer.
 * 2. previous will keep track of previous node (initally null) and current will
 * keep track of current node (intially head) and next will hold the next
 * pointer.
 * 
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
    public Node reverseLinkedList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}