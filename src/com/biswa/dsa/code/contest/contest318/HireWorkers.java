package com.biswa.dsa.code.contest.contest318;

import java.util.PriorityQueue;

public class HireWorkers {

  public long totalCost(int[] costs, int k, int candidates) {
    long cost = 0;

    PriorityQueue<Integer> pr1 = new PriorityQueue<>(candidates);
    PriorityQueue<Integer> pr2 = new PriorityQueue<>(candidates);

    int hireCount = 0;
    int idx1 = 0, idx2 = costs.length-1;

    while (hireCount < k) {
      while (pr1.size() < candidates && idx1 <= idx2) {
        pr1.add(costs[idx1++]);
      }
      while (pr2.size() < candidates && idx2 >= idx1) {
        pr2.add(costs[idx2--]);
      }

      int e1 = !pr1.isEmpty() ? pr1.peek() : Integer.MAX_VALUE;
      int e2 = !pr2.isEmpty() ? pr2.peek() : Integer.MAX_VALUE;

      if (e1 <= e2) {
        cost += e1;
        System.out.print(pr1.poll() + ", ");
      } else {
        cost += e2;
        System.out.print(pr2.poll() + ", ");
      }
      hireCount++;
    }

    return cost;
  }

  public static void main(String[] args) {
    int[] arr = {17,12,10,2,7,2,11,20,8};
    System.out.println("\ncost: " + new HireWorkers().totalCost(arr, 3, 4));
  }

}
