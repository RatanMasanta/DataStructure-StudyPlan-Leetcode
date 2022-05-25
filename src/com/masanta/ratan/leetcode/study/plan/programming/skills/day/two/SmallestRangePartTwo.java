package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

import java.util.Arrays;

public class SmallestRangePartTwo {
	
	/*
		You are given an integer array nums and an integer k.
				
		For each index i where 0 <= i < nums.length, change nums[i] to be either nums[i] + k or nums[i] - k.
		
		The score of nums is the difference between the maximum and minimum elements in nums.
		
		Return the minimum score of nums after changing the values at each index.
		
		 
		
		Example 1:
		
		Input: nums = [1], k = 0
		Output: 0
		Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.
	 */

	public static void main(String[] args) {
		System.out.println(smallestRangeII(new int[] {0,10}, 2));

	}

	/*
		Intuition:
		For each integer A[i],
		we may choose either x = -K or x = K.
		
		If we add K to all B[i], the result won't change.
		
		It's the same as:
		For each integer A[i], we may choose either x = 0 or x = 2 * K.
		
		Explanation:
		We sort the A first, and we choose to add x = 0 to all A[i].
		Now we have res = A[n - 1] - A[0].
		Starting from the smallest of A, we add 2 * K to A[i],
		hoping this process will reduce the difference.
		
		Update the new mx = max(mx, A[i] + 2 * K)
		Update the new mn = min(A[i + 1], A[0] + 2 * K)
		Update the res = min(res, mx - mn)
		
		Time Complexity:
		O(NlogN), in both of the worst and the best cases.
		In the Extending Reading part, I improve this to O(N) in half of cases.
	 */
	public static int smallestRangeII(int[] A, int K) {
		Arrays.sort(A);
		int n = A.length, mx = A[n - 1], mn = A[0], res = mx - mn;
		for (int i = 0; i < n - 1; ++i) {
			mx = Math.max(mx, A[i] + 2 * K);
			mn = Math.min(A[i + 1], A[0] + 2 * K);
			res = Math.min(res, mx - mn);
		}
		return res;
	}

}
