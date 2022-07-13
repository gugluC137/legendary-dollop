package com.biswa.dsa.util.model.obj;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
        this(0, null);
    }

    public ListNode(int value) {
        this(value, null);
    }

    public ListNode(int value, ListNode next) {
        this.val = value;
        this.next = next;
    }

    public void printList() {
        ListNode cur = this;
        while (null != cur.next) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println(cur.val);
    }

    public int getLength() {
        ListNode cur = this;
        int count = 0;
        while (null != cur) {
            count++;
            cur = cur.next;
        }
        return count;
    }

}
