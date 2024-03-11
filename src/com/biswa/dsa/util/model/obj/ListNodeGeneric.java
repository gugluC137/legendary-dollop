package com.biswa.dsa.util.model.obj;

public class ListNodeGeneric<T> {

    public T val;
    public ListNodeGeneric<T> next;
    public ListNodeGeneric(T value) {
        this(value, null);
    }

    public ListNodeGeneric(T value, ListNodeGeneric<T> next) {
        this.val = value;
        this.next = next;
    }

    public void printList() {
        ListNodeGeneric<T> cur = this;
        while (null != cur.next) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println(cur.val);
    }

    public int getLength() {
        ListNodeGeneric<T> cur = this;
        int count = 0;
        while (null != cur) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}
