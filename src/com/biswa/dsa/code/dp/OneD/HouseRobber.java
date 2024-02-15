package com.biswa.dsa.code.dp.OneD;

public class HouseRobber {
    public int solWithSpaceOptimisation(int n, int[] nums) {

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev1;
            int cur = Math.max(pick, notPick);

            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }

    public static void main(String[] args) {
        HouseRobber obj = new HouseRobber();

        int[] valueInHouses = {2,1,4,9};
        int n = valueInHouses.length;
        int[] val1 = new int[n-1], val2 = new int[n-1];
        int i1 = 0, i2 = 0;

        for (int i = 0; i < n; i++) {
            if (i != 0) val2[i2++] = valueInHouses[i];
            if (i != n-1) val1[i1++] = valueInHouses[i];
        }

        System.out.println(
                Math.max(obj.solWithSpaceOptimisation(n-1, val1), obj.solWithSpaceOptimisation(n-1, val2)));
    }
}
