package leetcode._148;

import leetcode.ListNode;

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        var mid = middle(head);
        var next = mid.next;
        mid.next = null;

        var left = sortList(head);
        var right = sortList(next);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null || right == null)
            return left == null ? right : left;

        var rez = new ListNode(0, null);
        var iter = rez;
        for (; left != null && right != null; iter = iter.next) {
            if (left.val < right.val) {
                iter.next = left;
                left = left.next;
                continue;
            }
            iter.next = right;
            right = right.next;
        }
        iter.next = (left == null) ? right : left;

        return rez.next;
    }


    private ListNode middle(ListNode head) {
        var slow = head;
        var fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
