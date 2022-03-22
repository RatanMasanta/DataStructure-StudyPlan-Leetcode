package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {

		int[] productExceptSelfArray = productExceptSelf(new int[] {1,2,6,4,8,20});
		System.out.println(Arrays.toString(productExceptSelfArray));
	}

	/*
		
		Background
		
		Before we look at the constraints, let's just think of solving the problem as is.
		
		At first glance, it becomes evident that we could easily solve this problem in one of two ways:
		
		Calculate the product of every item in the array nums. Then create a result array of the same length as nums, such that for each item in result result[i] = product / nums[i]. This is super simple, and runs in O(n).
		
		Create a result array of the same size as nums. We can calculate the results array by:
		
		for (int i = 0; i < nums.length; i++) {
				results[i] = 1;
				for (int j = 0; j < nums.length; j++) {
					if (i != j) {
						result[i] *= nums[j];
					}
				}
		}
		Now, in this second attempt, what are we actually doing? For each item in the nums array, we manage to get the product of everything in nums but that item itself. How would we explain this a bit more mathematically? Let's try to define how we calculate results[i]:
		
		For all i in the middle of nums (i.e., not at either end):
		    results[i] = nums[0] * ...... * nums[i-1] * nums[i + 1] * ...... * nums[nums.length - 1]
		
		For i = 0:
		    results[i] = nums[i + 1] * ...... * nums[nums.length - 1]
		
		For i = nums.length - 1:
		    results[i] = nums[0] * ...... * nums[i-1]
		Hopefully this spells it out a bit better. Essentially, to get results[i], for any i, we calculate the product everything to the left and to the right of nums[i]. Keep this in mind for later!
		
		Insight
		We know the constraints, and we need to come up with a solution!
		
		Left and Right Products
		Let's say we have an array of integers: [1, 2, 3, 4, 5, 6, 7, 8]. Let's calculate the product of all items except for the 4 (index = 3)
		
		1 * 2 * 3 * 5 * 6 * 7 * 8
		is how we would do that. This product is the product of everything to the left and to the right of 4. This is equivalent to doing:
		
		(1 * 2 * 3) * (5 * 6 * 7 * 8)
		This is the product of the left product (the product of everything on the left) and the right product (the product of everything on the right)
		Now, for any i-th item in nums we should be able to calculate the product of everything but itself, by multiplying its left and right product!
		
		Finding the Left Products (and Right Products) can be done in O(n)!
		Let's try to calculate a left product array, such that for left[i] = the product of everything to the left of nums[i], using this example ([1,2,3,4]).
		
		left[0] = 1 (There is nothing to the left of nums[0], so we set it to 1)
		left[1] = 1 (1 is to the left of nums[0], so we set it to 1)
		left[2] = 1 * 2
		left[3] = 1 * 2 * 3
		
		Look for the pattern in those products (There's a pattern here!)
		left[1] = 1 = left[0] * 1 = left[0] * nums[0]
		left[2] = 1 * 2 = left[1] * 2 = left[1] * nums[1]
		left[3] = 1 * 2 * 3 = left[2] * 3 = left[2] * nums[2]
		
		The pattern: left[i] = left[i-1] * nums[i-1] !!!
		
		We can show a similar situation for the right product array-> right[i] = right[i+1] * nums[i+1]
		
		right[3] = 1 (There is nothing to the left of nums[3], so we set it to 1)
		right[2] = 4 (4 is to the right of nums[2])
		right[1] = 4 * 3
		right[0] = 4 * 3 * 2
		
		Look for the pattern in those products (There's a pattern here!)
		right[2] = 4 = right[3] * 4 = right[3] * nums[3]
		right[1] = 4 * 3 = right[2] * 3 = right[2] * nums[2]
		right[0] = 4 * 3 * 2 = right[1] * 2 = right[1] * nums[1]
		
		Solution
		Now that we know how to calculate the left product array and right product array, we can simply say that results[i] = left[i] * right[i]!!
	*/
	
	
	public static int[] productExceptSelf(int[] nums) {
		// Left is an array containing the left products
		// i.e: left[i] = nums[0] * .... * nums[i-1]  * nums[i]
		int[] left = new int[nums.length];

		// Right is an array containing the array products
		//i.e: right[i] = nums[i] * nums[i+1]  * .... * nums[len(nums)]
		int[] right = new int[nums.length];

		left[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			left[i] = left[i-1] * nums[i-1];
		}

		right[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			right[i] = right[i+1] * nums[i+1];
		}

		int[] product = new int[nums.length];
		for (int i = 0; i < product.length; i++) {
			product[i] = left[i] * right[i];
		}

		return product;
	}

}
