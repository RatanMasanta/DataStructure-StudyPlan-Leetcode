package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGenerationElementI {
	
	/* Problem statement:
	 * 
	 * The next greater element of some element x in an array is the first greater element that is to 
	 * the right of x in the same array.
	 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
	 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater 
	 * element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1. 
	 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
	 * 
	 */

	public static void main(String[] args) {
		int[] nums1 = new int[] {4,1,2};
		int[] nums2 = new int[] {1,3,4,2};
		
		System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
	}
	
	/*Key observation:
	Suppose we have a decreasing sequence followed by a greater number
	For example [5, 4, 3, 2, 1, 6] then the greater number 6 is the next greater element for all previous numbers in the sequence

	We use a stack to keep a decreasing sub-sequence, whenever we see a number x greater than stack.peek() we pop all elements less than x and for all the popped ones, their next greater element is x
	For example [9, 8, 7, 3, 2, 1, 6]
	The stack will first contain [9, 8, 7, 3, 2, 1] and then we see 6 which is greater than 1 so we pop 1 2 3 whose next greater element should be 6
	*/

	    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
	        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
	        Stack<Integer> stack = new Stack<>();
	        for (int num : nums) {
	            while (!stack.isEmpty() && stack.peek() < num)
	                map.put(stack.pop(), num);
	            stack.push(num);
	        }   
	        for (int i = 0; i < findNums.length; i++)
	            findNums[i] = map.getOrDefault(findNums[i], -1);
	        return findNums;
	    }

}
