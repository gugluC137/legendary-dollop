package com.biswa.dsa.code.recursion.day9;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> ans = new ArrayList<>();
    ArrayDeque<Integer> subsequence = new ArrayDeque<>();

    getResults(target, candidates, 0, subsequence, ans);
    return ans;
  }

  //time: O(2^t * k) "worst case scenario: all elements are unique, k is avg length of combinations"
  //space: O(k * y) "unpredictable. x = avg length of combinations, y = no. of combinations"
  public void getResults(
    int target, int[] arr, int idx,
    ArrayDeque<Integer> subsequence, List<List<Integer>> ans) {

    if (target == 0) {
      ans.add(subsequence.stream().toList());
      return;
    }

    for (int i = idx; i < arr.length; i++) {
      if (i > idx && arr[i] == arr[i-1]) continue;
      if (arr[i] > target) break;

      subsequence.addLast(arr[i]);
      getResults(target - arr[i], arr, i+1, subsequence, ans);
      subsequence.removeLast();
    }
  }

  public static void main(String[] args) {
    int[] arr = {1,2,1,1,2};
    System.out.println(new CombinationSumII().combinationSum2(arr, 4));
  }

}
