package com.biswa.dsa.code.linkedlist.day5;

import com.biswa.dsa.util.model.obj.ListNode;

public class Merge2SortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (null == list1) return list2;
        if (null == list2) return list1;

        ListNode ans = new ListNode();
        ListNode cur = ans;

        while (null != list1 && null != list2) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        if (null != list1) {
            cur.next = list1;
        }
        if (null != list2) {
            cur.next = list2;
        }

        return ans.next;
    }

}
