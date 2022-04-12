package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

import java.util.ArrayList;
import java.util.List;

public class CheckIfAsingleSwapCanMakeStringsEqual {
	
	/*
	 * Statement
	 * 
	 * You are given two strings s1 and s2 of equal length. A string swap is an
	 * operation where you choose two indices in a string (not necessarily
	 * different) and swap the characters at these indices.
	 * 
	 * Return true if it is possible to make both strings equal by performing at
	 * most one string swap on exactly one of the strings. Otherwise, return false.
	 */

	public static void main(String[] args) {
		System.out.println(areAlmostEqual("bank", "kanb"));

	}
	
	 public static boolean areAlmostEqual(String s1, String s2) {
	        List<Integer> l = new ArrayList<>();
	        for (int i = 0; i < s1.length(); i++) {
	            if (s1.charAt(i) != s2.charAt(i)) l.add(i);
				if (l.size() > 2) return false; // added this line to short circuit the loop
	        }
	        return l.size() == 0 || (l.size() == 2
	                                 && s1.charAt(l.get(0)) == s2.charAt(l.get(1))
	                                 && s1.charAt(l.get(1)) == s2.charAt(l.get(0)));
	    }

}
