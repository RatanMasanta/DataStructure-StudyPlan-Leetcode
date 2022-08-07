package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;


public class CheckIfALinkedListisAPalindrome {

	public static void main(String[] args) {
		ListNode targetNode = new ListNode(1);
		targetNode.next = new ListNode(2);
		targetNode.next.next = new ListNode(3);
		targetNode.next.next.next = new ListNode(2);
		targetNode.next.next.next.next = new ListNode(1);
		System.out.println(isPalindrome(targetNode));
	}
	
	 public static boolean isPalindrome(ListNode head) {
	        if(head == null) return false;
	        if( head.next == null){
	            return true;
	        }
	        int length = 0;
	        ListNode sample = head;
	        while(sample != null){
	            length++;
	            sample = sample.next;
	        }
	        int[] array = new int[length];
	        int index = 0;
	        while(head != null){
	            array[index] = head.val;
	            head = head.next;
	            index++;
	        }
	        for(int i = 0; i< length; i++ ){
	            if(array[i] != array[length-1 -i]) return false;
	        }
	        return true;
	        
	    }
	
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
