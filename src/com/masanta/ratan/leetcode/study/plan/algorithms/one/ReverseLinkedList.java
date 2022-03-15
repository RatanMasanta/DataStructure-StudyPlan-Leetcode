package com.masanta.ratan.leetcode.study.plan.algorithms.one;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode reversedList = reverseList(head);
		
		System.out.println("Reversed the linked list successfully");

	}

	public static ListNode reverseList(ListNode head) {
	       ListNode prev = null;
	        while(head!= null){
	            ListNode next = head.next;
	            head.next = prev;
	            prev = head;
	            head = next;
	        }
	        return prev;
	    }
	
}
