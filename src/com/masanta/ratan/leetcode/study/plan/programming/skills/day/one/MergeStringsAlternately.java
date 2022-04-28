package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

public class MergeStringsAlternately {

	/*
	 * Statement
	 * 
	 * You are given two strings word1 and word2. Merge the strings by adding
	 * letters in alternating order, starting with word1. If a string is longer than
	 * the other, append the additional letters onto the end of the merged string.
	 * 
	 * Return the merged string.
	 */

	public static void main(String[] args) {
		System.out.println(mergeAlternatelyTwoPointers("pqrs","ab"));
		System.out.println(mergeAlternatelyOnePointer("abcd","pq"));
	}


	public static String mergeAlternatelyTwoPointers(String w1, String w2) {
		int n = w1.length(), m = w2.length(), i = 0, j = 0;
		StringBuilder res = new StringBuilder();
		while (i < n || j < m) {
			if (i < w1.length())
				res.append(w1.charAt(i++));
			if (j < w2.length())
				res.append(w2.charAt(j++));
		}
		return res.toString();
	}

	public static String mergeAlternatelyOnePointer(String w1, String w2) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < w1.length() || i < w2.length(); ++i) {
			if (i < w1.length())
				res.append(w1.charAt(i));
			if (i < w2.length())
				res.append(w2.charAt(i));
		}
		return res.toString();
	}


}
