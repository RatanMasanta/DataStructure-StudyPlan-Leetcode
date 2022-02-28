package com.masanta.ratan.leetcode.study.plan.data.structure.one;

import java.util.Stack;



public class ReverseLinkedList {

	
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
			head.next.next.next.next = null;
			
			reverseLinkedList(head);
			System.out.println("Done");
		}
		
		public static ListNode reverseLinkedList(ListNode head) {
	        if(head == null) return null;
	        
	        Stack<ListNode> st = new Stack<>();
	        while(head != null) {
	            st.push(head);
	            head = head.next;
	        }
	        ListNode ret = st.peek();
	        head = ret;
	        st.pop();
	        while(!st.isEmpty()) {
	            head.next = st.peek();
	            st.pop();
	            head = head.next;
	        }
	        head.next = null;
	        
	        return ret;
	    }
}
