package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.Arrays;

public class SortColoursWithoutTheLibrary {

	public static void main(String[] args) {
		int[] unsortedArray = new int[]{0,2,1,0,2,1,0,1,2};
		sortColors(unsortedArray);
		System.out.println("Sorted array: " + Arrays.toString(unsortedArray));
		

	}

	/*
	 * Solution discussion: 
	 * 
	 * We traverse the array and use two variables:
	 * 
	 * zeroIndex to indicate the index where we should put 0 /woIndex to indicate
	 * the index where we should put 2 If current element a[i] is 0, we swap a[i]
	 * and a[zeroIndex], if a[i] is 2, we swap a[i] and a[twoIndex], if a[i] is one,
	 * we do nothing and continue to process next element.
	 */
	public static void sortColors(int[] nums) {
		int zeroIndex = 0, twoIndex = nums.length - 1, i = 0;
		while( i <= twoIndex ) {
			if( nums[i] == 0 ) 
				swap(nums, zeroIndex++, i++);
			else if( nums[i] == 2)
				swap(nums, twoIndex--, i);    
			else
				i++;
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
