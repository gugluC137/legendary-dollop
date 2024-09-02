package com.biswa.dsa.temp;


import com.biswa.dsa.util.model.obj.Pair;

import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        TreeSet<Pair> set = new TreeSet<>();
        set.add(new Pair(1, 10));
        set.add(new Pair(2, 100));
        set.add(new Pair(3, 5));

        if (set.contains(new Pair(4, 10))) {
            System.out.println("Found");
        }


        System.out.println(set);
    }
}
