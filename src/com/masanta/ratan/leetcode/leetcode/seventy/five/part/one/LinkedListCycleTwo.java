package com.masanta.ratan.leetcode.leetcode.seventy.five.part.one;

public class LinkedListCycleTwo {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = head.next;
		
		ListNode cyclePoint = detectCycle(head);
		System.out.println(cyclePoint.val);

	}

	public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
        return null;   // no circle
    }
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow) {  // circle detected
            while (head != fast) {
                fast = fast.next;
                head = head.next;
            }
            return head;
        }
    }
    return null; // no circle
    }
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
}
