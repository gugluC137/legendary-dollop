package com.biswa.dsa.code.linkedlist.day5;

import com.biswa.dsa.util.model.obj.ListNode;

public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
