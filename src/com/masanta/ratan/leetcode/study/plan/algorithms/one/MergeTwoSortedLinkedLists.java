package com.masanta.ratan.leetcode.study.plan.algorithms.one;


public class MergeTwoSortedLinkedLists {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(7);
		head.next.next.next = new ListNode(91);
		
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(3);
		head2.next.next = new ListNode(4);
		head2.next.next.next = new ListNode(7);
		
		ListNode resultantNode = mergeTwoLists(head, head2);
		System.out.println("Done");

	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;
		while (list1 != null && list2 != null) {
			if (list1.val > list2.val) {
				prev.next = list2;
				list2 = list2.next;
			} else {
				prev.next = list1;
				list1 = list1.next;
			}
			prev = prev.next;
		}
		prev.next = list1 == null ? list2 : list1;

		return dummy.next;
	}

}
