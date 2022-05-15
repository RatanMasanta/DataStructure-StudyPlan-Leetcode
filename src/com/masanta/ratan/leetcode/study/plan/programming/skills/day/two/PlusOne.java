package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[] {4,3,2,1,9,9,8})));

	}

	public static int[] plusOne(int[] digits) {
		int n = digits.length;
		for(int i=n-1; i>=0; i--) {
			if(digits[i] < 9) {
				digits[i]++;
				return digits;
			}

			digits[i] = 0;
		}

		int[] newNumber = new int [n+1];
		newNumber[0] = 1;

		return newNumber;

	}

}
