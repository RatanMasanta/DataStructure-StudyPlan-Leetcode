package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        ListNode even =  head.next;      // this pointer start from index 2(1 based indexing )
        ListNode odd =  head;           // this pointer start from index 1
        ListNode evenhead =  head.next;// this pointer needed to concat odd and even linked list
        
         // how do we decide our loop condition 
        // the pointer on index 2 will decide loop condition  as it is 1 step ahead odd pointer 
        while(even!=null && even.next!=null){
             // as each odd or even element present at gap of 2 step
            // put 2 step ahead element pointer into current odd index element 
            odd.next =  odd.next.next; 
            // put 2 step ahead element pointer into current even index element 
            even.next =  even.next.next;
            
            // after updating move odd and even, to new element pointer inserted into its next 
            odd  =  odd.next;
            even =  even.next;
        }
        // concat odd number linked tail with , head of even number linked list
        odd.next =  evenhead;
            
            return head;                        
    }
	
	private static class ListNode {
		     int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }

}
