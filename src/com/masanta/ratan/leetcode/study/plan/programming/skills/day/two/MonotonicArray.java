package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

public class MonotonicArray {

	public static void main(String[] args) {
		System.out.println(isMonotonic(new int[] {1,2,3,4,7,6}));

	}
	public static boolean isMonotonic(int[] nums) {
        int first = nums[0];
        int last = nums[nums.length - 1];
        if(first > last){
            for(int i = 0; i <nums.length - 1; i++){
                if(nums[i] < nums[i+1]) return false;
            }
        } else if (first < last){
            for(int i = 0; i <nums.length - 1;i++){
                if(nums[i] > nums[i+1]) return false;
            }
        } else{
            for(int i = 0; i <nums.length - 1; i++){
                if(nums[i] != nums[i+1]) return false;
            }
        }
        return true;
    }

}
