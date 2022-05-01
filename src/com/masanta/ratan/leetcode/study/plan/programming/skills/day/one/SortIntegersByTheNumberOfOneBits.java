package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

import java.util.Arrays;
import java.util.Comparator;

public class SortIntegersByTheNumberOfOneBits {

	public static void main(String[] args) {
		int[] unsortedArray = new int [] {0,1,2,3,4,5,6,7,8};
		int[] resultArray = sortByBits(unsortedArray);
		System.out.println(Arrays.toString(resultArray));
	}

	public static int[] sortByBits(int[] arr) {
		return Arrays.stream(arr)
				.boxed()
				.sorted(Comparator.comparingInt(i -> Integer.bitCount(i) * 10000 + i))
				.mapToInt(i -> i)
				.toArray();
	}

}
