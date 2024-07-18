package com.biswa.dsa.util;

import com.biswa.dsa.util.model.ArrayElement;

import java.util.HashMap;
import java.util.Map;

public final class CustomObjectConstantPool {
    private final Map<Integer, CustomImmutableObject> constantPool;

    private CustomObjectConstantPool() {
        System.out.println("CustomObjectConstantPool ...");
        this.constantPool = new HashMap<>();
    }

    private static final class InstanceHolder {
        static {
            System.out.println("InstanceHolder ...");
        }
        private static final CustomObjectConstantPool INSTANCE = new CustomObjectConstantPool();
    }

    public static CustomObjectConstantPool getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public CustomImmutableObject getNewCustomImmutableObject(
        int num, String str, ArrayElement elem) {

        int hc = getHashCode(num, str, elem);
        if (constantPool.containsKey(hc)) {
            return constantPool.get(hc);
        } else {
            CustomImmutableObject obj = new CustomImmutableObject(num, str, elem);
            constantPool.put(obj.hashCode(), obj);

            return obj;
        }
    }

    private static int getHashCode(int num, String str, ArrayElement elem) {
        return num + str.hashCode() + elem.hashCode();
    }

    public static void main(String[] args) {
        CustomObjectConstantPool objPool1 = new CustomObjectConstantPool();
        System.out.println("OVER1");
        CustomObjectConstantPool objPool = CustomObjectConstantPool.getInstance();
        System.out.println("OVER");
    }
}
