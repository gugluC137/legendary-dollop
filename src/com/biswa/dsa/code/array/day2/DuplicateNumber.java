package com.biswa.dsa.code.array.day2;

public class DuplicateNumber {

    public int findDuplicate(int[] nums) {
        boolean[] arr = new boolean[nums.length - 1];
        int ans = 0;
        for (int i: nums) {
            if (arr[i]) {
                ans = i; break;
            }
           arr[i] = true;
        }
        return ans;
    }

    public int findDuplicateByTracingCycle(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }

    public int findDuplicateOpt(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr < 0) curr *= -1;
            int next = nums[curr];
            if(next < 0) {
                ans = curr; break;
            } else {
                nums[curr] = next * -1;
            }
        }

        return ans;
    }

}
