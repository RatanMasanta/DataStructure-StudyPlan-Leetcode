package com.masanta.ratan.leetcode.leetcode.seventy.five.part.one;

public class MiddleOfTheLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode middleNode = middleNode(head);
		System.out.println(middleNode.val);

	} 
	
	public static ListNode middleNode(ListNode head) {
		ListNode slowPointer  = head;
		ListNode fastPointer = head;
		while(fastPointer!= null && fastPointer.next != null){
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		return slowPointer;
	}

	private static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
