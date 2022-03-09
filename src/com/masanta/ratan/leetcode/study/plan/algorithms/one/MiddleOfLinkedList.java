package com.masanta.ratan.leetcode.study.plan.algorithms.one;

public class MiddleOfLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode middleNodeOddNumber = middleNode(head);
		head.next.next.next.next.next = new ListNode(6);
		ListNode middleNodeEvenNumber = middleNode(head);
		System.out.println("Done");

	}
	
	/*
	 * Given the head of a singly linked list, return the middle node of the linked list.
	 * If there are two middle nodes, return the second middle node.
	 * 
	 */

	public static ListNode middleNode(ListNode head) {
		ListNode current = head;
		ListNode middle = head;
		int length = 0;
		
		/*-- Adding up the length traversed and moving forward if it's divisible by 2 entirely  --*/
		while(current.next != null){

			length++;

			if(length % 2 == 0){
				middle = middle.next;
			}
			current = current.next;
		}
		
		/*-- Return the second middle for two middles  --*/
		if(length % 2 == 1){
			middle = middle.next;
		}

		return middle;
	}

}
