package com.biswa.dsa.util.model;

public class ArrayElement {
    public int value;
    public int idx;

    public ArrayElement(int v, int i) {
        this.value = v;
        this.idx = i;
    }

    @Override
    public int hashCode() {
        return (int) Math.ceil(Math.sqrt(Math.pow(this.value, 2) + Math.pow(this.idx, 2)));
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            throw new NullPointerException("Object entered is empty");
        } else if(obj.getClass()!=this.getClass()) {
            throw new IllegalArgumentException("Object entered is not ArrayElement");
        } else {
            ArrayElement c = (ArrayElement) obj;

            return this.value == c.value && this.idx == c.idx;
        }
    }

}
