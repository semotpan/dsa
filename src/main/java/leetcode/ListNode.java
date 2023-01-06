package leetcode;

import java.util.Objects;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }

    public static ListNode of(int x) {
        return new ListNode(x, null);
    }

    public static ListNode of(int x, ListNode next) {
        return new ListNode(x, next);
    }


    public int val() {
        return val;
    }

    public ListNode next() {
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
