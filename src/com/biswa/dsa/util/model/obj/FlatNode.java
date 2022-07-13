package com.biswa.dsa.util.model.obj;

public class FlatNode {

    int data;
    FlatNode next;
    FlatNode child;

    public FlatNode() {
        this(0, null, null);
    }

    public FlatNode(int data) {
        this(data, null, null);
    }

    public FlatNode(int data, FlatNode next, FlatNode child) {
        this.data = data;
        this.next = next;
        this.child = child;
    }

}