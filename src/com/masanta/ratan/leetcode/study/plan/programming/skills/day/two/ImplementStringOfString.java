package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

public class ImplementStringOfString {
	
	/*
	 * Given two strings needle and haystack, return
	 *  the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
	 * 
	 */

	public static void main(String[] args) {
		System.out.println(strStr("hello world","l"));

	}
	
	public static int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        return haystack.indexOf(needle);
    }

}
