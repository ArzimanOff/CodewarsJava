package com.leetcode.arziman_off.easy;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4, new ListNode(6, new ListNode(8)));

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(5, new ListNode(5));

        ListNode ansNode = mergeTwoLists(l1, l2);

        do {
            System.out.println(ansNode.val);
            ansNode = ansNode.next;
        } while (ansNode != null);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode start;
        if (list1 != null && list2 != null){
            ListNode currentNode = (list1.val < list2.val) ? (list1) : (list2);
            start = currentNode;
            ListNode aNode = (list1.val < list2.val) ? (list2) : (list1);
            ListNode bNode = currentNode.next;

            while (aNode != null && bNode != null){
                if (aNode.val < bNode.val){
                    currentNode.next = aNode;
                    ListNode cNode = aNode.next;
                    currentNode = aNode;
                    aNode = cNode;
                } else {
                    currentNode.next = bNode;
                    ListNode cNode = bNode.next;
                    currentNode = bNode;
                    bNode = cNode;
                }
            }
            if (aNode == null){
                currentNode.next = bNode;
            } else {
                currentNode.next = aNode;
            }
        } else if (list1 == null) {
            start = list2;
        } else if (list2 == null) {
            start = list1;
        } else {
            start = null;
        }

        return start;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
