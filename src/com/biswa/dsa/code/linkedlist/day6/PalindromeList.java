package com.biswa.dsa.code.linkedlist.day6;

import com.biswa.dsa.util.model.obj.ListNode;
import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeList {

    //Time: O(N)
    //space: O(N), O(N/2);
    public static boolean isPalindromeI(ListNode head) {
        boolean flag = true;

        int length = head.getLength();
        int mid = (length/2);
        ListNode cur = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        while (mid-- > 0) {
            stack.push(cur);
            cur = cur.next;
        }

        if (length%2 != 0) cur = cur.next;

        while (null != cur) {
            ListNode curFromStack = stack.pop();
            if (curFromStack.val != cur.val) {
                flag = false;
                break;
            }
            cur = cur.next;
        }

        return flag;
    }

    //Time: O(N)
    //space: O(1)
    public static boolean isPalindromeII(ListNode head) {
        boolean flag = true;

        int length = head.getLength();
        int mid = (length/2);
        ListNode cur = head;

        while (mid-- > 0) {
            cur = cur.next;
        }
        if (length%2 != 0) cur = cur.next;

        ListNode tail = reverseList(cur);
        cur = head;

        while (null != tail) {
            if (cur.val != tail.val) {
                flag = false;
                break;
            }
            cur = cur.next;
            tail = tail.next;
        }

        return flag;
    }

    private static ListNode reverseList(ListNode start) {
        ListNode prev = null, cur = start, next = start.next;

        while (null != next) {
            cur.next = prev;

            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;

        return cur;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode ptr = head;
        for (int i = 2; i <= 4; i++) {
            ptr.next = new ListNode(i);
            ptr = ptr.next;
        }
        for (int i = 4; i > 0; i--) {
            ptr.next = new ListNode(i);
            ptr = ptr.next;
        }
        //ptr.next = new ListNode(12);

        head.printList();
        System.out.println(isPalindromeII(head));
    }

}
