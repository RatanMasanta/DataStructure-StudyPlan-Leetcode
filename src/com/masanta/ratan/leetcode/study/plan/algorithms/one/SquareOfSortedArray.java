package com.masanta.ratan.leetcode.study.plan.algorithms.one;

public class SquareOfSortedArray {

	public static void main(String[] args) {
		int[] nums = new int[] {1,3,5,8,-1,0,-4,6,-7};
		nums = sortedSquares(nums);
		for(int n: nums) {
			System.out.print(n + " ");
		}
	}

	public static int[] sortedSquares(int[] nums) {
		// for(int i= 0; i< nums.length; i++){
		//     nums[i] *= nums[i];
		// }
		// Arrays.sort(nums);
		// return nums;
		int i = 0;
		int j = nums.length - 1;
		int[] arr = new int[nums.length];
		int k = arr.length - 1;

		while(i <= j)
		{
			if(Math.abs(nums[i]) <= Math.abs(nums[j]))
			{
				arr[k] = nums[j] * nums[j];
				j--;
				k--;
			}

			else{
				arr[k] = nums[i] * nums[i];
				i++;
				k--;
			}
		}

		return arr;
	}

}
