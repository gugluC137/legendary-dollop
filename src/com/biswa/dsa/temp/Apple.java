package com.biswa.dsa.temp;

import com.biswa.dsa.util.model.obj.Pair;

import java.util.stream.IntStream;

public class Apple {
    static int staticTemp = 10;
    private int instanceTemp;
    private Pair pair;

    public Apple() {
        this.instanceTemp = 111;
    }

    public void setInstanceTemp(int val) {
        this.instanceTemp = val;
    }

    public void setPair(Pair val) {
        this.pair = val;
    }

    public int getInstanceTemp() {
        return this.instanceTemp;
    }

    public Pair getPair() {
        return this.pair;
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println("value of instanceTemp variable is = " + apple.instanceTemp);
        System.out.println("value of staticTemp variable is = " + staticTemp);
        System.out.println(apple);
        IntStream.rangeClosed(1, 5).forEach(i -> {
            apple.instanceTemp = i;
            staticTemp = i;
            System.out.println(apple);
        });
        System.out.println("value of instanceTemp variable is = " + apple.instanceTemp);
        System.out.println("value of staticTemp variable is = " + staticTemp);
    }
}
