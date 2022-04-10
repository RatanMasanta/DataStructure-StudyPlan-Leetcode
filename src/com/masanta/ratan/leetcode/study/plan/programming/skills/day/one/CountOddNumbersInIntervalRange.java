package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

public class CountOddNumbersInIntervalRange {

	public static void main(String[] args) {
		System.out.println(countOdds(12121211, 98989898));

	}
	
	public static int countOdds(int low, int high) {
        return (high + 1) / 2 - low / 2;
    }

}
