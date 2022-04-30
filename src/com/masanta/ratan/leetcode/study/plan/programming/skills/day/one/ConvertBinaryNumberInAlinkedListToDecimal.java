package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

import java.util.Stack;

public class ConvertBinaryNumberInAlinkedListToDecimal {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(0);
		head.next.next = new ListNode(1);
		
		System.out.println(getDecimalValue(head));

	}

	
	public static int getDecimalValue(ListNode head) {
	       ListNode current = head;
	        Stack<Integer> stack = new Stack<>();
	        while (current != null) {
	            stack.add(current.val);
	            current = current.next;
	        }
	        int sum = 0;
	        int index = 0;
	        while (!stack.isEmpty()) {
	            if (stack.pop() == 1) {
	                sum = sum + (int)Math.pow(2, index);
	            }
	            index++;
	        }
	        return sum;
	        
	    }
	
	
	
}
