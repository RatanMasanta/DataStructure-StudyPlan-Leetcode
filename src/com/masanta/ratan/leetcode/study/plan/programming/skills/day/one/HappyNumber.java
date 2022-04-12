package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

import java.util.HashSet;

public class HappyNumber {
	
	/*Problem statement
	
	Write an algorithm to determine if a number n is happy.

	A happy number is a number defined by the following process:

	Starting with any positive integer, replace the number by the sum of the squares of its digits.
	Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
	Those numbers for which this process ends in 1 are happy.
	Return true if n is a happy number, and false if not.
	*/

	public static void main(String[] args) {
		System.out.println(isHappy(19));
		System.out.println(isHappy1(2));

	}


	public static boolean isHappy1(int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(n);
		while (n != 1) {
			int result = 0;
			while (n != 0) {
				result += Math.pow(n % 10, 2);
				n /= 10;
			}
			if (set.contains(result)) {
				return false;
			}
			set.add(result);
			n = result;
		}
		return true;
	}

	public static int getNext(int n) {
		int totalSum = 0;
		while (n > 0) {
			int d = n % 10;
			n = n / 10;
			totalSum += d * d;
		}
		return totalSum;
	}

	public static boolean isHappy(int n) {
		int slowRunner = n;
		int fastRunner = getNext(n);
		while (fastRunner != 1 && slowRunner != fastRunner) {
			slowRunner = getNext(slowRunner);
			fastRunner = getNext(getNext(fastRunner));
		}
		return fastRunner == 1;
	}

}
