package com.masanta.ratan.leetcode.study.plan.data.structure.one;


public class RemoveDuplicatesFromSortedLinkedList {

	//Definition for singly-linked list.
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(7);
		head.next.next.next = new ListNode(-1);
		head.next.next.next.next = new ListNode(7);
		
		deleteDuplicates(head);
		
		System.out.println("Done");


	}

	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null || head.next==null)
			return head;
		head.next = deleteDuplicates(head.next);
		if(head.val == head.next.val)
			return head.next;
		else
			return head;
	}

}
