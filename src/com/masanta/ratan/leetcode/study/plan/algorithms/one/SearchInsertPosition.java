package com.masanta.ratan.leetcode.study.plan.algorithms.one;

import java.util.Arrays;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = new int[] {0,1,2,3,4,5,6,7,8,9,10};
		System.out.println(searchInsert(nums, 8));
	}
	
	public static int searchInsert(int[] nums, int target) {
        if(Arrays.binarySearch(nums, target) < 0)
        {
            for(int i = 0; i < nums.length; ++i)
            {
                if(nums[i] > target)
                    return i;
                if(i == nums.length - 1)
                    return i+1;
            }
        }
        return Arrays.binarySearch(nums, target);
    }

}
