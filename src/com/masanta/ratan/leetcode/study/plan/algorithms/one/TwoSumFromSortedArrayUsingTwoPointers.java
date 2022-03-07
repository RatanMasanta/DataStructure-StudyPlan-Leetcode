package com.masanta.ratan.leetcode.study.plan.algorithms.one;

import java.util.Arrays;

public class TwoSumFromSortedArrayUsingTwoPointers {

	public static void main(String[] args) {
		int[] nums = new int[] {0,1,2,5,6,7,9,10,21};
		System.out.println(Arrays.toString(twoSum(nums,13)));
	}

	
	public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while (numbers[left] + numbers[right] != target) {
            while (numbers[left] + numbers[right] > target) right--;
            while (numbers[left] + numbers[right] < target) left++;
        }
        return new int[] {left+1, right+1};
    }
}
