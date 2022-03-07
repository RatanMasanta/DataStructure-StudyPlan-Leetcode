package com.masanta.ratan.leetcode.study.plan.algorithms.one;

import java.util.Arrays;

public class MoveZeroes {

	public static void main(String[] args) {
		int[] nums = new int[] {0,1,2,0,5,0,6,7,9,0,2};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void moveZeroes(int[] nums) {

		int j = 0;
		for(int i=0; i<nums.length; i++){
			if(nums[i]!=0){
				nums[j++] = nums[i]; 
			}
		}
		while(j < nums.length){
			nums[j++] = 0;
		}
	}

}
