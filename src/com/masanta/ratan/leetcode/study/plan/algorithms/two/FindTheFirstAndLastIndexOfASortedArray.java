package com.masanta.ratan.leetcode.study.plan.algorithms.two;

import java.util.Arrays;

public class FindTheFirstAndLastIndexOfASortedArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] {5,7,7,8,8,10}, 8)));
		System.out.println(Arrays.toString(searchRange(new int[] {5,7,7,8,8,10}, 6)));

	}

	//There must be two indices in the array. Which means, we can just simply apply to binary search twice to find each index of the target element.
	public static int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = findFirst(nums, target);
		result[1] = findLast(nums, target);
		return result;
	}

	private static int findFirst(int[] nums, int target){
		int idx = -1;
		int start = 0;
		int end = nums.length - 1;
		while(start <= end){
			int mid = (start + end) / 2;
			if(nums[mid] >= target){
				end = mid - 1;
			}else{
				start = mid + 1;
			}
			if(nums[mid] == target) idx = mid;
		}
		return idx;
	}

	private static int findLast(int[] nums, int target){
		int idx = -1;
		int start = 0;
		int end = nums.length - 1;
		while(start <= end){
			int mid = (start + end) / 2;
			if(nums[mid] <= target){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
			if(nums[mid] == target) idx = mid;
		}
		return idx;
	}

}
