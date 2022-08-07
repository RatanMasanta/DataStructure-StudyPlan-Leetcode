package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public static int threeSumClosest(int[] nums, int target) {
	        Arrays.sort(nums);
	        var closest = 0;

	        for (int i = 0, n = nums.length, minDiff = Integer.MAX_VALUE; i < n - 2; i++) {
	            var j = i + 1;
	            var k = n - 1;

	            while (j < k) {
	                var sum = nums[i] + nums[j] + nums[k];
	                if (sum == target)
	                    return target;
	                else if (sum < target)
	                    j++;
	                else
	                    k--;

	                var diff = Math.abs(target - sum);
	                if (diff < minDiff) {
	                    minDiff = diff;
	                    closest = sum;
	                }
	            }
	        }
	        return closest;
	    }

}
