package com.biswa.dsa.code.linkedlist.day6;

import com.biswa.dsa.util.model.obj.ListNode;

public class ReverseKNodeGroup {

    // Time: O(N), O[(N/k)*k]
    // Space: O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head || null == head.next) return head;

        ListNode p0 = null; //to maintain the prev Node while reversal
        ListNode p1 = head, p2 = head; //range to reverse
        ListNode p3 = head.next; //to maintain the next node while reversal
        ListNode temp; // node to be used while swapping
        int count;

        while (null != p3) {
            //count for number of nodes travelled (find the group to be reversed)
            count = k-1;

            //loop to find the range of nodes to reverse
            //loop breaks:
            //  if we reach the end of list
            //  if k nodes are not available to reverse
            while (null != p3) {
                p2 = p2.next;
                p3 = p3.next;
                count--;
                if (count == 0) break;
            }
            //if we do not get k nodes to reverse, we break out of this process
            if (count != 0) break;

            reverseList(p1, p2);
            temp = p1;
            p1 = p2;
            p2 = temp;

            //updating the pointers------------------------
            if (null == p0) {
                head = p1;
            } else {
                p0.next = p1;
            }
            p2.next = p3;
            //-------------------------
            p0 = p2;
            p1 = p3;
            p2 = p3;
            if (null != p3) {
                p3 = p3.next;
            }
            //---------------------------------------------
        }

        return head;
    }

    private void reverseList(ListNode start, ListNode end) {
        ListNode prev = null, cur = start, next = start.next;

        while (end.next != next) {
            cur.next = prev;

            prev = cur;
            cur = next;
            next = next.next;
        }

        cur.next = prev;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode ptr = head;
        for (int i = 2; i <= 6; i++) {
            ptr.next = new ListNode(i);
            ptr = ptr.next;
        }

        ReverseKNodeGroup obj = new ReverseKNodeGroup();
        head.printList();
        head = obj.reverseKGroup(head, 2);
        head.printList();
    }

}
