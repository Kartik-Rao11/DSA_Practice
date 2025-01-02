/**
 * Leetcode question link :
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
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
    public Node reverseKGroup(Node head, int k) {
        Node curr = head;
        Node prev = null;
        while (true) {
            Node lastNodeOfFirstPart = prev;
            Node lastNodeOfSubList = curr;
            int i = 0;
            while (curr != null && i < k) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                i++;
            }

            if (lastNodeOfFirstPart != null) {
                lastNodeOfFirstPart.next = prev;
            } else {
                head = prev;
            }

            lastNodeOfSubList.next = curr;

            if (curr == null) {
                break;
            }

            prev = lastNodeOfSubList;
        }
        return head;
    }

}