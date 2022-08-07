package com.masanta.ratan.leetcode.leetcode.seventy.five.part.one;

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1}));

	}
	
    // bottom up approach
	
	public static int minCostClimbingStairs(int[] cost) {
		  int n = cost.length;
		  int[] opt = new int[n + 1];
		  opt[0] = 0; // init
		  opt[1] = 0;
		  for (int i = 2; i <= n; ++i) {
		    opt[i] = Math.min(opt[i - 1] + cost[i - 1], opt[i - 2] + cost[i - 2]);
		  }
		  return opt[n];
		}
	
}
