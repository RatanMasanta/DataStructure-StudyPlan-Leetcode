package com.masanta.ratan.leetcode.study.plan.data.structure.one;

public class CycleCheckLinkedList {


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
//		head.next.next.next.next = head.next.next;
		
		head.next.next.next.next = null;
		
		System.out.println(hasCycle(head));

	}

	public static boolean hasCycle(ListNode head) {
		if(head == null) return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while(slow != fast){
			if(fast == null || fast.next == null) return false;
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}

}
