package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(dailyTemperatures(new int[] {73,74,75,71,69,72,76,73})));
		System.out.println(Arrays.toString(dailyTemperatures1(new int[] {30,60,90})));
	}

	public static int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<>();
		int[] ret = new int[temperatures.length];
		for(int i = 0; i < temperatures.length; i++) {
			while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int idx = stack.pop();
				ret[idx] = i - idx;
			}
			stack.push(i);
		}
		return ret;
	}

	public static int[] dailyTemperatures1(int[] temperatures) {
		int[] stack = new int[temperatures.length];
		int top = -1;
		int[] ret = new int[temperatures.length];
		for(int i = 0; i < temperatures.length; i++) {
			while(top > -1 && temperatures[i] > temperatures[stack[top]]) {
				int idx = stack[top--];
				ret[idx] = i - idx;
			}
			stack[++top] = i;
		}
		return ret;
	}

}
