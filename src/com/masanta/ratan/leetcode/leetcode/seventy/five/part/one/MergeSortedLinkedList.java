package com.masanta.ratan.leetcode.leetcode.seventy.five.part.one;

public class MergeSortedLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode head2 = new ListNode(3);
		head2.next = new ListNode(5);
		head2.next.next = new ListNode(6);
		head2.next.next.next = new ListNode(7);
		head2.next.next.next.next = new ListNode(8);
		
		ListNode result = mergeTwoLists(head, head2);
		
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
		

	}

	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1 == null) return l2;
			if(l2 == null) return l1;
			if(l1.val < l2.val){
				l1.next = mergeTwoLists(l1.next, l2);
				return l1;
			} else{
				l2.next = mergeTwoLists(l1, l2.next);
				return l2;
			}
	    }

	 static class ListNode {
	     int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}
