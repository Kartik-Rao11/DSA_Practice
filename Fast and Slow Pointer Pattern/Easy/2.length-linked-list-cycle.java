class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public int lengthOfCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return calculateCyleLength(slow);
            }
        }

        return 0;

    }

    public int calculateCyleLength(Node slow) {
        Node current = slow;
        int cycleLength = 0;
        while (true) {
            current = current.next;
            cycleLength++;
            if (slow == current) {
                break;
            }

        }

        return cycleLength;
    }
}