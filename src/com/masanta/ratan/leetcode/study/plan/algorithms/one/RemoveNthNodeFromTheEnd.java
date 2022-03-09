package com.masanta.ratan.leetcode.study.plan.algorithms.one;

public class RemoveNthNodeFromTheEnd {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		ListNode afterRemoval = removeNthFromEnd(head,2);
		System.out.println("Done");

	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode before = null; // len - n
        ListNode after = null;  // len - n + 1

        int len = 0;
        ListNode curr = head; //current node
        
        //Find length of the linkedList
        while(curr != null){
            len++;
            curr = curr.next;
        }
        
        //Base case: if the start is removed
        if(n == len)
            return head.next;

        //reset to head
        curr = head;
        for(int i=1;i<=len;i++){
            if(i == len - n)
                before = curr;
            if(i == len - n + 2)
                after = curr;
            curr = curr.next;
        }
        before.next = after;
        return head;
	}

}
