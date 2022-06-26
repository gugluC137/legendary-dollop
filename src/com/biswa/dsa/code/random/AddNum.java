package com.biswa.dsa.code.random;

import java.util.Arrays;

public class AddNum {

    /**
     * adds the addend to num and returns the final sum
     * @param num array containing all digits in the number, 0 <= num[i] <= 9
     * @param addend number to add, 0 <= addend <= 9
     * @return new array containing digits of the sum
     */
    private static int[] add(int[] num, int addend) {

        //add the addend to num,
        //and get if there is a carry overflow
        boolean carryFlag = addHelper(num, addend);

        //if there is carry,
        //create a new array and return
        //else return the same modified one
        if (carryFlag) {
            return getNewArray(num);
        } else {
            return num;
        }

    }

    private static boolean addHelper(int[] num, int addend) {
        boolean carryFlag = false;
        for (int i = num.length-1; i >= 0; i--) {

            int sum = num[i];
            if (i == num.length-1) {
                sum += addend;
            } else if (carryFlag) {
                sum += 1;
            }

            if (sum <= 9) {
                num[i] = sum;
                carryFlag = false;
                break;
            } else {
                num[i] = sum%10;
                carryFlag = true;
            }
        }

        return carryFlag;
    }

    private static int[] getNewArray(int[] num) {
        int[] newArr = new int[num.length+1];

        System.arraycopy(num, 0, newArr, 1, num.length);
        newArr[0] = 1;

        return newArr;
    }

    public static void main(String[] args) {
        int[] num = {1,9};
        int toAdd = 1;
        System.out.println(Arrays.toString(add(num, toAdd)));
    }

}
