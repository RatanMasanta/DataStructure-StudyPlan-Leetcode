package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

public class RemovingANodeFromALinkedList {
	
	/*
		Given the head of a linked list, remove the nth node from the end of the list and return its head.
	*/

	public static void main(String[] args) {
		ListNode targetNode = new ListNode(1);
		targetNode.next = new ListNode(2);
		targetNode.next.next = new ListNode(3);
		targetNode.next.next.next = new ListNode(4);
		targetNode.next.next.next.next = new ListNode(5);
		
		ListNode result = removeNthFromEnd(targetNode, 2);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	/*
	Steps-
    
	 Use a dummy variable pointing to head
	
	 Use two pointer fast and slow pointing to dummy variable . Move first pointer for n steps
	
	 Then start moving both until first pointer reaches the last node and slow pointer reaches (size of list - n)th node.
	    
	 Then delete the next node of slow and return dummy.next;
	
	
	 Concept-
	    
	 When you move the fast pointer to nth node, the remaining nodes to traverse is (size_of_linked_list - n).     
	 After that, when you start moving slow pointer and fast pointer by 1 node each, 
	 it is guaranteed that slow pointer will cover a distance of (size_of_linked_list - n) nodes. 
	 And that's node we want to remove.	
	*/
	
	
	public static ListNode removeNthFromEnd(ListNode head, int n) 
    {
        if(head.next==null)
            return null;
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;
        
        for(int i=1;i<=n;i++)
            fast=fast.next;
        
        while(fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        
        slow.next=slow.next.next;
        return dummy.next;
    }
	
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}


