package com.biswa.dsa.code.linkedlist.day5;

import com.biswa.dsa.util.model.obj.ListNode;

public class AddTwoNums {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        ListNode cur = sum;

        int carry = 0, sumAtPos, sumDigit;
        while (null != l1 && null != l2) {
            sumAtPos = carry + l1.val + l2.val;
            if (sumAtPos > 9) {
                sumDigit = sumAtPos%10;
                carry = sumAtPos/10;
            } else {
                sumDigit = sumAtPos;
                carry = 0;
            }

            cur.next = new ListNode(sumDigit);

            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }

        if (null != l1) {
            carry = remainingSum(cur, l1, carry);
        }
        if (null != l2) {
            carry = remainingSum(cur, l2, carry);
        }

        if (carry != 0) {
            while (null != cur.next) {
                cur = cur.next;
            }
            cur.next = new ListNode(carry);
        }

        return sum.next;
    }

    private int remainingSum(ListNode sum, ListNode num, int carry) {
        int sumAtPos, sumDigit;
        while (null != num) {
            sumAtPos = num.val + carry;
            if (sumAtPos > 9) {
                sumDigit = sumAtPos%10;
                carry = sumAtPos/10;
            } else {
                sumDigit = sumAtPos;
                carry = 0;
            }

            sum.next = new ListNode(sumDigit);

            num = num.next;
            sum = sum.next;
        }
        return carry;
    }

    public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        ListNode cur = sum;

        int carry = 0, sumAtPos = 0, sumDigit;
        while (null != l1 || null != l2 || carry == 1){
            sumAtPos += carry;
            if (null != l1) {
                sumAtPos += l1.val;
                l1 = l1.next;
            }
            if (null != l2) {
                sumAtPos += l2.val;
                l2 = l2.next;
            }

            sumDigit = sumAtPos%10;
            carry = sumAtPos/10;

            cur.next = new ListNode(sumDigit);
            cur = cur.next;

            sumAtPos = 0;
        }

        return sum.next;
    }

}
