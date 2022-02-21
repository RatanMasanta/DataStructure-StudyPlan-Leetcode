package com.masanta.ratan.leetcode.study.plan.data.structure.one;

public class MaximumSubArray {

	public static void main(String[] args) {
		System.out.println(maxSubArray(new  int[] {1,2,-4,6,5,-7,8,-2,9,6}));

	}
	
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int lengthOfArray = nums.length;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<lengthOfArray;i++)
        {
            sum=sum+nums[i];
            maxi=Math.max(sum,maxi);
            if(sum<0)
            {
                sum=0;
            }
           
        }
        return maxi;
    }

}
