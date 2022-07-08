package com.biswa.dsa.code.linkedlist.day5;

import com.biswa.dsa.util.model.obj.ListNode;
import java.util.Objects;

public class DeleteNodeInLinkedList {

    public ListNode deleteMiddleNode(ListNode head) {

        if (Objects.isNull(head) || Objects.isNull(head.next))
            return null;

        ListNode slow = head, fast = head;
        ListNode slowPrev = null;

        while (Objects.nonNull(fast)
          && Objects.nonNull(fast.next)) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        deleteNode(slowPrev, slow);

        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (Objects.isNull(head) || Objects.isNull(head.next)) return null;

        ListNode first = head, second = head;
        ListNode secondPrev = null;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (Objects.nonNull(first)) {
            first = first.next;
            secondPrev = second;
            second = second.next;
        }

        if (Objects.isNull(secondPrev)) {
            head = head.next;
        } else {
            deleteNode(secondPrev, second);
        }

        return head;
    }

    private void deleteNode(ListNode prev, ListNode cur) {
        prev.next = cur.next;
        cur.next = null;
    }

    public void deleteNodeWithoutHead(ListNode node) {
        if (null == node || null == node.next) return;

        ListNode prev = node, cur = node.next;

        while (null != cur.next) {
            swapNodes(prev, cur);

            prev = cur;
            cur = cur.next;
        }

        swapNodes(prev, cur);
        prev.next = null;
    }

    private void swapNodes(ListNode node1, ListNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

}
