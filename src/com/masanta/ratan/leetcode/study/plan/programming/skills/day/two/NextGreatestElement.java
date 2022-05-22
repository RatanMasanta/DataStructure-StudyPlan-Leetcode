package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatestElement {
	
	/*
	Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), 
	return the next greater number for every element in nums.

	The next greater number of a number x is the first greater number to its traversing-order next in the array, 
	which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

	 

	Example 1:

	Input: nums = [1,2,1]
	Output: [2,-1,2]
	Explanation: The first 1's next greater number is 2; 
	The number 2 can't find next greater number. 
	The second 1's next greater number needs to search circularly, which is also 2.
	 */

	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,4,3,0};
		System.out.println(Arrays.toString(nextGreaterElements2(nums)));
		System.out.println(Arrays.toString(nextGreaterElements1(nums)));
	}
	
	/*
    Explanation
    Loop once, we can get the Next Greater Number of a normal array.
    Loop twice, we can get the Next Greater Number of a circular array


    Complexity
    Time O(N) for one pass
    Spce O(N) in worst case

    */	
	
	 public static int[] nextGreaterElements1(int[] A) {
         int n = A.length, res[] = new int[n];
         Arrays.fill(res, -1);
         Stack<Integer> stack = new Stack<>();
         for (int i = 0; i < n * 2; i++) {
             while (!stack.isEmpty() && A[stack.peek()] < A[i % n])
                 res[stack.pop()] = A[i % n];
             stack.push(i % n);
         }
         return res;
     }
	 
    public static int[] nextGreaterElements2(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            stack.push(nums[i]);
        }
        
        int greater[]=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i]){
                    stack.pop();
                }
            greater[i]=stack.empty()?-1:stack.peek();
            stack.push(nums[i]);
        }
        
        return greater;
    }

}
