/**
 * Given the head of a LinkedList and a number K, reverse every alternating K
 * sized sub-list starting from the head.
 * 
 * If, in the end, you are left with a sub-list with less than K elements,
 * reverse it too.
 * 
 * Approach:
 * 1. Same approach as reversing a sub-list but after reversing k elements while
 * again skip k elements.
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
    public Node reverseKAlternateKElements(Node head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node lastNodeOfFirstHalf = prev;
            Node lastNodeOfSubList = curr;
            int i = 0;
            while (curr != null && i < k) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                i++;
            }
            if (lastNodeOfFirstHalf != null) {
                lastNodeOfFirstHalf.next = prev;
            } else {
                head = prev;
            }

            lastNodeOfSubList.next = curr;
            i = 0;
            while (curr != null && i < k) {
                prev = curr;
                curr = curr.next;
                i++;
            }

        }
        return head;
    }
}