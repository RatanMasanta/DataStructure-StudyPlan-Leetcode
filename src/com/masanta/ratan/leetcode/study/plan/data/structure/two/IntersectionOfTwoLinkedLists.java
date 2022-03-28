package com.masanta.ratan.leetcode.study.plan.data.structure.two;

public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		ListNode head = new ListNode(5);
		head.next = new ListNode(6);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		/*
		 * head.next.next.next.next.next.next = new ListNode(6);
		 * head.next.next.next.next.next.next.next = new ListNode(6);
		 * head.next.next.next.next.next.next.next.next = new ListNode(7);
		 */
		
		
		ListNode head1 = new ListNode(4);
		head1.next = new ListNode(1);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(8);
		head1.next.next.next.next = new ListNode(4);
		head1.next.next.next.next.next = new ListNode(5);
//		head1.next.next.next.next.next.next.next = new ListNode(6);
//		head1.next.next.next.next.next.next.next.next = new ListNode(7);
		
		ListNode resultantListNode1 = getIntersectionNode(head, head1);
		ListNode resultantListNode2 = getIntersectionNode2(head, head1);
		
		System.out.println("Done");

	}
	
	/*
	 * Solution
	 * 
	 * I found most solutions here preprocess linkedlists to get the difference in len.
	Actually we don't care about the "value" of difference, we just want to make sure two pointers 
	reach the intersection node at the same time.

	We can use two iterations to do that. In the first iteration, we will reset the pointer of one 
	linkedlist to the head of another linkedlist after it reaches the tail node. In the second iteration, we 
	will move two pointers until they points to the same node. Our operations in first iteration will help us 
	counteract the difference. So if two linkedlist intersects, the meeting point in second iteration must be 
	the intersection point. If the two linked lists have no intersection at all, then the meeting pointer in 
	second iteration must be the tail node of both lists, which is null

	Below is my commented Java code:
	*/

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    //boundary check
	    if(headA == null || headB == null) return null;
	    
	    ListNode a = headA;
	    ListNode b = headB;
	    
	    //if a & b have different len, then we will stop the loop after second iteration
	    while( a != b){
	    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
	        a = a == null? headB : a.next;
	        b = b == null? headA : b.next;    
	    }
	    
	    return a;
	}
	
	
	/*
	 * 
	 * With measuring length
	 * 
	 * 1, Get the length of the two lists.
	 * 
	 * 2, Align them to the same start point.
	 * 
	 * 3, Move them together until finding the intersection point, or the end null
	 */

	public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
	    int lenA = length(headA), lenB = length(headB);
	    // move headA and headB to the same start point
	    while (lenA > lenB) {
	        headA = headA.next;
	        lenA--;
	    }
	    while (lenA < lenB) {
	        headB = headB.next;
	        lenB--;
	    }
	    // find the intersection until end
	    while (headA != headB) {
	        headA = headA.next;
	        headB = headB.next;
	    }
	    return headA;
	}

	private static int length(ListNode node) {
	    int length = 0;
	    while (node != null) {
	        node = node.next;
	        length++;
	    }
	    return length;
	}

}
