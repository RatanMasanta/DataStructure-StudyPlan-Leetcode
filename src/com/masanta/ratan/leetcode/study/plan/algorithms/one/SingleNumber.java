package com.masanta.ratan.leetcode.study.plan.algorithms.one;

public class SingleNumber {

	/*
	 * Problem:
	 * 
	 * Given a non-empty array of integers nums, every element appears twice except
	 * for one. Find that single one.
	 * 
	 * You must implement a solution with a linear runtime complexity and use only
	 * constant extra space.
	 */


	/*
	 * Solution discussion:
	 * 
	 * we use bitwise XOR to solve this problem :
	 * 
	 * first , we have to know the bitwise XOR in java
	 * 
	 * 0 ^ N = N N ^ N = 0 So..... if N is the single number
	 * 
	 * N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
	 * 
	 * = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
	 * 
	 * = 0 ^ 0 ^ ..........^ 0 ^ N
	 * 
	 * = N
	 * 
	 * Also XOR is commutative and associative.
	 * 
	 * Important to Note: Solution would work if you know there are only two
	 * duplicates of each and 1 is single.
	 */


	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] {1,2,5,4,1,2,4,5,6,7,8,8,7}));

	}

	public static int singleNumber(int[] nums) {
		int ans =0;

		int len = nums.length;
		for(int i=0;i!=len;i++)
			ans ^= nums[i];

		return ans;
	}

}
