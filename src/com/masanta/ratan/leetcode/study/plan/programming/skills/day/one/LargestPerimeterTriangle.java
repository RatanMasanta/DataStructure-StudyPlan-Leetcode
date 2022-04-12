package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

import java.util.Arrays;

public class LargestPerimeterTriangle {

	public static void main(String[] args) {
		int[] array  = new int[] {2,1,2};
		int[] array1 = new int[] {5,1,7};
		System.out.println(largestPerimeter1(array));
		System.out.println(largestPerimeter1(array1));
		System.out.println(largestPerimeter2(array));
		System.out.println(largestPerimeter2(array1));

	}
	
	 public static int largestPerimeter1(int[] A) {
         Arrays.sort(A);
         for (int i = A.length - 1; i > 1; --i)
             if (A[i] < A[i - 1] + A[i - 2])
                 return A[i] + A[i - 1] + A[i - 2];
         return 0;
     }
    
       public static int largestPerimeter2(int[] nums) {
        int l2 = getNextLargest(nums, nums.length-1);
        int l3 = getNextLargest(nums, nums.length-2);
        for (int i = nums.length-1; i >= 2; i--) {
            int l1 = l2;
            l2 = l3;
            l3 = getNextLargest(nums, i-2);
            if (!check(l1, l2, l3)) {
                return l1+l2+l3;
            }
        }
        return 0;
        
    }
    
    public static int getNextLargest(int[] nums, int end) {
        int tmp = 0;
        for (int i=0; i<end; i++) {
            if (nums[i] > nums[i+1]) {
                tmp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = tmp;
            }            
        }
        return nums[end];
    }
    
    public static boolean check(int l1, int l2, int l3) {
        if(l1 + l2 <= l3 || l2 + l3 <= l1 || l3 + l1 <= l2) {
            return true;
        }
        return false;
    }

}
