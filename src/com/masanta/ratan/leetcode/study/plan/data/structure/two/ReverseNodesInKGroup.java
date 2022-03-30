package com.masanta.ratan.leetcode.study.plan.data.structure.two;

public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode reversedLinkedList = reverseKGroup(head,3);
		
		while(reversedLinkedList != null) {
			System.out.println(reversedLinkedList.val);
			reversedLinkedList = reversedLinkedList.next;
		}

	}

	/*
    Reference:
	http://www.cnblogs.com/lichen782/p/leetcode_Reverse_Nodes_in_kGroup.html
	
	First, build a function reverse() to reverse the ListNode between begin and end. See the explanation below:

   /**
	 * Reverse a link list between begin and end exclusively
	 * an example:
	 * a linked list:
	 * 0->1->2->3->4->5->6
	 * |           |   
	 * begin       end
	 * after call begin = reverse(begin, end)
	 * 
	 * 0->3->2->1->4->5->6
	 *          |  |
	 *      begin end
	 * @return the reversed list's 'begin' node, which is the precedence of node end
	 */



	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode begin;
		if (head==null || head.next ==null || k==1)
			return head;
		ListNode dummyhead = new ListNode(-1);
		dummyhead.next = head;
		begin = dummyhead;
		int i=0;
		while (head != null){
			i++;
			if (i%k == 0){
				begin = reverse(begin, head.next);
				head = begin.next;
			} else {
				head = head.next;
			}
		}
		return dummyhead.next;

	}

	public static ListNode reverse(ListNode begin, ListNode end){
		ListNode curr = begin.next;
		ListNode next, first;
		ListNode prev = begin;
		first = curr;
		while (curr!=end){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		begin.next = prev;
		first.next = curr;
		return first;
	}

}
