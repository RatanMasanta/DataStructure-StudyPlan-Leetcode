package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

public class FindsTheDifference {

	public static void main(String[] args) {
		
		System.out.println(findTheDifference("abcd", "abcde"));
	}

	public static char findTheDifference(String s, String t) {
        char c = 0;
        for(char cs : s.toCharArray()) c ^= cs;
        for(char ct : t.toCharArray()) c ^= ct;
        return c;
    }
	
}
