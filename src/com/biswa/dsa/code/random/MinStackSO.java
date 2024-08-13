package com.biswa.dsa.code.random;

import java.util.Stack;

public class MinStackSO {
    private final Stack<Integer> st;
    private int min;

    public MinStackSO() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(val);
            min = val;
        } else if(val < min) {
            st.push(2*val - min);
            min = val;
        } else {
            st.push(val);
        }
    }

    public int pop() {
        if (st.isEmpty()) return -1;

        if (st.peek() < min) {
            int popped = min;
            min = 2*min - st.peek();
            return popped;
        } else {
            return st.pop();
        }
    }

    public int top() {
        if (st.isEmpty()) return -1;

        if (st.peek() < min) {
            return min;
        } else {
            return st.peek();
        }
    }

    public int getMin() {
        return min;
    }
}
