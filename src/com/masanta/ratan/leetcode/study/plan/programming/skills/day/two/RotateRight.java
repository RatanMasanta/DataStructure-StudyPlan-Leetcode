package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

public class RotateRight {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode result = rotateRight(head, 3);

		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}


	/*
    Since n may be a large number compared to the length of list. So we need to know the length of linked list.
    After that, move the list after the (l-n%l )th node to the front to finish the rotation.

	Ex: {1,2,3} k=2 Move the list after the 1st node to the front

	Ex: {1,2,3} k=5, In this case Move the list after (3-5%3=1)st node to the front.

	So the code has three parts.

	Get the length

	Move to the (l-n%l)th node

	3)Do the rotation
	 */
	public static ListNode rotateRight(ListNode head, int n) {
		if (head==null||head.next==null) return head;
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode fast=dummy,slow=dummy;

		int i;
		for (i=0;fast.next!=null;i++)//Get the total length 
			fast=fast.next;

		for (int j=i-n%i;j>0;j--) //Get the i-n%i th node
			slow=slow.next;

		fast.next=dummy.next; //Do the rotation
		dummy.next=slow.next;
		slow.next=null;

		return dummy.next;
	}

}
