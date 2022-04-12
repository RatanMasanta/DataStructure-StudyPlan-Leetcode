package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

public class SignOfTheProductOfAnArray {

	public static void main(String[] args) {
		System.out.println(arraySign(new int[] {1,58,-14,45,-2}));

	}
	
	public static int arraySign(int[] nums) {
        int product = 1;
        for (int i = 0 ; i < nums.length; i++){
            if(nums[i] == 0){
                return 0;
            }
            else if(nums[i] < 0){
                product *= -1;
            }
        }     
        return product; 
    }

}
