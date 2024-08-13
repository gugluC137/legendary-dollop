package com.biswa.dsa.code.random;

import com.biswa.dsa.util.model.obj.Pair;

import java.util.Stack;

public class MinStack {
    private final Stack<Pair> st;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new Pair(val, val));
        } else {
            st.push(new Pair(val, Math.min(val, st.peek().y)));
        }
    }

    public int pop() {
        if (st.isEmpty()) return -1;

        Pair popped = st.pop();
        return popped.x;
    }

    public int top() {
        if (st.isEmpty()) return -1;

        return st.peek().x;
    }

    public int getMin() {
        return st.peek().y;
    }
}
