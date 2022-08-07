package com.masanta.ratan.leetcode.leetcode.seventy.five.part.one;

import java.util.Arrays;

public class RunningSumOfOneDirectionalArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(runningSum(new int[] {2,4,8,6,-2,4,10})));

	}
	
	public static int[] runningSum(int[] nums) {
        int sum = 0;
        for(int i= 0; i < nums.length ; i++){
            sum += nums[i];
            nums[i]= sum;
        }
        return nums;
    }

}
