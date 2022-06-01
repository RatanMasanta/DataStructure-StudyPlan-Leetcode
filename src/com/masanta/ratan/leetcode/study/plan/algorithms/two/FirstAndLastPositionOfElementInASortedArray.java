package com.masanta.ratan.leetcode.study.plan.algorithms.two;

import java.util.Arrays;

public class FirstAndLastPositionOfElementInASortedArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] {5,7,7,8,8,10}, 8)));
		System.out.println(Arrays.toString(searchRange(new int[] {5,7,7,8,8,10}, 6)));
	}
	
	
	public static int[] searchRange(int[] nums, int target) {
	
	 int start =0;
	    int end = nums.length-1;
		// find first postion and initialize both left pointer and right pointer
	    int posl= findTarget(nums, start, end, target);
		 int posr = posl;
		 
		 // keep track of last valid positions
	    int first = posl;
	    int last = posl;
	   
	    
		// keep searching left of current available index && right of current available index
	    while( posl !=-1 || posr !=-1){
	        if( posl != -1){
	            first = posl;
	            posl = findTarget(nums, start, posl-1, target);
	            
	        } 
	        if(posr != -1){
	            last = posr;
	            posr = findTarget(nums, posr+1, end, target);
	        }
	    }
	    
	    
	    int ans[] = new int[2];
	    if(first == -1){
	        ans[0] = -1;
	        ans[1] = -1;
	    } else{
	        ans[0] = first;
	        ans[1] = last;
	    }
	    
	    return ans;
	}

	// binary search : recursion
	public static int findTarget(int[] nums, int start, int end, int target){
	    if(start > end) return -1;
	    
	    int mid = (start + end)/2;
	    if(nums[mid] == target){
	        return mid;
	    } else if(nums[mid] < target){
	       return  findTarget(nums, mid+1, end, target);
	    } else{
	        return findTarget(nums, start, mid-1, target);
	    }
	}

}
