package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

public class ReorderList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		
		reorderList(head);
		
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}
	
	
	/*
    You are given the head of a singly linked-list. The list can be represented as:

	L0 → L1 → … → Ln - 1 → Ln
	Reorder the list to be on the following form:
	
	L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
	You may not modify the values in the list's nodes. Only nodes themselves may be changed.

	 */


	public static void reorderList(ListNode head) {
		if(head==null||head.next==null) return;

		//Find the middle of the list
		ListNode p1=head;
		ListNode p2=head;
		while(p2.next!=null&&p2.next.next!=null){ 
			p1=p1.next;
			p2=p2.next.next;
		}

		//Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
		ListNode preMiddle=p1;
		ListNode preCurrent=p1.next;
		while(preCurrent.next!=null){
			ListNode current=preCurrent.next;
			preCurrent.next=current.next;
			current.next=preMiddle.next;
			preMiddle.next=current;
		}

		//Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
		p1=head;
		p2=preMiddle.next;
		while(p1!=preMiddle){
			preMiddle.next=p2.next;
			p2.next=p1.next;
			p1.next=p2;
			p1=p2.next;
			p2=preMiddle.next;
		}
	}

}
