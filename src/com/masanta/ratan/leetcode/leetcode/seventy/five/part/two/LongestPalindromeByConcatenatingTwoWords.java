package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

public class LongestPalindromeByConcatenatingTwoWords {
	
	/*
		You are given an array of strings words. Each element of words consists of two lowercase English letters.

		Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. 
		Each element can be selected at most once.
		
		Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
		
		A palindrome is a string that reads the same forward and backward.
		
		 
		
		Example 1:
		
		Input: words = ["lc","cl","gg"]
		Output: 6
		Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
		Note that "clgglc" is another longest palindrome that can be created.
		Example 2:
		
		Input: words = ["ab","ty","yt","lc","cl","ab"]
		Output: 8
		Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
		Note that "lcyttycl" is another longest palindrome that can be created.
		Example 3:
		
		Input: words = ["cc","ll","xx"]
		Output: 2
		Explanation: One longest palindrome is "cc", of length 2.
		Note that "ll" is another longest palindrome that can be created, and so is "xx".


	*/
	
	public static void main(String[] args) {
		String[] words = new String[] {"ab","ty","yt","lc","cl","ab"};
		System.out.println(longestPalindrome(words));

	}
	
	public static int longestPalindrome(String[] words) {
        int counter[][] = new int[26][26];
        int ans = 0;
        for (String w: words) {
            int a = w.charAt(0) - 'a', b = w.charAt(1) - 'a';
            if (counter[b][a] > 0) {
                ans += 4; 
                counter[b][a]--; 
            }
            else counter[a][b]++;
        }
        for (int i = 0; i < 26; i++) {
            if (counter[i][i] > 0) {
                ans += 2;
                break;
            }
        }
        return ans;
    }

}
