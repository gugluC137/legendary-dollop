package com.biswa.dsa.code.random;

import java.util.ArrayDeque;

public class SubsequencesProblems {

  public static void main(String[] args) {
    int[] arr = {3,1,2};
    SubsequencesProblems obj = new SubsequencesProblems();

    obj.printAllSubsequences(arr, 0, new ArrayDeque<>());
    System.out.println();
    obj.printAllSubSequencesWhereSum(3, arr, 0, 0, new ArrayDeque<>());
    System.out.println();
    obj.printFirstSubSequencesWhereSum(3, arr, 0, 0, new ArrayDeque<>());
    System.out.println();
    System.out.println(obj.countNumberOfSubSequencesWhereSum(3, arr, 0, 0));
  }

  //time: O(N*2^n) "extra N for printing the subsequence"
  //space: O(N) "auxiliary stack space and list is of N size max"
  public void printAllSubsequences(
    int[] arr, int idx, ArrayDeque<Integer> subsequence) {

    //base case
    if (idx == arr.length) {
      System.out.println(subsequence);
      return;
    }

    // pick up arr[idx] for the subsequence
    subsequence.addLast(arr[idx]);
    printAllSubsequences(arr, idx+1, subsequence);

    // don't pick up arr[idx] for the subsequence
    subsequence.removeLast();
    printAllSubsequences(arr, idx+1, subsequence);
  }

  //time: O(N*2^n) "extra N for printing the subsequence"
  //space: O(N) "auxiliary stack space and list is of N size max"
  public void printAllSubSequencesWhereSum(
    int target, int[] arr, int idx, int sum, ArrayDeque<Integer> subsequence) {

    // base case
    if (idx == arr.length) {
      if (sum == target) {
        System.out.println(subsequence);
      }
      return;
    }

    // pick up arr[idx] for the subsequence
    subsequence.addLast(arr[idx]);
    sum += arr[idx];
    printAllSubSequencesWhereSum(target, arr, idx+1, sum, subsequence);

    // don't pick up arr[idx] for the subsequence
    subsequence.removeLast();
    sum -= arr[idx];
    printAllSubSequencesWhereSum(target, arr, idx+1, sum, subsequence);
  }

  //time: O(N*2^n) "extra N for printing the subsequence"
  //space: O(N) "auxiliary stack space and list is of N size max"
  public boolean printFirstSubSequencesWhereSum(
    int target, int[] arr, int idx, int sum, ArrayDeque<Integer> subsequence) {

    // base case
    if (idx == arr.length) {
      if (sum == target) {
        System.out.println(subsequence);
        return true;
      }
      return false;
    }

    // pick up arr[idx] for the subsequence
    subsequence.addLast(arr[idx]);
    sum += arr[idx];
    if (printFirstSubSequencesWhereSum(target, arr, idx+1, sum, subsequence)) {
      return true;
    }

    // don't pick up arr[idx] for the subsequence
    subsequence.removeLast();
    sum -= arr[idx];
    return printFirstSubSequencesWhereSum(target, arr, idx + 1, sum, subsequence);
  }

  //time: O(2^n)
  //space: O(N) "only auxiliary stack space"
  public int countNumberOfSubSequencesWhereSum(int target, int[] arr, int idx, int sum) {

    if (idx == arr.length) {
      if (target == sum) {
        return 1;
      }
      return 0;
    }

    int ans = 0;

    sum += arr[idx];
    ans += countNumberOfSubSequencesWhereSum(target, arr, idx+1, sum);

    sum -= arr[idx];
    ans += countNumberOfSubSequencesWhereSum(target, arr, idx+1, sum);

    return ans;
  }

}
