package com.biswa.dsa.code.daily;

import java.util.*;

public class LeastUniqueAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);

        PriorityQueue<Freq> q = new PriorityQueue<>();

        int curElement = arr[0], curFreq = 1;
        for (int i = 1; i < arr.length; i++) {
            if (curElement != arr[i]) {
                q.offer(new Freq(curElement, curFreq));
                curElement = arr[i];
                curFreq = 1;
            } else {
                curFreq++;
            }
        }
        q.offer(new Freq(curElement, curFreq));

        while (!q.isEmpty()) {
            Freq obj = q.peek();
            k -= obj.frequency;
            if (k < 0) {
                break;
            }
            q.poll();
        }

        return q.size();
    }

    public static void main(String[] args) {
        int[] arr = {4,3,1,1,3,3,2};

        System.out.println(new LeastUniqueAfterKRemovals().findLeastNumOfUniqueInts(arr, 3));
    }
}

class Freq implements Comparable<Freq>{
    int element;
    int frequency;

    Freq(int v, int f) {
        this.element = v;
        this.frequency = f;
    }

    @Override
    public int compareTo(Freq obj) {
        if (this.frequency == obj.frequency) {
            return this.element - obj.element;
        } else {
            return this.frequency - obj.frequency;
        }
    }
}
