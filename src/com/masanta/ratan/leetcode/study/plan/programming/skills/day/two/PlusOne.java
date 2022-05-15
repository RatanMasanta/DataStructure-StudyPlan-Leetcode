package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[] {4,3,2,1,9,9,8})));
		System.out.println(Arrays.toString(plusOne2(new int[] {4,3,2,1,9,9,8})));

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
	
	public static int[] plusOne2(int[] digits) {
	    int index;
	    for (index = digits.length - 1; index >= 0 && digits[index] == 9; index--) {    // cases with 9
	        digits[index] = 0;
	    }
	    if (index == -1) {  // edge case for all digits are 9, so becomes 1 with n zeroes
	        int[] newDigits = new int[digits.length + 1];
	        newDigits[0] = 1;   // new int[] initialise with zeroes, so set first digit as 1
	        return newDigits;
	    }
	    digits[index]++;    // found the non 9 digit, just add 1
	    return digits;
	}

}
