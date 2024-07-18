package com.biswa.dsa.util;

import com.biswa.dsa.util.model.ArrayElement;

public final class CustomImmutableObject {
    private final int num;
    private final String str;
    private final ArrayElement elem;

    public CustomImmutableObject(int num, String str, ArrayElement elem) {
        this.num = num;
        this.str = new String(str.toCharArray());
        this.elem = new ArrayElement(elem.idx, elem.value);
    }

    public int getNum() {
        return this.num;
    }

    public String getStr() {
        return this.str;
    }

    public ArrayElement getElem() {
        return new ArrayElement(this.elem.idx, this.elem.value);
    }

    @Override
    public int hashCode() {
        return this.num + this.str.hashCode() + this.elem.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            throw new NullPointerException("Object entered is empty");
        } else if(obj.getClass()!=this.getClass()) {
            throw new IllegalArgumentException("Object entered is not CustomImmutableObject");
        } else {
            CustomImmutableObject c = (CustomImmutableObject) obj;
            return this.num == c.num
                && this.str.equals(c.str)
                && this.elem.equals(c.elem);
        }
    }
}
