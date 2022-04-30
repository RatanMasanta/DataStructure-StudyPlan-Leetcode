package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

public class MiddleOfTheLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(0);
		head.next.next = new ListNode(1);
		
		ListNode middleNode = middleNode(head);
		
		System.out.println("Done");

	}
	
	 public static ListNode middleNode(ListNode head) {
	       ListNode current = head;
	        ListNode middle = head;
	        int length = 0;
	        
	        while(current.next != null){
	            
	            length++;
	            
	            if(length % 2 == 0){
	                middle = middle.next;
	            }
	            current = current.next;
	        }
	       
	        if(length % 2 == 1){
	            middle = middle.next;
	        }
	        
	        return middle;
	    }

}
