package com.leetcode.arziman_off.easy;

// https://leetcode.com/problems/add-two-numbers/description/

public class AddTwoNumberByLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(3, new ListNode(8, new ListNode(1)));


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1, new ListNode(2));

        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode current = answer;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        // просто вывод полученного связного списка
        do {
            System.out.println(answer.next.val);
            answer.next = answer.next.next;
        } while (answer.next != null);

        return answer.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}