package com.masanta.ratan.leetcode.study.plan.algorithms.two;

public class IntegerBreak {
	
	/*
	 * Statement:
	 * 
	 * Given an integer n, break it into the sum of k positive integers, where k >=
	 * 2, and maximize the product of those integers. Return the maximum product you
	 * can get.
	 */
	
	public static void main(String[] args) {
		System.out.println(integerBreak(25));

	}
	
	 public static int integerBreak(int n) {
         int[] dp = new int[n + 1];
      dp[1] = 1;
      for(int i = 2; i <= n; i ++) {
          for(int j = 1; j < i; j ++) {
              dp[i] = Math.max(dp[i], (Math.max(j,dp[j])) * (Math.max(i - j, dp[i - j])));
          }
      }
      return dp[n];
   }

}
