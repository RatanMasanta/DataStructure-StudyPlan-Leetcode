package com.masanta.ratan.leetcode.study.plan.algorithms.two;

public class ArithmeticSlices {

	public static void main(String[] args) {
		
		int[] nums = new int[] {1,3,5,7,9,11,13,8,9,10};
		
		System.out.println(numberOfArithmeticSlices1(nums));
		System.out.println(numberOfArithmeticSlices(nums));
	}
	
	/*
	 An Arithmetic Slice (AS) is at least 3 ints long, s.t. for a1, a2, a3, they're in arithmetic progression (AP), i.e. a3 - a2 = a2 - a1
	If there's an AS forming at any index, then it'll be 1 longer than the AS forming at the previous index. Why?
	Let a[i], ..., a[j] form an AS of size k, and
	a[j + 1] - a[j] = a[j] - a[j - 1], then a[j + 1] becomes a part of the previous AS, i.e. it extends the AS by 1
	Total AS = sum of all count of AS ending at each index
	Example: nums: [1, 2, 3, 8, 9, 10]
	Let AS[i] denote number of AS ending at this index. 
	By definition AS[0] = AS[1] = 0. Also, AS[i] = 0 for any index for which the current int and previous two ints are not in AP

	nums 1 2 3 8 9 10
	AS   0 0 1 0 0 1

	since 3 - 2 = 2 - 1 ⇒ AS[2] = 1 + AS[1] = 1
	8 - 3 ≠ 3 - 2 ⇒ AS[3] = 0
	9 - 8 ≠ 8 - 3 ⇒ AS[4] = 0 
	10 - 9 = 9 - 8 ⇒ AS[5] = 1 + AS[4] = 1

	Total AS = 1 + 1 = 2 [Ans]
	T/S: O(n)/O(1), where n = size(nums
	)*/

	    public static int numberOfArithmeticSlices1(int[] nums) {
	        var slices = 0;
	        for (int i = 2, prev = 0; i < nums.length; i++)
	            slices += (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) ? 
	                      ++prev : 
	                      (prev = 0);
	        return slices;
	    }
	    
	    public static int numberOfArithmeticSlices(int[] A) {
	        int curr = 0, sum = 0;
	        for (int i=2; i<A.length; i++)
	            if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
	                curr += 1;
	                sum += curr;
	            } else {
	                curr = 0;
	            }
	        return sum;
	    }

}
