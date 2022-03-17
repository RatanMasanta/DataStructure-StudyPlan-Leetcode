package com.masanta.ratan.leetcode.study.plan.algorithms.one;

public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(52));

	}

	public static int climbStairs(int n) {
		return solveTD(n);
	}

	private static int solveTD(int n) {
		if(n == 0 || n == 1) return 1;
		int pre = 1;
		int curr = pre;
		for(int i = 2; i <=n; i++) {
			int t = curr + pre;
			pre = curr;
			curr = t;
		}
		return curr;
	}

}
