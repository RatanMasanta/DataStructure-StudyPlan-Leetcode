package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

public class NumberOfOneBits {

	public static void main(String[] args) {
		System.out.println(String.valueOf(hammingWeight2(115)));

	}

	public static int hammingWeight(int n) {
		//Method Brute Force
		// int-->string

		// Method 02:

		int counter=0;

		while (n!=0){
			counter+= (n & 1);
			n=n>>>1;
		}
		return counter;

	}

	/*
	 * In the following solution:
	 * 
	 * Iterate over 32 bits since its a 32-bit integer. 
	 * This will be O(1) since it is in constant time 
	 * Left shift the number by i to get the LSB value 
	 * Do an AND of the number obtained from step 2 with 1. 
	 * If the result of the AND is 1 then
	 * increment the count because the LSB value of that bit was 1.
	 */
	public static int hammingWeight2(int n) {
		int count = 0;
		for(int i=0; i<32; i++){
			count += (n >> i & 1) == 1 ? 1: 0;
		}
		return count;
	}

}
