package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

import java.util.Stack;

public class MinStack {
	
	 private int min;
	    private Stack<Integer> stack;
	    public MinStack() {
	        min = Integer.MAX_VALUE;
	        stack = new Stack<>();
	    }

	    public void push(int val) {
	        stack.push(val);
	        if (min>=val){
	            min = val;
	        }
	    }

	    public void pop() {
	        int temp = stack.peek();
	        stack.pop();
	        if (min == temp){
	            min = Integer.MAX_VALUE;
	            for (Integer i : stack){
	                if (min >= i ){
	                    min = i;
	                }
	            }
	        }
	    }

	    public int top() {
	        return stack.peek();
	    }

	    public int getMin() {
	        return min;
	    }

}
