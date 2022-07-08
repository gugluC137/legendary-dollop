package com.biswa.dsa.code.linkedlist.day5;

import com.biswa.dsa.util.model.obj.ListNode;

public class ReverseList {

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;
        ListNode next;

        while (null != cur) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

}
