package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
	
	/*
	 Given two strings s and p, return an array of all the start indices of p's anagrams in s. 
	 You may return the answer in any order.

	 An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically 
	 using all the original letters exactly once.

	 */

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findAnagrams("cbaebabacd","abc").toArray()));
	}

	public static List<Integer> findAnagrams(String s, String p) {

		int[] map = new int[26];
		for(char c : p.toCharArray()) {
			map[c-'a']++;
		}
		int len = p.length();

		int start = 0;
		int end = 0;

		char[] arr = s.toCharArray();
		List<Integer> ans = new ArrayList<>();

		while(end < arr.length) {

			char c = arr[end];
			if(map[c-'a'] > 0) len--;
			map[c-'a']--;

			while(len == 0) {

				char ch = arr[start];
				if(map[ch-'a'] == 0) len++;
				map[ch-'a']++;

				if(end - start+1 == p.length()) {
					ans.add(start);
				}
				start++;
			} 

			end++;
		}

		return ans;
	}

}
