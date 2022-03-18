package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

	/*
	 * Problem statement
	 * 
	 * Given an integer array nums, return all the triplets [nums[i], nums[j],
	 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
	 * nums[k] == 0.
	 * 
	 * Notice that the solution set must not contain duplicate triplets.
	 */
	
	public static void main(String[] args) {
		List<List<Integer>> result = threeSum(new int[] {-1,0,1,2,-1,-4});
		System.out.println("Done");
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		int maxVal = Integer.MIN_VALUE;
		int minVal = Integer.MAX_VALUE;
		int negNums = 0;
		int posNums = 0;
		List<List<Integer>> result = new LinkedList<>();
		int zeroNums = 0;
		for (int num : nums) {
			if (num < minVal)  minVal = num;
			if (num > maxVal)  maxVal = num;
			if (num == 0)
				zeroNums++;
			else if (num > 0)
				posNums++;
			else
				negNums++;
		}
		if (zeroNums >= 3)  result.add(Arrays.asList(0, 0, 0));
		if (minVal >= 0 || maxVal <= 0)  return result;
		int[] negNumMap = new int[negNums];
		int[] posNumMap = new int[posNums];
		int posStart = 0;
		if (maxVal + 2 * minVal > 0)  maxVal = -2 * minVal;
		if (minVal + 2 * maxVal < 0)  minVal = -2 * maxVal;
		byte[] numMap = new byte[maxVal - minVal + 1];
		negNums = 0;
		posNums = 0;
		for (int num : nums)
			if (num >= minVal && num <= maxVal){
				if (numMap[num - minVal]++ != 0)
					numMap[num - minVal] = 2;
				else
					if (num > 0) {
						posNumMap[posNums++] = num;
					} else if (num < 0) {
						negNumMap[negNums++] = num;
					}
			}
		Arrays.parallelSort(posNumMap, 0, posNums);
		Arrays.parallelSort(negNumMap, 0, negNums);
		for (int i = negNums - 1; i >= 0; i--) {
			int nv = negNumMap[i];
			int minpv = (-nv) / 2;
			while (posStart < posNums && posNumMap[posStart] < minpv)
				posStart++;
			for (int j = posStart; j < posNums; j++) {
				int pv = posNumMap[j];
				int ln = 0 - nv - pv;
				if (ln >= nv && ln <= pv) {
					if (numMap[ln - minVal] == 0) {
						continue;
					} else if (ln == pv || ln == nv) {
						if (numMap[ln - minVal] > 1)
							result.add(Arrays.asList(nv, pv, ln));
					} else {
						result.add(Arrays.asList(nv, pv, ln));
					}
				} else if (ln < nv) {
					break;
				}
			}
		}
		return result;
	}

}
