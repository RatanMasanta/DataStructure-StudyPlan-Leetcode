package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

public class MonotonicArray {

	public static void main(String[] args) {
		System.out.println(isMonotonic(new int[] {1,2,3,4,7,6}));
		System.out.println(isMonotonic2(new int[] {1}));
	}
	
	
	//TC = O(N) + O(2)
	//SC = O(1)
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
	
	/*
	 * TC = O(N)
	 * SC = O(1)
	 * 
	 */
	
	public static boolean isMonotonic2(int[] A) {
        boolean increase = false;
        boolean decrease = false;
        
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                decrease = true;
            }
            if (A[i] > A[i - 1]) {
                increase = true;
            }
        }
        
        return increase && decrease ? false : true;
    }

}
