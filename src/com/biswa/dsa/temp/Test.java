package com.biswa.dsa.temp;

import com.biswa.dsa.util.model.obj.DisjointSet;

import java.util.Arrays;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        System.out.println(Arrays.stream(a).sum());
        System.out.println(Arrays.stream(a).max().getAsInt());
        var temp = a.clone();
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(a));
        a[0] = 10;
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(a));


//        String s = "hi hello";
//        String[] st = s.split(" ");
//        System.out.println(Arrays.toString(st));
//        System.out.println("blah"+st[1]);
        var st = new HashSet<Integer>();
        var ds = new DisjointSet(3);
        st.add(1);
        st.add(3);
        var s = st.stream().reduce(0, (sum, e) -> sum + ds.findSet(e));
    }

    public int get(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            default -> 0;
        };
    }


}
