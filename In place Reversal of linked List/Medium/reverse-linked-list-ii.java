/**
 * Leetcode question :
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 * 
 * Given the head of a LinkedList and two positions p and q, reverse the
 * LinkedList from position p to q.
 * 
 * Approach :
 * We can reverse any list in place if we have previous and current pointer.
 * 1. First iterate the p-1 nodes. So that our current will be at the head of
 * sub list we want to reverse, previous will be on the last node of the first
 * part of the list (just before the head of the sub-list to be reversed).
 * 2. Now reverse the list between the p and q.
 * 3. Now connect the p-1 node (lastNodeofFirstHalf) to the q+1 node.
 */

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        next = null;
    }
}

class Solution {
    public Node reverseBetween(Node head, int p, int q) {
        int i = 0;
        Node prev = null;
        Node curr = head;
        while (curr != null && i < p - 1) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        Node lastNodeofFirstHalf = prev;
        Node lastNodeOfSubList = curr;
        i = 0;
        while (curr != null && i < q - p + 1) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        if (lastNodeofFirstHalf != null) {
            lastNodeofFirstHalf.next = prev;
        } else {
            head = prev;
        }

        lastNodeOfSubList.next = curr;
        return head;
    }
}

/**
 * Some more varation problems that can be solved using this logic
 * 
 * 1) Reverse the first k elements of a given LinkedList.
 * Approach : to reverse the first k nodes of the list, we need to pass p=1 and
 * q=k.
 * 
 * 2) Given a LinkedList with n nodes, reverse it based on its size in the
 * following way:
 * 
 * Case 1) If n is even, reverse the list in a group of n/2 nodes.
 * case 2) If n is odd, keep the middle node as it is, reverse the first n/2
 * nodes and reverse the last n/2 nodes.
 * 
 * Approach:
 * 
 * case 1) When n is even we can perform the following steps:
 * 
 * Reverse first n/2 nodes: head = reverse(head, 1, n/2)
 * Reverse last n/2 nodes: head = reverse(head, n/2 + 1, n)
 * 
 * Case 2) When n is odd, our algorithm will look like:
 * 
 * head = reverse(head, 1, n/2)
 * head = reverse(head, n/2 + 2, n)
 * Please note the function call in the second
 * step. We’re skipping two elements as we will be skipping the middle element.
 */