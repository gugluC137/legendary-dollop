package com.biswa.dsa.code.recursion.day9;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {

  public static void main(String[] args) {
    int[] arr = {2,3,6,7};
    System.out.println(new CombinationSumI().combinationSum(arr, 7));
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {

    List<List<Integer>> ans = new ArrayList<>();
    ArrayDeque<Integer> subsequence = new ArrayDeque<>();
    getResults(target, candidates, 0, subsequence, ans);

    return ans;
  }

  //time: O(2^t * k) "each place can be picked or not picked t number of times, k is avg length of combinations"
  //space: O(k * y) "unpredictable. x = avg length of combinations, y = no. of combinations"
  public void getResults(
    int target, int[] arr, int idx,
    ArrayDeque<Integer> subsequence, List<List<Integer>> ans) {

    //base case:
    if (idx == arr.length) {
      if (target == 0) ans.add(subsequence.stream().toList());
      return;
    }

    if (target >= 0) {
      subsequence.addLast(arr[idx]);
      getResults(target-arr[idx], arr, idx, subsequence, ans);
      subsequence.removeLast();
    }

    getResults(target, arr, idx+1, subsequence, ans);
  }

}
