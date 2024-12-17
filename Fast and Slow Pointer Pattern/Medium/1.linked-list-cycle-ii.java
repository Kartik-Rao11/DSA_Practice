class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public Node startOfLinkedList(Node head) {
        // 1. Find the cyle
        // 2. Find the length
        // 3. Move the one pointer2 to -> length
        // 4. Move one pointer1 from head and pointer 2 by one step each
        // 5. Return the node if (pointer1 and pointer 2 matched)
        Node fast = head;
        Node slow = head;
        int len = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                len = calculateLen(slow);
            }
        }

        if (len > 0) {
            return findStart(head, len);
        } else {
            return null;
        }
    }

    public int calculateLen(Node slow) {
        Node current = slow;
        int cycleLength = 0;
        while (true) {
            current = current.next;
            cycleLength++;
            if (current == slow) {
                break;
            }
        }

        return cycleLength;
    }

    public Node findStart(Node head, int cycleLength) {
        Node p1 = head;
        Node p2 = head;
        while (cycleLength > 0) {
            p2 = p2.next;
            cycleLength--;
        }

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == p2) {
                break;
            }
        }

        return p2;
    }
}