/**
 * Leetcode question link
 * https://leetcode.com/problems/reorder-list/description/
 * 
 * Approach:
 * 1. Find the middle of the linked list
 * 2. Reversed the list
 * 3. Iterate through the first half and second half. Assgin the elements
 * according to the requirement
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
    public void reorder(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node secondHalf = reverse(slow);
        while (head != null && secondHalf != null) {
            Node temp = head.next;
            head.next = secondHalf;
            head = temp;

            temp = secondHalf.next;
            secondHalf.next = head;
            secondHalf = temp;
        }

        if (head != null) {
            head.next = null;
        }

    }

    public Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
