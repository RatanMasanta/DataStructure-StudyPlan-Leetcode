package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopKFrequentElements {
	
	/*
	 * Given an integer array nums and an integer k, return the k most frequent
	 * elements. You may return the answer in any order.
	 */

	public static void main(String[] args) {
		int[] nums = new int[] {1,1,1,2,2,3};
		System.out.println(Arrays.toString(topKFrequent(nums, 2)));

	}
	
	public static int[] topKFrequent(int[] nums, int k) {
        int min = nums[0], max = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int[] counts = new int[max - min + 1];
        for (int i = 0; i < nums.length; ++i) {
            counts[nums[i] - min]++;
        }
        List<Integer>[] count2num = new List[nums.length+1];
        for (int i = 0; i < counts.length; ++i) {
            if (counts[i] == 0) {
                continue;
            }
            int n = i + min;
            if (count2num[counts[i]] == null) {
                count2num[counts[i]] = new ArrayList<>();
            }
            count2num[counts[i]].add(n);
        }
        int[] result = new int[k];
        for (int i = count2num.length - 1; i >= 0 && k > 0; --i) {
            if (count2num[i] != null) {
                for (int n : count2num[i]) {
                    result[--k] = n;
                    if (k == 0) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

}
