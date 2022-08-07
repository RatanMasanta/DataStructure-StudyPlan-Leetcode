package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

import java.util.Arrays;

public class SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode l = head;
        int c = 0;
        while(l!=null){
            c++;
            l = l.next;
        }
        int a[] = new int[c];
        l = head;
        int i = 0;
        while(l!=null){
            a[i++] = l.val;
            l = l.next;
        }
        Arrays.sort(a);
        l = head;
        i = 0;
        while(l!=null){
            l.val = a[i++];
            l = l.next;
        }
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
