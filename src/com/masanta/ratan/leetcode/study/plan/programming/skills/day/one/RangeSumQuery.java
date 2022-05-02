package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

public class RangeSumQuery {

	int[] sums;
    
    public RangeSumQuery(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        } 
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }

}
