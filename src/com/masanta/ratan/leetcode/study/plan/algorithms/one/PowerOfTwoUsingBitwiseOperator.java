package com.masanta.ratan.leetcode.study.plan.algorithms.one;

public class PowerOfTwoUsingBitwiseOperator {
	
	/*
	 *  Problem statement
	 *  Given an integer n, return true if it is a power of two. Otherwise, return false.
	 *  An integer n is a power of two, if there exists an integer x such that n == 2x.
	 * 
	 */

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(16));

	}
	
	public static boolean isPowerOfTwo(int n) {
        int ans = n&n-1;
        return n>0 && ans==0;
    }

}
