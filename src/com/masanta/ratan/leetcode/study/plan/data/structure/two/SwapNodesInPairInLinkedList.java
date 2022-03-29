package com.masanta.ratan.leetcode.study.plan.data.structure.two;

public class SwapNodesInPairInLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		
		ListNode swappedPair = swapPairs(head);
		System.out.println("Done");

	}
	
	public static ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

}
