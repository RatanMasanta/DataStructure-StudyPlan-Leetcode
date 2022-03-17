package com.masanta.ratan.leetcode.study.plan.algorithms.one;

import java.util.Arrays;

public class HouseRobber {

	/*
	 * Problem statement
	 * 
	 * You are a professional robber planning to rob houses along a street. 
	 * Each house has a certain amount of money stashed, the 
	 * only constraint stopping you from robbing each of them is that adjacent houses 
	 * have security systems connected and it will automatically contact the police if 
	 * two adjacent houses were broken into on the same night.
	 * Given an integer array nums representing the amount of money of each house, 
	 * return the maximum amount of money you can rob tonight without alerting the police.
	 * 
	 * 
	 */

	public static void main(String[] args) {
		System.out.println(rob(new int[] {2,7,9,3,1}));

	}

	public static int memo[];
	
	public static int rob(int[] arr) {
		int n = arr.length;
		memo = new int[n+1];
		Arrays.fill(memo,-1);
		int ans = find(arr,n-1);
		return ans;
	}
	
	public static int find(int arr[],int n)
	{
		if(n<0)
		{
			return 0;
		}
		if(n == 0)
		{
			return arr[0];
		}
		if(n == 1)
		{
			return Math.max(arr[n],arr[n-1]);
		}

		if(memo[n] != -1)
		{
			return memo[n];
		}
		else if(n > 1)
		{
			memo[n] = Math.max(arr[n] + find(arr,n-2),find(arr,n-1));
		}
		else
		{
			memo[n] = find(arr,n-1);
		}
		return memo[n];
	}

}
