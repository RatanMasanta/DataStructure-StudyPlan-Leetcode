package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

public class SubArrayProductLessThanK {
	
	/*
		Given an array of integers nums and an integer k, return the number of contiguous subarrays 
		where the product of all the elements in the subarray is strictly less than k.
			
		Example 1:

		Input: nums = [10,5,2,6], k = 100
		Output: 8
		Explanation: The 8 subarrays that have product less than 100 are:
		[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
		Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
	*/

	public static void main(String[] args) {
		System.out.println(numSubarrayProductLessThanK(new int[] {10,2,6,4,30,51,60,3,50,40}, 120));

	}
	
	public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
	        
	        int ans=0;
	        int prod=nums[0];
	        if(prod<k)  ans++;
	        int left=0;
	        int right=1;
	        while(right!=nums.length){
	            int val=nums[right];
	            prod=prod*val;
	            
	            if(prod<k){
	                ans+=right-left+1;
	            }else{
	                while(prod>=k){
	                    prod=prod/nums[left];
	                    left++;
	                }
	                ans+=right-left+1;
	            }
	            right++;
	        }
	        return ans;
    }

}
