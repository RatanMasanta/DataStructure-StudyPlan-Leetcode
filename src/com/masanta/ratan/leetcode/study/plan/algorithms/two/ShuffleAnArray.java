package com.masanta.ratan.leetcode.study.plan.algorithms.two;

import java.util.Arrays;

public class ShuffleAnArray {

	public static void main(String[] args) {
		ShuffleAnArray shuffleAnArray = new ShuffleAnArray(new int[] {1,2,3});
		
		int[] param_2 = shuffleAnArray.shuffle();
		int[] param_1 = shuffleAnArray.reset();
		int[] param_3 = shuffleAnArray.shuffle();
		System.out.println(Arrays.toString(param_2));
		System.out.println(Arrays.toString(param_1));
		System.out.println(Arrays.toString(param_3));
	}
	
	static int[] nums;
	public ShuffleAnArray(int[] nums) {
		this.nums = nums;
	}
	
	/** Resets the array to its original configuration and return it. */
	public static int[] reset() {
		return nums;
	}
	
	/** Returns a random shuffling of the array. */
	public static int[] shuffle() {
		int[] res = new int[nums.length];
		res = nums.clone();
		
		for(int i = 0; i < nums.length; i++){
			int rand = (int)(Math.random()*(nums.length - i)) + i;
			swap(res, i, rand);
		}
		return res;
	}
	
	public static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
