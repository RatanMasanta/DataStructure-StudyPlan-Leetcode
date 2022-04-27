package com.masanta.ratan.leetcode.study.plan.algorithms.two;

public class CoinChange {
	
	/*
	 * Statement:
	 * 
	 * You are given an integer array coins representing coins of different
	 * denominations and an integer amount representing a total amount of money.
	 * 
	 * Return the fewest number of coins that you need to make up that amount. If
	 * that amount of money cannot be made up by any combination of the coins,
	 * return -1.
	 * 
	 * You may assume that you have an infinite number of each kind of coin.
	 */

	public static void main(String[] args) {
		System.out.println(coinChange(new int[] {1,2,5}, 11));
	}

	public static int coinChange(int[] coins, int amount) {
		if(amount<1) return 0;
		int[] dp = new int[amount+1];
		int sum = 0;

		while(++sum<=amount) {
			int min = -1;
			for(int coin : coins) {
				if(sum >= coin && dp[sum-coin]!=-1) {
					int temp = dp[sum-coin]+1;
					min = min<0 ? temp : (temp < min ? temp : min);
				}
			}
			dp[sum] = min;
		}
		return dp[amount];
	}

}
