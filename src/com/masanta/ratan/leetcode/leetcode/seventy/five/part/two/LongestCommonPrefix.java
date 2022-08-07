package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

import java.util.Arrays;

public class LongestCommonPrefix {
	
	/*
		Write a function to find the longest common prefix string amongst an array of strings.

		If there is no common prefix, return an empty string "".

	 */
	public static void main(String[] args) {
		String[] words = new String[] {"flower","flow","flout"};
		System.out.println(longestCommonPrefix(words));
	}
	
	public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while(c < first.length())
        {
            if (first.charAt(c) == last.charAt(c))
                c++;
            else
                break;
        }
        return c == 0 ? "" : first.substring(0, c);
    }

}
