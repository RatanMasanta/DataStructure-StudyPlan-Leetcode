package com.masanta.ratan.leetcode.study.plan.algorithms.two;

public class EditDistance {
	
	/*
	 * Statement : Given two strings word1 and word2, return the minimum
	 * number of operations required to convert word1 to word2.
	 */
	public static void main(String[] args) {
		System.out.println(minDistance("horse","ros"));

	}

	public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0;i<=word1.length();i++) dp[i][0] = i;
        for(int j = 0;j<=word2.length();j++) dp[0][j] = j;
        for(int i = 0;i<word1.length();i++){
            for(int j = 0;j<word2.length();j++){
                if(word1.charAt(i) == word2.charAt(j)) dp[i+1][j+1] = dp[i][j];
                else dp[i+1][j+1] = Math.min(dp[i][j],Math.min(dp[i+1][j],dp[i][j+1])) + 1;
            }
        }
        return dp[word1.length()][word2.length()];
    }
	
}
