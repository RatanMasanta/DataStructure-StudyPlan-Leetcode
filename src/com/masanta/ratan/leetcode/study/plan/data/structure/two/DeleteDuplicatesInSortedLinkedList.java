package com.masanta.ratan.leetcode.study.plan.data.structure.two;

public class DeleteDuplicatesInSortedLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next.next.next = new ListNode(7);
		
		ListNode updatedList = deleteDuplicates(head);
		System.out.println("Done");
		while(updatedList != null) {
			System.out.println(updatedList.val);
			updatedList = updatedList.next;
		}

	}
	
	public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode fast = head;
        ListNode slow = dummy;

            
        while(fast != null && fast.next != null){ 

            if(fast.next != null && fast.val != fast.next.val){
                fast = fast.next;
                slow = slow.next;
                continue;
            }

            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }

            fast = fast.next;
            slow.next = fast;
            
        }

        return dummy.next;
    }

}
