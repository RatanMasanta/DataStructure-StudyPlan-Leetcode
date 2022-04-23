package com.masanta.ratan.leetcode.study.plan.algorithms.two;

public class JumpGamePartTwo {

	/*
	Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump length at that position.

	Your goal is to reach the last index in the minimum number of jumps.

	You can assume that you can always reach the last index.
	*/
	
	public static void main(String[] args) {
		System.out.println(jump(new int[] {2,3,1,1,4}));

	}

	public static int jump(int[] A) {
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < A.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + A[i]);
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;
			}
		}
		return jumps;
	}

}
