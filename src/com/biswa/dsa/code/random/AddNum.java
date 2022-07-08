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
        int carry = addHelper(num, addend);

        //if there is carry,
        //create a new array and return
        //else return the same modified one
        if (carry != 0) {
            return getNewArray(num);
        } else {
            return num;
        }

    }

    private static int addHelper(int[] num, int addend) {
        int carry = addend, sumAtPos;
        for (int i = num.length-1; i >= 0; i--) {
            sumAtPos = num[i] + carry;
            num[i] = sumAtPos%10;
            carry = sumAtPos/10;
        }

        return carry;
    }

    private static int[] getNewArray(int[] num) {
        int[] newArr = new int[num.length+1];

        newArr[0] = 1;
        System.arraycopy(num, 0, newArr, 1, num.length);

        return newArr;
    }

    public static void main(String[] args) {
        int[] num = {1,2};
        int toAdd = 1;
        System.out.println(Arrays.toString(add(num, toAdd)));
    }

}
