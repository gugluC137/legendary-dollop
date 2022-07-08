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

}
