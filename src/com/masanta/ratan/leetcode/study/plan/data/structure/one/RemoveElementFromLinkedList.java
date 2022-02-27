package com.masanta.ratan.leetcode.study.plan.data.structure.one;


public class RemoveElementFromLinkedList {

	
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
		head.next.next.next = new ListNode(91);
		
		ListNode resultantLinkedList = removeElements(head, 4);
		System.out.println("Done");

	}
	
	
	public static ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) {
	  // This takes care of the head same as val given
          head = head.next;
      }  
        ListNode temp = head;
        while(temp != null && temp.next != null) {
            if(temp.next.val == val) {
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return head;
    }

}
