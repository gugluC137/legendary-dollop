package com.biswa.dsa.code.linkedlist.day7;

import com.biswa.dsa.util.model.enums.Side;
import com.biswa.dsa.util.model.obj.ListNode;

public class RotateList {

    //Time: O(N)
    //space: O(1)
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || null == head.next) return head;

        int len = head.getLength();
        k %= len;

        if (k == 0) return head;

        ListNode ptr1 = head, ptr2 = head;

        while (k-- > 0) {
            ptr2 = ptr2.next;
        }

        while (null != ptr2.next) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ListNode newHead = ptr1.next;
        ptr1.next = null;
        ptr2.next = head;

        return newHead;
    }

    //Time: O(N)
    //space: O(1)
    public ListNode rotateLeft(ListNode head, int k) {
        if (null == head || null == head.next) return head;

        int len = head.getLength();
        k %= len;

        if (k == 0) return head;

        int diff = len - k;

        ListNode ptr1 = head, ptr2 = head;

        while (diff-- > 0) {
            ptr2 = ptr2.next;
        }

        while (null != ptr2.next) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ListNode newHead = ptr1.next;
        ptr1.next = null;
        ptr2.next = head;

        return newHead;
    }

    public ListNode rotateList(ListNode head, int rotateBy, Side side) {
        return switch (side) {
            case LEFT -> rotateLeft(head, rotateBy);
            case RIGHT -> rotateRight(head, rotateBy);
        };
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;

        for (int i = 2; i <= 5; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        head.printList();

        RotateList obj = new RotateList();
        ListNode ans = obj.rotateList(head, 1, Side.RIGHT);
        ans.printList();
    }
}
