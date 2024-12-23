/**
 * Leetcode Question Link
 * https://leetcode.com/problems/palindrome-linked-list/description/
 * 
 * Approach:
 * 1. Find the middle of the linked list
 * 2. Reverse from the middle of the linked list
 * 3. Compare the list values one by one
 * 4. reverse the list again from middle to preserve original order of linked
 * list
 * 5. return true if everything is fine
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reversed = reverse(slow);
        ListNode copyOfRev = reversed;
        while (head != null && reversed != null) {
            if (head.val != reversed.val) {
                break;
            }

            head = head.next;
            reversed = reversed.next;
        }

        reverse(copyOfRev);
        if (head == null || reversed == null) {
            return true;
        }

        return false;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}