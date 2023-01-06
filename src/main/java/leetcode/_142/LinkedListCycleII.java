package leetcode._142;

import leetcode.ListNode;

/**
 * Floyd’s Cycle Finding Algorithm
 */
public class LinkedListCycleII {

    // Floyd’s Cycle Finding Algorithm
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // slow and fast are both to last node
                break;
            }
        }

        // if no loop exists
        if (slow != fast) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
