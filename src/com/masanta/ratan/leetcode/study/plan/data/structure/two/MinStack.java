package com.masanta.ratan.leetcode.study.plan.data.structure.two;

public class MinStack {

	public static void main(String[] args) {
		int val = 5;
		MinStack obj = new MinStack();
		obj.push(val);
		obj.push( val + 2);
		obj.push(2*val);
		obj.pop();
		int param_3 = obj.top();
		int param_4 = obj.getMin();
		
		System.out.println(param_3);
		System.out.println(param_4);

	}
	private Node head;

	public void push(int x) {
		if (head == null) 
			head = new Node(x, x, null);
		else 
			head = new Node(x, Math.min(x, head.min), head);
	}

	public void pop() {
		head = head.next;
	}

	public int top() {
		return head.val;
	}

	public int getMin() {
		return head.min;
	}

	private class Node {
		int val;
		int min;
		Node next;

		private Node(int val, int min, Node next) {
			this.val = val;
			this.min = min;
			this.next = next;
		}
	}

}
