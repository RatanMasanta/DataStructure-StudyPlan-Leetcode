package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        
        for(int i : nums) sum+=i;
        
        if(sum%2!=0) return false;
        
        sum /= 2;
        
        boolean[] dp = new boolean[sum+1];
       
        dp[0] = true;

        for (int j : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= j) {
                    dp[i] = dp[i] || dp[i-j];
                }
            }
        }

        return dp[sum];
        
        
    }
	
}
