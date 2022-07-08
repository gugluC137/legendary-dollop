package com.biswa.dsa.code.linkedlist.day6;

import com.biswa.dsa.util.model.obj.ListNode;

public class IntersectionOfYList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lA = getLength(headA);
        int lB = getLength(headB);

        int diff;
        if (lA > lB) {
            diff = lA-lB;
            headA = moveListHead(headA, diff);
        } else {
            diff = lB-lA;
            headB = moveListHead(headB, diff);
        }

        ListNode ans = null;
        while (null != headA && null != headB) {
            if (headA == headB){
                ans = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return ans;
    }

    private ListNode moveListHead(ListNode head, int places) {
        for (int i = 0; i < places; i++) {
            head = head.next;
        }
        return head;
    }

    private int getLength(ListNode head) {
        int l = 0;
        while (null != head) {
            l++;
            head = head.next;
        }
        return l;
    }

    public ListNode getIntersectionNodeII(ListNode headA, ListNode headB){
        ListNode nodeA = headA, nodeB = headB;

        while (nodeA != nodeB) {
            nodeA = null == nodeA ? headB : nodeA.next;
            nodeB = null == nodeB ? headA : nodeB.next;
        }

        return nodeA;
    }

}
