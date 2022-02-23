package com.masanta.ratan.leetcode.study.plan.data.structure.one;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] arrayOne = new int[] {1,2,3,4,0,0,0,0};
		int arrayTwo[] = new int[] {2,3,5,9};
		
		merge(arrayOne, arrayOne.length, arrayTwo, arrayTwo.length);
		System.out.println(Arrays.toString(arrayOne));

	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p=nums1.length-1, p1=m-1, p2=n-1;

    while(p1>=0 && p2>=0)
    {

        if(nums2[p2]>nums1[p1])
        {    
            nums1[p]=nums2[p2];
            p2--;
        }
        else 
        {
            nums1[p]=nums1[p1];
            p1--;
        }
        p--;
        System.out.println(p+" "+p1+" "+p2);
    }
    
    /*The above while loop won't be visited when (Input: nums1 = [0], m = 0, nums2 = [1], n = 1), as p1=-1.
    Output: [1]
    Explanation: The arrays we are merging are [] and [1].
    p1=-1. So, in that case only add nums[p2] to nums[p];
    */
    while(p2>=0)        
    {
        nums1[p] = nums2[p2];
        p2--;
        p--;
    }
        
    }
	
	/*
	 * My Own method
	 * 
	 * 
	 */
	
	public static void mergeLocal(int[] nums1, int m, int[] nums2, int n) {
		
	}
}
