package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

import java.util.Stack;

public class DesignQueue {

	Stack<Integer> stackAux;
	Stack<Integer> queue;

	public DesignQueue() {
		stackAux = new Stack<>();
		queue = new Stack<>();
	}

	public void push(int x) {
		while(!queue.isEmpty()) {
			stackAux.push(queue.pop());
		}
		stackAux.push(x);

		while(!stackAux.isEmpty()) {
			queue.push(stackAux.pop());
		}
	}

	public int pop() {
		return queue.pop();
	}

	public int peek() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.isEmpty();
	}

}
