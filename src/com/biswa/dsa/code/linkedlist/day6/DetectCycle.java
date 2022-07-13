package com.biswa.dsa.code.linkedlist.day6;

import com.biswa.dsa.util.model.obj.ListNode;

public class DetectCycle {

    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next) return false;

        boolean ans = false;

        ListNode ptr1 = head, ptr2 = head;
        while (null != ptr2 && null != ptr2.next) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;

            if (ptr1.equals(ptr2)) {
                ans = true; break;
            }
        }

        return ans;
    }

    public ListNode detectCycleNode(ListNode head) {
        if (null == head || null == head.next) return null;

        ListNode ptr1 = head, ptr2 = head;
        boolean cycleExists = false;
        while (null != ptr2 && null != ptr2.next) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;

            if (ptr1 == ptr2) {
                cycleExists = true;
                break;
            }
        }

        if (cycleExists) {
            ptr1 = head;
            while (ptr1 != ptr2) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            return ptr1;
        }

        return null;
    }

}
